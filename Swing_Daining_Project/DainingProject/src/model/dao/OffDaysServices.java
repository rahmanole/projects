package model.dao;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import model.conn.ConnectionForDB;


public class OffDaysServices {
    private static final String TBL_NAME_PREFIX = "offDays_for_";
    
    public static void createOffDaysRecordTable(int cardNo){
        String tblName = TBL_NAME_PREFIX+cardNo;
        String sql = "create table IF NOT EXISTS "+tblName+"(id int(5) primary key auto_increment,off_date date)";
        try {
            Connection conn = ConnectionForDB.connect();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table created");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void dropOffDaysRecordTable(int cardNo){
        String tblName = TBL_NAME_PREFIX+cardNo;
        String sql = "drop table "+tblName;
        try {
            Connection conn = ConnectionForDB.connect();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table droped");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
//    public List<Date> getRecordsForAMonth(){
//      
//        
//    }
}
