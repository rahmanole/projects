/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.Connection;
import controller.pojo.Manager;
import controller.pojo.MonthReport;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.conn.ConnectionForDB;

/**
 *
 * @author OLEE
 */
public class MonthReportService {

    MonthDetailsServices monthDetailsServices = new MonthDetailsServices();
    HelperServices helperServices = new HelperServices();
    MealDetailsServices mealDetailsServices = new MealDetailsServices();
    MealHistoryServices mealHistoryServices = new MealHistoryServices();

    public boolean isMonthExists(String monthName, String year) {
        String sql = "select * from manager where month_name=? and year=?";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, monthName);
            ps.setString(2, year);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public MonthReport getMonthReport(List<Manager> managerList, String onOrOff) {
        Manager manager = managerList.get(0);
        int totalActiveMember = MealHistoryServices.getCardList(manager).size();
        int totalOnMeal = 0;
        int totalOffMeal = 0;
        int totalNormalOffMeal = 0;
        int totalFridayOffMeal = 0;
        int totalFeastOffMeal = 0;
        double spentExpense = mealDetailsServices.getSpentExpense(manager);
        double balance = mealDetailsServices.getBalance(manager);
        double thisMonthTotalExpense = monthDetailsServices.getTotalExpense(manager);

        MonthReport monthReport;

        for (Date date : MonthDetailsServices.getActualDateListOfMonth(manager)) {
            
            String colName = HelperServices.dateFormate(date);
            String mealType = mealDetailsServices.getMealType(date, manager);
            int OnMealsOfADay = 2*totalOnOffMealCount(manager, colName, "on");
            
            totalOnMeal += OnMealsOfADay;
            
            int OffMealsOfADay = totalOnOffMealCount(manager, colName, "off");
            totalOffMeal += 2*OffMealsOfADay;
            if(mealType==null){
                continue;
            }else if (mealType.equals("Normal")) {

                totalNormalOffMeal += 2 * OffMealsOfADay;

            } else if (mealType.equals("Friday")) {

                totalNormalOffMeal += OffMealsOfADay;
                totalFridayOffMeal += OffMealsOfADay;

            } else if (mealType.equals("Feast")) {

                totalNormalOffMeal += 2 * OffMealsOfADay;
                totalFeastOffMeal += OffMealsOfADay;

            } else {
                totalNormalOffMeal += OffMealsOfADay;
                totalFridayOffMeal += OffMealsOfADay;
                totalFeastOffMeal += OffMealsOfADay;
            }
        }
        
  

    monthReport  = new MonthReport(totalActiveMember, totalOnMeal, totalOffMeal, totalNormalOffMeal, totalFridayOffMeal,
            totalFeastOffMeal,thisMonthTotalExpense, spentExpense, balance,
            managerList.get(0).getCardNo(), managerList.get(1).getCardNo());

    return monthReport ;
}

public int totalOnOffMealCount(Manager manager,String colName,String onOrOff) {
        int totalOnMeal = 0;
        String tblName = "meal_history_for_" + manager.getMonthName() + "_" + manager.getYear();
        String sql = "select count(*) from " + tblName + " where " + colName + "=?";
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, onOrOff);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                totalOnMeal += rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            



} catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class

.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return totalOnMeal;
    }

}
