/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.pojo.Manager;
import controller.pojo.MonthDetails;
import java.awt.Color;
import java.time.Month;
import java.time.YearMonth;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.dao.DeptNmaesServices;
import model.dao.MealDayAndDateServices;
import model.dao.MealHistoryServices;
import model.dao.MealDetailsServices;
import model.dao.MealManageService;
import model.dao.MemberServices;
import model.dao.MonthDetailsServices;
import model.dao.MonthlyExpensessServices;

/**
 *
 * @author OLEE
 */
public class UpdateMonthView extends javax.swing.JFrame {

    /**
     * Creates new form PersonalInfo
     */
    MemberServices memberServices = new MemberServices();
    DeptNmaesServices deptNmaesServices = new DeptNmaesServices();
    MonthDetailsServices monthDetailsServices = new MonthDetailsServices();
    MealManageService mealManageService = new MealManageService();
    MealHistoryServices mealHistoryServices = new MealHistoryServices();
    MonthlyExpensessServices monthlyExpensessServices = new MonthlyExpensessServices();
    MealDayAndDateServices mealDayAndDateServices = new MealDayAndDateServices();
    MealDetailsServices mealDetailsServices = new MealDetailsServices();

    Manager manager = null;
    String monthName = "";
    String year = "";

    public UpdateMonthView(Manager manager) {

        initComponents();
        this.setLocationRelativeTo(null);
        this.manager = manager;
        monthName = manager.getMonthName();
        year = manager.getYear();
        lbl_monthName.setText(monthName);
        lbl_year.setText(year);
        YearMonth yearMonthObject = YearMonth.of(Integer.parseInt(year), Month.valueOf(monthName.toUpperCase()).getValue());
        int daysInMonth = yearMonthObject.lengthOfMonth();
        t_totalDays.setText(daysInMonth + "");
        //t_friDays.setText(totalFridays()+"");
        lbl_title.setText("Month Name:" + manager.getMonthName() + " " + manager.getYear());

        this.setTitle("Prepare Month");
        lbl_bg.setBackground(new Color(0, 0, 0, 0));
        t_feastMealRate.setBackground(new Color(0, 0, 0, 0));
        t_totalDays.setBackground(new Color(0, 0, 0, 0));
        t_toalFridays.setBackground(new Color(0, 0, 0, 0));
        t_fridayMealRate.setBackground(new Color(0, 0, 0, 0));
        t_totalNoramlDays.setBackground(new Color(0, 0, 0, 0));
        t_normalMealRate.setBackground(new Color(0, 0, 0, 0));
        t_empFees.setBackground(new Color(0, 0, 0, 0));
        //jDateChooser1.setBackground(new Color(0, 0, 0, 0));

        pnl_sideBar.setBackground(new Color(0, 0, 0, 100));

        MonthDetails monthDetails = monthDetailsServices.getMonthDetails(manager);

        t_empFees.setText(monthDetails.getEmployee_fees()+"");
        t_totalDays.setText(monthDetails.getTotalDays()+"");
        t_totalDays.setText(monthDetails.getTotalDays()+"");
        t_fridayMealRate.setText(monthDetails.getFriDayMealRate()+"");
        t_totalNoramlDays.setText(monthDetails.getNumberOfNormalDaymeals()+"");
        t_normalMealRate.setText(monthDetails.getNormalMealRate()+"");
        t_feastMealRate.setText(monthDetails.getFeastMealRate()+"");
        lbl_totalMonthlyCost.setText(monthDetails.getTotal_cost()+"");
        date_feastDate.setDate(monthDetails.getFeastDate());
        date_startDate.setDate(monthDetails.getStartDate());
        date_endDate.setDate(monthDetails.getEndDate());

    }

