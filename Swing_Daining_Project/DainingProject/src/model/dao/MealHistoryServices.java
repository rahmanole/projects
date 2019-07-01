/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.Connection;
import controller.pojo.Manager;
import controller.pojo.Summary;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.conn.ConnectionForDB;

/**
 *
 * @author OLEE
 */
public class MealHistoryServices {

    static SummaryService summaryService = new SummaryService();
    MealManageService mealManageService = new MealManageService();
    MealDetailsServices mealDetailsServices = new MealDetailsServices();
    MonthDetailsServices monthDetailsServices = new MonthDetailsServices();

    public void createMealHistoryTable(String month, String year, Date startDate, Date endDate) {
        String tblName = "meal_history_for_" + month + "_" + year;
        String tblCrtStmt = "create table IF NOT EXISTS " + tblName + "(id int(5)primary key auto_increment,"
                + "card_no int)";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();

            PreparedStatement ps = conn.prepareStatement(tblCrtStmt);
            ps.execute();
            HelperServices.getDateList(startDate, endDate).forEach((date) -> {
                addCol(date, tblName);
            });
            List<Integer> cardListInSummaryTable = summaryService.getCardList();

            for (int cardNo : cardListInSummaryTable) {
                save(cardNo, tblName);
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

    //check if any card exists in meal hostory table
    public boolean isCardExists(int cardNo, Manager manager) {
        String tblName = "meal_history_for_" + manager.getMonthName() + "_" + manager.getYear();
        String sql = "select * from " + tblName + " where card_no=?";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cardNo);
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

    public static List<Integer> getCardList(Manager manager) {
        List<Integer> cardList = new ArrayList<>();
        String tblName = "meal_history_for_" + manager.getMonthName() + "_" + manager.getYear();
        String sql = "select card_no from " + tblName;

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cardList.add(rs.getInt(1));
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

        return cardList;
    }

    public static void main(String[] args) {
    }

    public static void save(int cardNo, String tblName) {
        String stmt = "insert into " + tblName + "(card_no) values(?)";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, cardNo);
            ps.execute();
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

    //This method is called from monthlt Exepnse collect table 
    //if the card does not exists in meal history or summary table then the card will be add to this table
    public static void save(int cardNo, Manager manager) {
        String tblName = "meal_history_for_" + manager.getMonthName() + "_" + manager.getYear();
        String stmt = "insert into " + tblName + "(card_no) values(?)";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, cardNo);
            ps.execute();
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

    private static void addCol(String date, String tblName) {
        String stmt = "alter table " + tblName + " add " + date + " varchar(10)";
        Connection conn = null;

        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.executeUpdate();
            System.out.println(date);
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

    private static void updateMealDate(Date date, String tblName) {
        String stmt = "update " + tblName + "set meal_date=?";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setDate(1, date);
            ps.executeUpdate();
            System.out.println(date);
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

    public static List<java.sql.Date> updateAlMealDates(java.util.Date startDate, java.util.Date endDate, String tblName) {
        java.util.Date fromDate = startDate;
        java.util.Date toDate = endDate;
        List<java.sql.Date> dates = new ArrayList<java.sql.Date>(25);
        Calendar cal = Calendar.getInstance();
        cal.setTime(fromDate);
        while (cal.getTime().before(toDate)) {
            cal.add(Calendar.DATE, 1);
            updateMealDate(new java.sql.Date(cal.getTime().getTime() - 86400000), tblName);
            dates.add(new java.sql.Date(cal.getTime().getTime() - 86400000));
            System.out.println(new java.sql.Date(cal.getTime().getTime() - 86400000));
        }

        return dates;
    }

    public void updateStatusForNextMeal(int cardNo, Date date, Manager manager) {
        String colName = HelperServices.dateFormate(date);
        String tblName = "meal_history_for_" + manager.getMonthName() + "_" + manager.getYear();
        String sqlStmt = "update " + tblName + " set " + colName + "=? where card_no = ?";

        String status = mealManageService.getStatus(cardNo);

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();

            PreparedStatement ps = conn.prepareStatement(sqlStmt);
            ps.setString(1, status);
            ps.setInt(2, cardNo);
            ps.executeUpdate();
            System.out.println(date);
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

    public String getMealStatus(int cardNo, Date date, Manager manager) {

        String status = "";
        String colName = HelperServices.dateFormate(date);
        String tblName = "meal_history_for_" + manager.getMonthName() + "_" + manager.getYear();
        String stmt = "select " + colName + " from " + tblName + " where card_no = ?";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, cardNo);
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

    //Analyze meal history
    public Summary getSummary(int cardNo, Manager manager) {
        Summary summary = null;
        int totalMeals = 0;
        int totalOnMeal = 0;
        int normalOff = 0;
        int fridayOff = 0;
        boolean wasFestOn = false;
        double bumping = 0;
        List<Date> offDates = new ArrayList();

        double normalMealRate = monthDetailsServices.getNormalMealRate(manager);
        double fridayMealRate = monthDetailsServices.getFridayMealRate(manager);
        double feastMealRate = monthDetailsServices.getFeastMealRate(manager);

        List<Date> allDateOfThisMonth = MonthDetailsServices.getActualDateListOfMonth(manager);
        System.out.println(allDateOfThisMonth);

        for (Date date : allDateOfThisMonth) {
            
            String status = getMealStatus(cardNo, date, manager);
            if(status == null){
                continue;
            }else if (status.equals("on")) {
                totalMeals++;
                totalOnMeal++;
            } else if (status.equals("off")) {
                totalMeals++;
                String type = mealDetailsServices.getMealType(date, manager);
                if (type.equals("Normal")) {
                    normalOff += 2;
                    bumping += 2 * normalMealRate;
                } else if (type.equals("Friday")) {
                    fridayOff++;
                    normalOff++;

                    bumping += (normalMealRate + fridayMealRate);

                } else if (type.equals("Friday & Feast")) {
                    fridayOff++;
                    normalOff++;
                    wasFestOn = true;
                    bumping += (normalMealRate + fridayMealRate + feastMealRate);
                } else {
                    wasFestOn = true;
                    normalOff += 2;
                    bumping += (2 * normalMealRate + feastMealRate);
                }
                offDates.add(date);
            } else {

            }

        }
        
        summary = new Summary(cardNo,totalMeals*2, fridayOff, normalOff, fridayOff, wasFestOn, offDates.size()*2, bumping, offDates);
       
        return summary;
    }
    
    

}
