/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.Connection;
import controller.pojo.Manager;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.conn.ConnectionForDB;

/**
 *
 * @author OLEE
 */
public class MealManageService {
    static SummaryService summaryService = new SummaryService();

    public static String crtCMSTbl = "create table IF NOT EXISTS current_meal_status(id int(5) primary key auto_increment,"
            + "card_no int(5) unique,on_or_off varchar(5) default 'on')";
    


    public int stopMeal(int cardNo) {        
        String stmt = "update current_meal_status where card_no=?";       
        
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
    
    public int startMeal(int cardNo) {
        String stmt = "update current_meal_status set on_or_off=? where card_no=?";
        
        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setString(1, "on");
             ps.setInt(2, cardNo);
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
//This method is used in add summary view.while adding summary the card will be added to current meal status table simultaneously
    public  int save(int cardNo) {
        String stmt = "insert into current_meal_status(card_no,on_or_off) values(?,?)";

        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, cardNo);
            ps.setString(2, "on");
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

    public int updateStartStopMeal(int cardNo, String flag) {
        String stmt = "update last_day_meal_history set on_or_off=? where card_no=?";

       
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setString(1, flag);
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
    
    public String getStatus(int cardNo) {
        String offOrOn = "";
        String stmt = "select on_or_off from current_meal_status where card_no=?";

        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, cardNo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                offOrOn = rs.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return offOrOn;
    }

    public List<Integer> cardList() {
        ArrayList<Integer> cardList = new ArrayList<>();
        String stmt = "select card_no from current_meal_status";

        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cardList.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Collections.sort(cardList);
        return cardList;
    }
    
    public int prepareCMSTable() {
        String stmt = "update current_meal_status set on_or_off=?";

        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setString(1, "on");
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
    
    public int totalCards(){
        int totalCard = 0;
        String stmt = "select count(card_no) from current_meal_status";
        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
            totalCard = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return totalCard;
    }
    
    public int totaloffMeals(){
        int totalOffMeals = 0;
        String stmt = "select count(card_no) from current_meal_status where on_or_off=?";
        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setString(1,"off");
            ResultSet rs  = ps.executeQuery();
            
            while(rs.next()){
            totalOffMeals = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return totalOffMeals;
    }
    
    public String getMealStatus(int cardNo) {

        String status = "";
        String stmt = "select on_or_off from  current_meal_status where cardNo = ?";

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
    
}
