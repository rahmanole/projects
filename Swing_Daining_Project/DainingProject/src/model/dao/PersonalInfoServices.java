/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.Connection;
import controller.pojo.PersonalInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.conn.ConnectionForDB;

/**
 *
 * @author ccsl-pc
 */
public class PersonalInfoServices {

    

    private int id;
    private String name;
    private String contNum;
    private String email;
    private int dept_id;
    private String regNum;
    private String session;

    static String tblCrtStmt  = "create table IF NOT EXISTS personal_info(id int(6)primary key auto_increment,"
            + "name varchar(55),cnt_num varchar(20),email varchar(55),dept_name varchar(55),"
            + "reg_num varchar(20),session varchar(20))";
    
//    public static void main(String[] args) {
//        ConnectionForDB.createTable(sql);
//    }

    public int saveInfo(PersonalInfo personalInfo) {
        String insert = "insert into personal_info(name,cnt_num,email,dept_name,reg_num,session) values(?,?,?,?,?,?)";

        try {
            Connection conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, personalInfo.getName());
            ps.setString(2, personalInfo.getContNum());
            ps.setString(3, personalInfo.getEmail());
            ps.setString(4, personalInfo.getDeptName());
            ps.setString(5, personalInfo.getRegNum());
            ps.setString(6, personalInfo.getSession());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public boolean isEmailExists(String email){
        String sql = "select * from member_info where email = ?";
        try {
            Connection conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public PersonalInfo getPersonalInfo(){
        PersonalInfo personalInfo = null;
        String sql = "select * from personal_info where id = ?";
        DeptNmaesServices deptNmaesServices = new DeptNmaesServices();
        try {
            Connection conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, personalInfo.getName());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                personalInfo = new PersonalInfo(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), 
                        rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personalInfo;
    }

    public int updateInfo(PersonalInfo personalInfo) {
        String update = "update personal_info set name=?,cnt_num=?,email=?,dept_name=?,reg_num=?,session=? where id=?";

        try {
            Connection conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(update);
            ps.setString(1, personalInfo.getName());
            ps.setString(2, personalInfo.getContNum());
            ps.setString(3, personalInfo.getEmail());
            ps.setString(4, personalInfo.getDeptName());
            ps.setString(5, personalInfo.getRegNum());
            ps.setString(6, personalInfo.getSession());

            ps.setInt(7, personalInfo.getId());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
    
    public int deleteInfo(PersonalInfo personalInfo) {
        String delete = "delete from personal_info where id=?";

        try {
            Connection conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(delete);
            ps.setInt(1, personalInfo.getId());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}
