/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conn;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ccsl-pc
 */
public class ConnectionForDB {
    public int i = 0;
    public static Connection conn = null;
    
    public static Connection connect(){
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dainingProject","root","1234");
        } catch (SQLException ex) {
            System.out.println("Not connected with DB");
            Logger.getLogger(ConnectionForDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    
    
}
