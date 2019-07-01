/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.Connection;
import controller.pojo.Manager;
import controller.pojo.Member;
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
 * @author Student J2ee-37
 */
public class MealStopService {

    HelperServices helperServices = new HelperServices();

    public static String offCardTbl = "create table IF NOT EXISTS off_cards(id int(5) primary key auto_increment,"
            + "card_no int(5) unique,start_daet date,end_date date)";
//   
//    public static List<Integer> getUncertainCardList() {
//        ArrayList<Integer> uncertainCards = new ArrayList<>();
//        String sql = "select card_no from uncertain_cards";
//        Member member = null;
//        try {
//            Connection conn = ConnectionForDB.connect();
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                uncertainCards.add(rs.getInt(1));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return uncertainCards;
//    }

    public int svae(int cardNo, Date startDate, Date endDate) {
        String insert = "insert into off_cards(card_no,start_daet,end_date) values(?,?,?)";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setInt(1, cardNo);
            ps.setDate(2, startDate);
            ps.setDate(3, endDate);
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return -1;

    }

    public int svae(int cardNo, Date startDate) {
        String insert = "insert into off_cards(card_no,start_daet) values(?,?)";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setInt(1, cardNo);
            ps.setDate(2, startDate);
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return -1;

    }

    public int stopMeal(int cardNo) {
        String stmt = "update current_meal_status set on_or_off=? where card_no=?";
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();

            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setString(1, "off");
            ps.setInt(2, cardNo);
            ps.execute();

            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return -1;
    }
    
    public List<Integer> getCardList(){
        ArrayList<Integer> cardList = new ArrayList<>();
        String sql = "select card_no from off_cards";
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cardList.add(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return cardList;
    }

    public List<String> getLastDateList() {
        String sql = "select end_date from off_cards";
        List<String> lastDateList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getDate(1) != null) {
                    lastDateList.add(helperServices.dateFormate(rs.getDate(1)));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lastDateList;
    }
    
    public void removeAccordingToLastDate(Date toDayMealDate){
        
        String sql = "delete from off_cards where end_date=?";
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, toDayMealDate);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int removeFromOffCardList(int cardNo) {
        String sql = "delete from off_cards where card_no=?";
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cardNo);
            ps.execute();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return -1;
    }

    public int insertIntoUncertain(int cardNo) {
        String insert = "insert into uncertain_cards(card_no) values(?)";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setInt(1, cardNo);
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return -1;
    }

    public List<String> getDateListToStopMeal(int cardNo) {
        String sql = "select * from stop_meal_in_range where card_no=?";
        List<String> dateListToStopMeal = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cardNo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dateListToStopMeal = HelperServices.getDateList(rs.getDate(13), rs.getDate(14));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return dateListToStopMeal;
    }

}
