package model.dao;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.conn.ConnectionForDB;

public class HelperServices {

    public static void main(String[] args) {
        createTable(DeptNmaesServices.tblCrtStmt);
        createTable(ManagerService.tblCrtStmt);
        createTable(MemberServices.tblCrtStmt);
        createTable(PersonalInfoServices.tblCrtStmt);
        createTable(RoleServices.tblCrtStmt);
        createTable(MonthDetailsServices.tblCrtStmt);
        createTable(SummaryService.createTblStmt);
        createTable(MealStopService.offCardTbl);
        createTable(MealManageService.crtCMSTbl);
        createTable(MealDayAndDateServices.createTableDayWithDate);
    }

    public static void createTable(String sql) {

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

    public static String getMonth(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }

    public static List<String> getDateList(java.util.Date startDate, java.util.Date endDate) {
        java.util.Date fromDate = startDate;
        java.util.Date toDate = endDate;
        List<String> dates = new ArrayList(25);
        Calendar cal = Calendar.getInstance();
        cal.setTime(fromDate);
        while (cal.getTime().before(toDate)) {
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH);
            String date_name = getMonth(month) + "_" + day;
            dates.add(date_name);
            cal.add(Calendar.DATE, 1);
        }

        return dates;
    }

    public static String dateFormate(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        String date_name = getMonth(month) + "_" + day;
        return date_name;
    }

}
