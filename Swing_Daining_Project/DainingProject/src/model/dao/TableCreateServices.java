package model.dao;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.conn.ConnectionForDB;

public class TableCreateServices {

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

        try {
            Connection conn = ConnectionForDB.connect();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table created");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    

}
