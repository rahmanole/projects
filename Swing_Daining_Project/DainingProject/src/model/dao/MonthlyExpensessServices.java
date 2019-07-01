package model.dao;

import com.mysql.jdbc.Connection;
import controller.pojo.Manager;
import controller.pojo.MonthlyExpense;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.conn.ConnectionForDB;

public class MonthlyExpensessServices {

    SummaryService summaryService = new SummaryService();
    MealHistoryServices mealHistoryServices = new MealHistoryServices();
    MealManageService mealManageService = new MealManageService();
    MonthDetailsServices monthDetailsServices = new MonthDetailsServices();
    List<Integer> cardListInHistoyAndSummaryTbl = summaryService.getCardList();

    public void createMontlyExpenseTable(Manager manager) {

        String tblName = "monthly_expense_" + manager.getMonthName() + "_" + manager.getYear();

        String creatTblStmt = "create table IF NOT EXISTS " + tblName + "(id int(5)primary key auto_increment,"
                + "card_no int,previsous_month_bumping double,needtopay double,payment_date date)";

        HelperServices.createTable(creatTblStmt);
    }

    public void saveMonthlyExpense(MonthlyExpense monthlyExpense, Manager manager) {
        String tblName = "monthly_expense_" + manager.getMonthName() + "_" + manager.getYear();
        String stmt = "insert into " + tblName + "(card_no,previsous_month_bumping,needtopay,payment_date) values(?,?,?,?)";

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, monthlyExpense.getCardNo());
            ps.setDouble(2, monthlyExpense.getPrevious_month_bumpingMoney());
            ps.setDouble(3, monthlyExpense.getNeedToPay());
            ps.setDate(4, monthlyExpense.getPaymentDate());

            ps.executeUpdate();
            int cardNo = monthlyExpense.getCardNo();
            if (!cardListInHistoyAndSummaryTbl.contains(cardNo)) {
                summaryService.save(cardNo);
                mealHistoryServices.save(cardNo, manager);
                mealManageService.save(cardNo);
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

    }

    public List<Integer> getCardList(Manager manager) {
        String tblName = "monthly_expense_" + manager.getMonthName() + "_" + manager.getYear();
        String sql = "select card_no from " + tblName;

        List<Integer> cardList = new ArrayList<>();

       

        Connection conn = null;
        try {
            conn = ConnectionForDB.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cardList.add(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignedMonthsServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cardList;
    }
    
    public double getTotalCollectedExpense(Manager manager){
        return getCardList(manager).size()*monthDetailsServices.getTotalExpense(manager);
    }
    
    public String isPayemntPaid(int cardNo,Manager manager){
        return getCardList(manager).contains(cardNo)?"Paid":"Not paid";
    }
}
