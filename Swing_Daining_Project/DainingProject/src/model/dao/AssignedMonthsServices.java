package model.dao;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.conn.ConnectionForDB;

public class AssignedMonthsServices {
    private static final String TBL_NAME_PREFIX = "months_assigned_for_";
    
    public static void createAssignedMonthsRecordTable(int cardNo){
        String tblName = TBL_NAME_PREFIX+cardNo;
        String sql = "create table IF NOT EXISTS "+tblName+"(id int(5) primary key auto_increment,"
                + "month_name varchar(20),year varchar(4),expensess double,paymentDate date)";
        
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table created");
            
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void dropOffDaysRecordTable(int cardNo){
        String tblName = TBL_NAME_PREFIX+cardNo;
        String sql = "drop table "+tblName;
        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table droped");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
