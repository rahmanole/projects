/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.Connection;
import controller.pojo.Manager;
import controller.pojo.Meal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.conn.ConnectionForDB;

/**
 *
 * @author OLEE
 */
public class MealDetailsServices {

    MealManageService mealManageService = new MealManageService();
    MealDayAndDateServices mealDayAndDateServices = new MealDayAndDateServices();
    MonthDetailsServices monthDetailsServices = new MonthDetailsServices();

    public static void createMealDetailsTable(String month, String year, Manager manager) {
        String tblName = "meal_details_for_" + month + "_" + year;
        String tblCrtStmt = "create table IF NOT EXISTS " + tblName + "(id int(5)primary key auto_increment,"
                + "meal_date date,total_meals int,on_meal int,off_meal int,meal_type varchar(20),"
                + "actual_expensess double,spent_expenss double,"
                + "balance double,item_details varchar(1000))";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(tblCrtStmt);
            ps.execute();
            for (Date date : MonthDetailsServices.getActualDateListOfMonth(manager)) {
                insertDate(date, manager);
            }
            System.out.println("Table created");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Date will be inserted in this table from prepare month view by this method
    public static void insertDate(Date date, Manager manager) {
        String tblName = "meal_details_for_" + manager.getMonthName() + "_" + manager.getYear();
        String stmt = "insert into " + tblName + "(meal_date) values(?)";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setDate(1, date);
            ps.execute();
            System.out.println(date.toString() + " inserted in meal details");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int updateMealDetails(Meal meal, Manager manager) {
        String tblName = "meal_details_for_" + manager.getMonthName() + "_" + manager.getYear();
        String updateMeal = "update " + tblName + " set total_meals=?,on_meal=?,"
                + "off_meal=?,meal_type=?,actual_expensess=?,spent_expenss=?,balance=?,item_details=? where meal_date=?";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(updateMeal);
            ps.setInt(1, meal.getTotalActiveMember());
            ps.setInt(2, meal.getTotalOnMeals());
            ps.setInt(3, meal.getTotalOffMeal());
            ps.setString(4, meal.getMealType());
            ps.setDouble(5, meal.getActual_expensess());
            ps.setDouble(6, meal.getSpent_expenss());
            ps.setDouble(7, meal.getBalance());
            ps.setString(8, meal.getItemDetails());
            ps.setDate(9, meal.getDate());
            ps.execute();
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return -1;

    }

    public int getActiveCards() {
        return mealManageService.totalCards();
    }

    public int getOffMeals() {
        return mealManageService.totaloffMeals();
    }

    public String getMealType(Date date, Manager manager) {

        String status = "";
        String tblName = "meal_details_for_" + manager.getMonthName() + "_" + manager.getYear();
        String stmt = "select meal_type from " + tblName + " where meal_date = ?";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                status = rs.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return status;
    }

    public double getSpentExpense(Manager manager) {
        String tblName = "meal_details_for_" + manager.getMonthName() + "_" + manager.getYear();
        String sql = "select sum(spent_expenss) from " + tblName;
        
        double spentExpense = 0;

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
             spentExpense = rs.getDouble(1);
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
        return spentExpense;
    }
    
     public double getBalance(Manager manager) {
        String tblName = "meal_details_for_" + manager.getMonthName() + "_" + manager.getYear();
        String sql = "select sum(balance) from " + tblName;
        
        double balance = 0;

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
             balance = rs.getDouble(1);
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
        return balance;
    }
    
     
     public List<Date> getDateList(Manager manager) {
        String tblName = "meal_details_for_" + manager.getMonthName() + "_" + manager.getYear();
        String sql = "select * from " + tblName;
        
        List<Date> dateList = new ArrayList<>();

        Connection conn = null;
        
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dateList.add(rs.getDate(2));
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

        return dateList;
    }
    
    public Meal getMealByDate(Date date,Manager manager){
        Meal meal = null;
        
        String tblName = "meal_details_for_" + manager.getMonthName() + "_" + manager.getYear();
        String sql = "select * from " + tblName+" where meal_date=?";
        
        double spentExpense = 0;

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1,date);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
             meal = new Meal(date, rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getString(10));
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
        
        return meal;
    } 
    
    public double getMealRateByDate(Date date,Manager manager){
        double mealRate = 0;
        
        getMealType(date, manager);
        if(getMealType(date, manager).equals("Normal")){
            mealRate = 2*monthDetailsServices.getNormalMealRate(manager);
        }else if(getMealType(date, manager).equals("Friday")){
            mealRate = monthDetailsServices.getNormalMealRate(manager)+monthDetailsServices.getFridayMealRate(manager);
        }else if(getMealType(date, manager).equals("Feast")){
            mealRate = monthDetailsServices.getFeastMealRate(manager)+2*monthDetailsServices.getNormalMealRate(manager);
        }else{
            mealRate = monthDetailsServices.getFeastMealRate(manager)+monthDetailsServices.getNormalMealRate(manager)+monthDetailsServices.getFridayMealRate(manager);
        }
        
        return mealRate;
    }
}
