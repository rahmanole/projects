package model.dao;

import com.mysql.jdbc.Connection;
import controller.pojo.Member;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.conn.ConnectionForDB;


public class MemberServices {
    SummaryService lastMonthSummaryService = new SummaryService();
    
    public static String tblCrtStmt = "create table IF NOT EXISTS member_info(id int(5)primary key auto_increment,"
            + "name varchar(55),mobile varchar(55),email varchar(55),dept_name varchar(55),reg_no varchar(55),"
            + "session varchar(55),card_no int(5) unique,membership_type varchar(55),membership_status varchar(55),creation_date date)";
    

    
     
 
 
 
    public int saveInfo(Member member) {
        String insert = "insert into member_info(name,mobile,email,dept_name,reg_no,"
                + "session,card_no,membership_type,membership_status,creation_date) values(?,?,?,?,?,?,?,?,?,?)";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, member.getName());
            ps.setString(2, member.getMobile());
            ps.setString(3, member.getEmail());
            ps.setString(4, member.getDeptName());
            ps.setString(5, member.getRegNum());
            ps.setString(6, member.getSession());
            ps.setInt(7, member.getCardNo());
            ps.setString(8, member.getMembershipType());
            ps.setString(9, member.getMembershipStaus());
            ps.setDate(10, new Date(System.currentTimeMillis()));
            ps.executeUpdate();
            lastMonthSummaryService.save(member.getCardNo());
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
    
    
    public int update(Member member,int id){
        String stmt = "update member_info set name=?,mobile=?,email=?,dept_name=?,reg_no=?,"
                + "session=?,card_no=?,membership_type=? where id = ?";
        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setString(1, member.getName());
            ps.setString(2, member.getMobile());
            ps.setString(3, member.getEmail());
            ps.setString(4, member.getDeptName());
            ps.setString(5, member.getRegNum());
            ps.setString(6, member.getSession());
            ps.setInt(7, member.getCardNo());
            ps.setString(8, member.getMembershipType());
            ps.setInt(9, id);
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
    
    public boolean isEmailExists(String email){
        String sql = "select * from member_info where email = ?";
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return true;
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
        return false;
    }
    
    public Member getMemberByCardNo(int cardNo){
        String sql = "select * from member_info where card_no=?";
        Member member = null;
        Connection conn = null;
        
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cardNo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getString(6), 
                        rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getDate(11));
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
        return member;
    }
    
    public boolean isCardExists(int cardNo){
        String sql = "select * from member_info where card_no=?";
        Member member = null;
        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cardNo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return true;
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
        return false;
    }
    
    public boolean isCardAtive (int cardNo){
        boolean flag = false;
        String sql = "select membership_status from member_info where card_no=?";
        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cardNo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                flag = rs.getString(1).equalsIgnoreCase("active")?true:false;
                System.out.println(rs.getString(1));
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
        return flag;
    }
    
    public List<Integer> getAllActiveCards(){
        ArrayList<Integer> uncertainCars = new ArrayList<>();
        String sql = "select card_no from member_info";
        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                uncertainCars.add(rs.getInt(1));
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
        return uncertainCars;
    } 
}

