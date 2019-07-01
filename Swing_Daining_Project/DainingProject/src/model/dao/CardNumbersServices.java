/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.Connection;
import controller.pojo.CardNumbers;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.conn.ConnectionForDB;

/**
 *
 * @author OLEE
 */
public class CardNumbersServices {
    public static String sql = "create table card_numbers(id int(5) primary key auto_increment,card_no int(5),status varchar(10))";
    
    public static void main(String[] args) {
        HelperServices.createTable(sql);
    }
    
    public void save(CardNumbers cardNumbers){
        String stmt = "insert into card_numbers(card_no,status) values(?,?)";
        
        try {
            Connection conn = ConnectionForDB.connect();
            
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, cardNumbers.getCardNo());
            ps.setString(2, cardNumbers.getStatus());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