    private UpdateMonthView() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    private int totalFridays(){
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.MONTH, Month.valueOf(monthName.toUpperCase()).getValue()); // may is just an example
//        c.set(Calendar.YEAR, Integer.parseInt(year));
//        
//        return Calendar.FRIDAY;
//    }
    private void designTable(JTable tableName) {
        tableName.getTableHeader().setForeground(new Color(255, 255, 255));
        tableName.getTableHeader().setBackground(Color.BLACK);
        tableName.getTableHeader().setForeground(Color.black);

        ((DefaultTableCellRenderer) tableName.getDefaultRenderer(Object.class)).setOpaque(false);

        tableName.setBackground(new Color(0, 0, 0));
        //jScrollPane1.setBackground(new Color(0, 0, 0));
        //jScrollPane1.getViewport().setOpaque(false);
        tableName.setShowGrid(true);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableName.setDefaultRenderer(String.class, centerRenderer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_title = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_monthName = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_year = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        t_feastMealRate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        t_totalDays = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        t_toalFridays = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        lbl_msgs = new javax.swing.JLabel();
        btn_updateMonth = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        t_totalNoramlDays = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        lbl_title1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        t_fridayMealRate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        t_empFees = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        t_normalMealRate = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        date_feastDate = new com.toedter.calendar.JDateChooser();
        date_startDate = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        date_endDate = new com.toedter.calendar.JDateChooser();
        lbl_totalMonthlyCost = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        pnl_sideBar = new javax.swing.JPanel();
        sideBtn_addmmeber = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sideBtn_addMontlyExpensess = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        sideBtn_addMealDetails = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        sideBtn_collectExpense = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        sideBtn_manageMeals = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        sideBtn_updateMonth = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_title.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("Personal Information");
        getContentPane().add(lbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 170, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 1020, 20));

        lbl_monthName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_monthName.setForeground(new java.awt.Color(255, 255, 255));
        lbl_monthName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbl_monthName, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 250, 30));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 250, 10));

        lbl_year.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_year.setForeground(new java.awt.Color(255, 255, 255));
        lbl_year.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbl_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 250, 30));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 250, 10));

        t_feastMealRate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_feastMealRate.setForeground(new java.awt.Color(255, 255, 255));
        t_feastMealRate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_feastMealRate.setBorder(null);
        t_feastMealRate.setOpaque(false);
        t_feastMealRate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_feastMealRateKeyReleased(evt);
            }
        });
        getContentPane().add(t_feastMealRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 180, 250, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Employee Fees");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 100, 30));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 250, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Feast Meal Rate");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 100, 30));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 210, 250, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Days");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 100, 30));

        t_totalDays.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_totalDays.setForeground(new java.awt.Color(255, 255, 255));
        t_totalDays.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_totalDays.setBorder(null);
        t_totalDays.setOpaque(false);
        getContentPane().add(t_totalDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 250, 30));

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 250, 10));

        t_toalFridays.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_toalFridays.setForeground(new java.awt.Color(255, 255, 255));
        t_toalFridays.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_toalFridays.setBorder(null);
        t_toalFridays.setOpaque(false);
        getContentPane().add(t_toalFridays, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 250, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total Fridays");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 80, 30));

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 250, 10));
        getContentPane().add(lbl_msgs, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 480, 250, 30));

        btn_updateMonth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_updateMonth.setForeground(new java.awt.Color(255, 255, 255));
        btn_updateMonth.setText("Save");
        btn_updateMonth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_updateMonth.setContentAreaFilled(false);
        btn_updateMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_updateMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateMonthActionPerformed(evt);
            }
        });
        getContentPane().add(btn_updateMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 530, 100, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Feast Date");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 320, 80, 30));

        t_totalNoramlDays.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_totalNoramlDays.setForeground(new java.awt.Color(255, 255, 255));
        t_totalNoramlDays.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_totalNoramlDays.setBorder(null);
        t_totalNoramlDays.setOpaque(false);
        getContentPane().add(t_totalNoramlDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, 250, 30));

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, 250, 10));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 10, 440));

        lbl_title1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_title1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title1.setText("Monthly Expenses ");
        getContentPane().add(lbl_title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 280, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Month Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Year");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 70, 30));

        t_fridayMealRate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_fridayMealRate.setForeground(new java.awt.Color(255, 255, 255));
        t_fridayMealRate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_fridayMealRate.setBorder(null);
        t_fridayMealRate.setOpaque(false);
        getContentPane().add(t_fridayMealRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 250, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Normal Days");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 80, 30));

        t_empFees.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_empFees.setForeground(new java.awt.Color(255, 255, 255));
        t_empFees.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_empFees.setBorder(null);
        t_empFees.setOpaque(false);
        getContentPane().add(t_empFees, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 250, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Friday Meal Rate");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 100, 30));

        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, 250, 10));

        t_normalMealRate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_normalMealRate.setForeground(new java.awt.Color(255, 255, 255));
        t_normalMealRate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_normalMealRate.setBorder(null);
        t_normalMealRate.setOpaque(false);
        getContentPane().add(t_normalMealRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, 250, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Normal Meal Rate");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, 110, 30));

        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 150, 250, 10));
        getContentPane().add(date_feastDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 320, 250, 30));
        getContentPane().add(date_startDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 380, 250, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Month Starts From");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 380, 120, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Month Ends On");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 440, 120, 30));
        getContentPane().add(date_endDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 440, 250, 30));

        lbl_totalMonthlyCost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_totalMonthlyCost.setForeground(new java.awt.Color(255, 255, 255));
        lbl_totalMonthlyCost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbl_totalMonthlyCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 250, 250, 30));

        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 280, 250, 10));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Feast Meal Rate");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 250, 100, 30));

        pnl_sideBar.setBackground(new java.awt.Color(0, 0, 0));
        pnl_sideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideBtn_addmmeber.setBackground(new java.awt.Color(51, 0, 153));
        sideBtn_addmmeber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sideBtn_addmmeber.setForeground(new java.awt.Color(255, 255, 255));
        sideBtn_addmmeber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sideBtn_addmmeber.setText("Add Member");
        sideBtn_addmmeber.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sideBtn_addmmeber.setOpaque(true);
        sideBtn_addmmeber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_addmmeberMouseClicked(evt);
            }
        });
        pnl_sideBar.add(sideBtn_addmmeber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 180, 40));

        jLabel13.setOpaque(true);
        pnl_sideBar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 10, 40));

        sideBtn_addMontlyExpensess.setBackground(new java.awt.Color(51, 0, 153));
        sideBtn_addMontlyExpensess.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sideBtn_addMontlyExpensess.setForeground(new java.awt.Color(255, 255, 255));
        sideBtn_addMontlyExpensess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sideBtn_addMontlyExpensess.setText("Preapre Month");
        sideBtn_addMontlyExpensess.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sideBtn_addMontlyExpensess.setOpaque(true);
        sideBtn_addMontlyExpensess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_addMontlyExpensessMouseClicked(evt);
            }
        });
        pnl_sideBar.add(sideBtn_addMontlyExpensess, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 180, 40));

        jLabel14.setOpaque(true);
        pnl_sideBar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 10, 40));

        sideBtn_addMealDetails.setBackground(new java.awt.Color(51, 0, 153));
        sideBtn_addMealDetails.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sideBtn_addMealDetails.setForeground(new java.awt.Color(255, 255, 255));
        sideBtn_addMealDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sideBtn_addMealDetails.setText("Meal Details");
        sideBtn_addMealDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sideBtn_addMealDetails.setOpaque(true);
        sideBtn_addMealDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_addMealDetailsMouseClicked(evt);
            }
        });
        pnl_sideBar.add(sideBtn_addMealDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 180, 40));

        jLabel17.setOpaque(true);
        pnl_sideBar.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 10, 40));

        sideBtn_collectExpense.setBackground(new java.awt.Color(51, 0, 153));
        sideBtn_collectExpense.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sideBtn_collectExpense.setForeground(new java.awt.Color(255, 255, 255));
        sideBtn_collectExpense.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sideBtn_collectExpense.setText("Collect Expense");
        sideBtn_collectExpense.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sideBtn_collectExpense.setOpaque(true);
        sideBtn_collectExpense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_collectExpenseMouseClicked(evt);
            }
        });
        pnl_sideBar.add(sideBtn_collectExpense, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 180, 40));

        jLabel19.setOpaque(true);
        pnl_sideBar.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 10, 40));

        sideBtn_manageMeals.setBackground(new java.awt.Color(51, 0, 153));
        sideBtn_manageMeals.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sideBtn_manageMeals.setForeground(new java.awt.Color(255, 255, 255));
        sideBtn_manageMeals.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sideBtn_manageMeals.setText("Manage Meal");
        sideBtn_manageMeals.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sideBtn_manageMeals.setOpaque(true);
        sideBtn_manageMeals.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_manageMealsMouseClicked(evt);
            }
        });
        pnl_sideBar.add(sideBtn_manageMeals, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 180, 40));

        jLabel20.setOpaque(true);
        pnl_sideBar.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 10, 40));

        sideBtn_updateMonth.setBackground(new java.awt.Color(51, 0, 153));
        sideBtn_updateMonth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sideBtn_updateMonth.setForeground(new java.awt.Color(255, 255, 255));
        sideBtn_updateMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sideBtn_updateMonth.setText("Update Month");
        sideBtn_updateMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sideBtn_updateMonth.setOpaque(true);
        sideBtn_updateMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_updateMonthMouseClicked(evt);
            }
        });
        pnl_sideBar.add(sideBtn_updateMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 180, 40));

        jLabel21.setOpaque(true);
        pnl_sideBar.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 10, 40));

        getContentPane().add(pnl_sideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 650));

        lbl_bg.setBackground(new java.awt.Color(0, 102, 102));
        lbl_bg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_bg.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/251850.jpg"))); // NOI18N
        lbl_bg.setOpaque(true);
        getContentPane().add(lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    double employee_fees = 0;
    int totalDays = 0;
    int totalFridays = 0;
    double friDayMealRate = 0;
    int numberOfNormalDaymeals = 0;
    double normalMealRate = 0;
    double feastMealRate = 0;

    private void btn_updateMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateMonthActionPerformed
        // TODO add your handling code here:

        List<Integer> cardList = memberServices.getAllActiveCards();
        Collections.sort(cardList);
        cardList.forEach((cardNo) -> {
            System.out.println(cardNo);
        });

        try {
            employee_fees = Double.parseDouble(t_empFees.getText().trim());
            totalDays = Integer.parseInt(t_totalDays.getText().trim());
            totalFridays = Integer.parseInt(t_totalDays.getText().trim());;
            friDayMealRate = Double.parseDouble(t_fridayMealRate.getText().trim());
            numberOfNormalDaymeals = Integer.parseInt(t_totalNoramlDays.getText().trim());;;
            normalMealRate = Double.parseDouble(t_normalMealRate.getText().trim());;
            feastMealRate = Double.parseDouble(t_feastMealRate.getText().trim());

        } catch (NumberFormatException e) {
            lbl_msgs.setText("Enter number not symbol or text");
            lbl_msgs.setForeground(Color.red);
            //return;
        }
        double totalCost = Double.parseDouble(lbl_totalMonthlyCost.getText());
        
        Date feastDate = new java.sql.Date(date_feastDate.getDate().getTime());
        Date startDate = new java.sql.Date(date_startDate.getDate().getTime());
        Date endDate = new java.sql.Date(date_endDate.getDate().getTime());

        if (employee_fees == 0 || totalDays == 0 || totalFridays == 0 || friDayMealRate == 0 || numberOfNormalDaymeals == 0
                || normalMealRate == 0 || feastMealRate == 0 || feastDate == null) {
            lbl_msgs.setText("Fill out all the fields");
            lbl_msgs.setForeground(Color.red);
        } else {
            MonthDetails monthDetails = new MonthDetails(monthName, year, employee_fees, totalDays, totalFridays, friDayMealRate, numberOfNormalDaymeals, normalMealRate, feastMealRate, totalCost, feastDate, startDate, endDate);
            lbl_msgs.setText("Wait...");
            lbl_msgs.setForeground(Color.red);
            if (monthDetailsServices.save(monthDetails) > 0) {

                MealDetailsServices.createMealDetailsTable(monthName, year, manager);
                mealHistoryServices.createMealHistoryTable(monthName, year, startDate, endDate);
                monthlyExpensessServices.createMontlyExpenseTable(manager);
                MealDayAndDateServices.createTable();
                mealDayAndDateServices.insertInDayWithDateTable(startDate, endDate);

                lbl_msgs.setText("Successfully saved");
                lbl_msgs.setForeground(Color.GREEN);
            } else {
                lbl_msgs.setText("Data not saved");
                lbl_msgs.setForeground(Color.red);
            }
        }

        //Updating Day with Date table

    }//GEN-LAST:event_btn_updateMonthActionPerformed

    private void t_feastMealRateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_feastMealRateKeyReleased
        // TODO add your handling code here:
        try {
            employee_fees = Double.parseDouble(t_empFees.getText().trim());
            totalDays = Integer.parseInt(t_totalDays.getText().trim());
            totalFridays = Integer.parseInt(t_totalDays.getText().trim());
            friDayMealRate = Double.parseDouble(t_fridayMealRate.getText().trim());
            numberOfNormalDaymeals = Integer.parseInt(t_totalNoramlDays.getText().trim());
            normalMealRate = Double.parseDouble(t_normalMealRate.getText().trim());
            feastMealRate = Double.parseDouble(t_feastMealRate.getText().trim());

        } catch (NumberFormatException e) {
            lbl_msgs.setText("Enter number not symbol or text");
            lbl_msgs.setForeground(Color.red);
            //return;
        }
        double total = employee_fees + totalFridays * friDayMealRate + numberOfNormalDaymeals * +normalMealRate + feastMealRate;
        lbl_totalMonthlyCost.setText(total + "");
    }//GEN-LAST:event_t_feastMealRateKeyReleased

    private void sideBtn_addmmeberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_addmmeberMouseClicked
        // TODO add your handling code here:
        new Addmember().setVisible(true);
    }//GEN-LAST:event_sideBtn_addmmeberMouseClicked

    private void sideBtn_addMontlyExpensessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_addMontlyExpensessMouseClicked
        // TODO add your handling code here:
        new UpdateMonthView(manager).setVisible(true);
    }//GEN-LAST:event_sideBtn_addMontlyExpensessMouseClicked

    private void sideBtn_addMealDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_addMealDetailsMouseClicked
        // TODO add your handling code here:
        new MealDetailsView(manager).setVisible(true);
    }//GEN-LAST:event_sideBtn_addMealDetailsMouseClicked

    private void sideBtn_collectExpenseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_collectExpenseMouseClicked
        // TODO add your handling code here:
        new MonthlyExpenseView(manager).setVisible(true);
    }//GEN-LAST:event_sideBtn_collectExpenseMouseClicked

    private void sideBtn_manageMealsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_manageMealsMouseClicked
        // TODO add your handling code here:
        new StopMealView(manager).setVisible(true);
    }//GEN-LAST:event_sideBtn_manageMealsMouseClicked

    private void sideBtn_updateMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_updateMonthMouseClicked
        // TODO add your handling code here:
        new UpdateMonthView(manager).setVisible(true);
    }//GEN-LAST:event_sideBtn_updateMonthMouseClicked
