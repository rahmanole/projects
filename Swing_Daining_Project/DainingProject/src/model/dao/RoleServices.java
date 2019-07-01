/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.Connection;
import controller.pojo.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import model.conn.ConnectionForDB;

/**
 *
 * @author Student J2ee-37
 */
public class RoleServices {

    MemberServices memberServices = new MemberServices();
    public static String tblCrtStmt = "create table IF NOT EXISTS role(id int(5)primary key auto_increment,"
            + "email varchar(55),role_name varchar(55),pin varchar(10))";



    public int save(Role role, JLabel lbl) {
        String insert = "insert into role(email,role_name,pin) values(?,?,?)";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, role.getEmail());
            ps.setString(2, role.getRoleNmae());
            ps.setString(3, role.getPin());
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
        String sql = "select * from role where email = ?";
        
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
    
    public List<String> getPinList(){
        List<String> pinList = new ArrayList<>();
        String sql = "select pin from role";
        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pinList.add(rs.getString(1));
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
        return pinList;
    }
    
    public String getRoleNameByPin(String pin){
        String roleName = "admin";
        String sql = "select role_name from role where pin = ?";
        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pin);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                roleName = rs.getString(1);
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
        return roleName;
    }
}
