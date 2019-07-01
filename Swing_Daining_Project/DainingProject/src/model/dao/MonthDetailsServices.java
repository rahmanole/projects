/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.Connection;
import controller.pojo.Manager;
import controller.pojo.MonthDetails;
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
public class MonthDetailsServices {
    //MealHistoryServices mealHistoryServices = new MealHistoryServices();

    private static final String TBL_NAME_PREFIX = "meal_records_of_";

    public static String tblCrtStmt = "create table IF NOT EXISTS month_details(id int(5)primary key auto_increment,"
            + "month_name varchar(55),year varchar(5),employee_fees double,total_days int,"
            + "total_fridays int,friday_mealRate double,total_normalDaymeals double ,normal_mealRate double,"
            + "feast_mealRate double,total_cost double,feast_date date,start_date date,end_date date)";

    public int save(MonthDetails month) {
        String inserStmt = "insert into month_details(month_name,year,employee_fees,total_days,total_fridays,friday_mealRate,"
                + "total_normalDaymeals,normal_mealRate,feast_mealRate,total_cost,feast_date,start_date,end_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();

            PreparedStatement ps = conn.prepareStatement(inserStmt);
            ps.setString(1, month.getMonthName());
            ps.setString(2, month.getYear());
            ps.setDouble(3, month.getEmployee_fees());
            ps.setInt(4, month.getTotalDays());
            ps.setInt(5, month.getTotalFridays());
            ps.setDouble(6, month.getFriDayMealRate());
            ps.setInt(7, month.getNumberOfNormalDaymeals());
            ps.setDouble(8, month.getNormalMealRate());
            ps.setDouble(9, month.getFeastMealRate());
            ps.setDouble(10, month.getTotal_cost());
            ps.setDate(11, month.getFeastDate());
            ps.setDate(12, month.getStartDate());
            ps.setDate(13, month.getEndDate());
            ps.executeUpdate();

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return -1;
    }

    public double getThisMonthExpense(Manager manager) {
        String sql = "select total_cost from month_details where month_name=? and year=?";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, manager.getMonthName());
            ps.setString(2, manager.getYear());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
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

        return 0;
    }

    public List<String> getDateList(Manager manager) {
        String sql = "select * from month_details where month_name=? and year=?";
        List<String> getDateList = new ArrayList<>();

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, manager.getMonthName());
            ps.setString(2, manager.getYear());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                getDateList = HelperServices.getDateList(rs.getDate(13), rs.getDate(14));
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

        return getDateList;
    }

    public int updateMonth(MonthDetails monthDetails) {
        String updateStmt = "update month_details set employee_fees=?,total_days=?,total_fridays=?,friday_mealRate=?,"
                + "total_normalDaymeals=?,normal_mealRate=?,feast_mealRate=?,total_cost=?,feast_date=?,start_date=?,end_date=? where month_name=? and year=?";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();

            PreparedStatement ps = conn.prepareStatement(updateStmt);
            ps.setString(12, monthDetails.getMonthName());
            ps.setString(13, monthDetails.getYear());
            ps.setDouble(1, monthDetails.getEmployee_fees());
            ps.setInt(2, monthDetails.getTotalDays());
            ps.setInt(3, monthDetails.getTotalFridays());
            ps.setDouble(4, monthDetails.getFriDayMealRate());
            ps.setInt(5, monthDetails.getNumberOfNormalDaymeals());
            ps.setDouble(6, monthDetails.getNormalMealRate());
            ps.setDouble(7, monthDetails.getFeastMealRate());
            ps.setDouble(8, monthDetails.getTotal_cost());
            ps.setDate(9, monthDetails.getFeastDate());
            ps.setDate(10, monthDetails.getStartDate());
            ps.setDate(11, monthDetails.getEndDate());
            ps.executeUpdate();

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return -1;
    }

    public static List<Date> getActualDateListOfMonth(Manager manager) {
        String sql = "select * from month_details where month_name=? and year=?";
        List<Date> getDateList = new ArrayList<>();

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, manager.getMonthName());
            ps.setString(2, manager.getYear());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                getDateList = MealDayAndDateServices.getActualDateList(rs.getDate(13), rs.getDate(14));
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

        return getDateList;
    }

    public double getNormalMealRate(Manager manager) {
        double normalMealRate = 0;
        String sql = "select normal_mealRate from month_details where month_name=? and year=?";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, manager.getMonthName());
            ps.setString(2, manager.getYear());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                normalMealRate = rs.getDouble(1);
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
        return normalMealRate;
    }

    public double getFridayMealRate(Manager manager) {
        double fridayMealRate = 0;
        String sql = "select friday_mealRate from month_details where month_name=? and year=?";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, manager.getMonthName());
            ps.setString(2, manager.getYear());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fridayMealRate = rs.getDouble(1);
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
        return fridayMealRate;
    }

    public double getFeastMealRate(Manager manager) {
        double feastMealRate = 0;
        String sql = "select feast_mealRate from month_details where month_name=? and year=?";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, manager.getMonthName());
            ps.setString(2, manager.getYear());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                feastMealRate = rs.getDouble(1);
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
        return feastMealRate;
    }

    public double getTotalExpense(Manager manager) {
        String tblName = "meal_details_for_" + manager.getMonthName() + "_" + manager.getYear();
        String sql = "select total_cost from month_details";

        double total_cost = 0;

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                total_cost = rs.getDouble(1);
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
        return total_cost;
    }

    public MonthDetails getMonthDetails(Manager manager) {
        MonthDetails monthDetails = null;
        String sql = "select * from month_details where month_name=? and year=?";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, manager.getMonthName());
            ps.setString(2, manager.getYear());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                monthDetails = new MonthDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getDate(11), rs.getDate(12), rs.getDate(13));                
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

        return monthDetails;
    }
    
    
    public boolean isMonthExists(Manager manager){
        String sql = "select * from month_details where month_name=? and year=?";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, manager.getMonthName());
            ps.setString(2, manager.getYear());
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
}