//
//    private void addToTable(Member member) {
//        //DefaultTableModel model = (DefaultTableModel) tbl_pInfo.getModel();
//
//        Object[] obj = new Object[6];
//
//        obj[0] = persoanlInfo.getName();
//        obj[1] = persoanlInfo.getContNum();
//        obj[2] = persoanlInfo.getEmail();
//        obj[3] = persoanlInfo.getDeptName();
//        obj[4] = persoanlInfo.getRegNum();
//        obj[5] = persoanlInfo.getSession();
//
//        //model.addRow(obj);
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateMonthView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateMonthView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateMonthView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateMonthView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateMonthView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_updateMonth;
    private com.toedter.calendar.JDateChooser date_endDate;
    private com.toedter.calendar.JDateChooser date_feastDate;
    private com.toedter.calendar.JDateChooser date_startDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lbl_bg;
    private javax.swing.JLabel lbl_monthName;
    private javax.swing.JLabel lbl_msgs;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_title1;
    private javax.swing.JLabel lbl_totalMonthlyCost;
    private javax.swing.JLabel lbl_year;
    private javax.swing.JPanel pnl_sideBar;
    private javax.swing.JLabel sideBtn_addMealDetails;
    private javax.swing.JLabel sideBtn_addMontlyExpensess;
    private javax.swing.JLabel sideBtn_addmmeber;
    private javax.swing.JLabel sideBtn_collectExpense;
    private javax.swing.JLabel sideBtn_manageMeals;
    private javax.swing.JLabel sideBtn_updateMonth;
    private javax.swing.JTextField t_empFees;
    private javax.swing.JTextField t_feastMealRate;
    private javax.swing.JTextField t_fridayMealRate;
    private javax.swing.JTextField t_normalMealRate;
    private javax.swing.JTextField t_toalFridays;
    private javax.swing.JTextField t_totalDays;
    private javax.swing.JTextField t_totalNoramlDays;
    // End of variables declaration//GEN-END:variables
}
