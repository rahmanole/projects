/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.Connection;
import controller.pojo.Summary;
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
public class SummaryService {
    
    MealDayAndDateServices mealDayAndDateServices = new MealDayAndDateServices();
    MealHistoryServices mealHistoryServices = new MealHistoryServices();
    MonthDetailsServices monthDetailsServices = new MonthDetailsServices();
    MealDetailsServices mealDetailsServices = new MealDetailsServices();

    public static String createTblStmt = "create table IF NOT EXISTS summary(id int(5)primary key auto_increment,"
            + "card_no int(5) unique,onDys int(2),normal_offMeal int(2),"
            + "friday_offMeal int(1),was_feast_on varchar(5),total_off_meal int(2), bumping double)";
    


    public int save(Summary summary) {
        String insertStmt = "update summary set  onDys=?,normal_offMeal=?,friday_offMeal=?,"
                + "was_feast_on=?,total_off_meal=?,bumping=? where card_no = ?";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(insertStmt);

            ps.setInt(1, summary.getOnDays());
            ps.setInt(2, summary.getNormalOffDays());
            ps.setInt(3, summary.getFridayOffMeal());
            ps.setString(4, summary.getWasFeastOn()?"yes":"no");
            ps.setDouble(5, summary.getTotalOffMeal());
            ps.setDouble(6,summary.getBumping());
            ps.setInt(7,summary.getCardNo());
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

    public int save(int cardNo) {
        String insertStmt = "insert into summary(card_no) values(?)";

       
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(insertStmt);
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

    public Summary getLastMonthSummaryByCardNo(int cardNo) {
        Summary lastMonthSummary = null;
        String sql = "select * from summary where card_no=?";
        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cardNo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                lastMonthSummary = new Summary(rs.getInt(1), rs.getInt(3),rs.getInt(4), rs.getDouble(5));
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
        
        return lastMonthSummary;
    }
    
    public List<Integer> getCardList(){
        ArrayList<Integer> cardList = new ArrayList<>();
        String sql = "select card_no from summary";
        
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
    
  
}
