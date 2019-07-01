package view;

import controller.pojo.Manager;
import controller.pojo.Summary;
import java.awt.Color;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.dao.DeptNmaesServices;
import model.dao.*;

public class MonthlyReportForStudent extends javax.swing.JFrame {

    /**
     * Creates new form PersonalInfo
     */
    MemberServices memberServices = new MemberServices();
    DeptNmaesServices deptNmaesServices = new DeptNmaesServices();
    MealHistoryServices mealHistoryServices = new MealHistoryServices();
    ManagerService managerService = new ManagerService();

    ArrayList<String> deptNames = (ArrayList<String>) deptNmaesServices.getDepartmentList();
    LogingPage logingPage = new LogingPage();

    public MonthlyReportForStudent() {

        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Montly Report");
        lbl_bg.setBackground(new Color(0, 0, 0, 0));
        t_cardNo.setBackground(new Color(0, 0, 0, 0));

        designTable(tbl_report);

    }

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

        jSeparator1 = new javax.swing.JSeparator();
        lbl_title1 = new javax.swing.JLabel();
        lbl_title2 = new javax.swing.JLabel();
        t_cardNo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_msgs = new javax.swing.JLabel();
        lbl_title4 = new javax.swing.JLabel();
        btn_details = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_report = new javax.swing.JTable();
        lbl_isManagerNull = new javax.swing.JLabel();
        com_monthName = new javax.swing.JComboBox<>();
        com_year = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnl_sideBar = new javax.swing.JPanel();
        sideBtn_summary = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        sideBtn_summary1 = new javax.swing.JLabel();
        lbl_bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 1020, 20));

        lbl_title1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_title1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title1.setText("Monthly Report For Member");
        getContentPane().add(lbl_title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 280, 30));

        lbl_title2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_title2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title2.setText("Personal Information");
        getContentPane().add(lbl_title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 170, 30));

        t_cardNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_cardNo.setForeground(new java.awt.Color(255, 255, 255));
        t_cardNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_cardNo.setBorder(null);
        t_cardNo.setOpaque(false);
        getContentPane().add(t_cardNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 250, 30));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 250, 10));

        lbl_msgs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_msgs.setForeground(new java.awt.Color(255, 255, 255));
        lbl_msgs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbl_msgs, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 250, 30));

        lbl_title4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_title4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title4.setText("Card No");
        getContentPane().add(lbl_title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 70, 30));

        btn_details.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_details.setForeground(new java.awt.Color(255, 255, 255));
        btn_details.setText("Details");
        btn_details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_details.setContentAreaFilled(false);
        btn_details.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detailsActionPerformed(evt);
            }
        });
        getContentPane().add(btn_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 100, 40));

        tbl_report.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_report.setForeground(new java.awt.Color(255, 255, 255));
        tbl_report.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fields", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_report.setRowHeight(30);
        jScrollPane1.setViewportView(tbl_report);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 360, 430));

        lbl_isManagerNull.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_isManagerNull.setForeground(new java.awt.Color(255, 255, 255));
        lbl_isManagerNull.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbl_isManagerNull, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 250, 30));

        com_monthName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        com_monthName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        getContentPane().add(com_monthName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 250, 30));

        com_year.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        com_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Year", "2019", "2020", "2021", "2022" }));
        getContentPane().add(com_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 250, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Year");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 80, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Month Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 80, 30));

        pnl_sideBar.setBackground(new java.awt.Color(0, 0, 0));
        pnl_sideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideBtn_summary.setBackground(new java.awt.Color(51, 0, 153));
        sideBtn_summary.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sideBtn_summary.setForeground(new java.awt.Color(255, 255, 255));
        sideBtn_summary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sideBtn_summary.setText("For A Member");
        sideBtn_summary.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sideBtn_summary.setOpaque(true);
        sideBtn_summary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_summaryMouseClicked(evt);
            }
        });
        pnl_sideBar.add(sideBtn_summary, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 180, 40));

        jLabel16.setOpaque(true);
        pnl_sideBar.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 10, 40));

        jLabel17.setOpaque(true);
        pnl_sideBar.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 10, 40));

        sideBtn_summary1.setBackground(new java.awt.Color(51, 0, 153));
        sideBtn_summary1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sideBtn_summary1.setForeground(new java.awt.Color(255, 255, 255));
        sideBtn_summary1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sideBtn_summary1.setText("For A Month");
        sideBtn_summary1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sideBtn_summary1.setOpaque(true);
        sideBtn_summary1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_summary1MouseClicked(evt);
            }
        });
        pnl_sideBar.add(sideBtn_summary1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 180, 40));

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

    private void btn_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detailsActionPerformed
        // TODO add your handling code here:

        String monthName = com_monthName.getSelectedItem().toString();
        String year = com_year.getSelectedItem().toString();
        Manager manager = managerService.getManagerByMonthYear(monthName, year).get(0);
        int cardNo = 0;

        try {
            cardNo = Integer.parseInt(t_cardNo.getText().trim());

        } catch (NumberFormatException e) {
            lbl_msgs.setText("Enter only number");
            lbl_msgs.setForeground(Color.red);
            return;
        }

        if (mealHistoryServices.isCardExists(cardNo, manager)) {
            Summary report = mealHistoryServices.getSummary(cardNo, manager);

            Object[][] values = {{"Card No.", report.getCardNo()}, {"Total Meal", report.getTotalMeals()}, {"Total On Meal", report.getTotalMeals() - report.getTotalOffMeal()},
            {"Normal Off Meal", report.getNormalOffDays()}, {"Friday Off", report.getFridayOffMeal()}, {"Feast", report.getWasFeastOn() ? "Was off" : "Was on"},
            {"Total Off Meal", report.getTotalOffMeal()}, {"Remaining Balance", report.getBumping()}};

            DefaultTableModel model = (DefaultTableModel) tbl_report.getModel();
            model.setRowCount(0);
            for (Object[] value : values) {
                addToTable(value);
            }

        } else {
            lbl_msgs.setText("This card was not in this month");
            lbl_msgs.setForeground(Color.red);

        }

    }//GEN-LAST:event_btn_detailsActionPerformed

    private void sideBtn_summaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_summaryMouseClicked
        // TODO add your handling code here:
        new AddSummaryView().setVisible(true);
    }//GEN-LAST:event_sideBtn_summaryMouseClicked

    private void sideBtn_summary1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_summary1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sideBtn_summary1MouseClicked

    private void addToTable(Object[] values) {
        DefaultTableModel model = (DefaultTableModel) tbl_report.getModel();

        Object[] obj = new Object[2];

        obj[0] = values[0];
        obj[1] = values[1];
        model.addRow(obj);
    }

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
            java.util.logging.Logger.getLogger(MonthlyReportForStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonthlyReportForStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonthlyReportForStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonthlyReportForStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new MonthlyReportForStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_details;
    private javax.swing.JComboBox<String> com_monthName;
    private javax.swing.JComboBox<String> com_year;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_bg;
    private javax.swing.JLabel lbl_isManagerNull;
    private javax.swing.JLabel lbl_msgs;
    private javax.swing.JLabel lbl_title1;
    private javax.swing.JLabel lbl_title2;
    private javax.swing.JLabel lbl_title4;
    private javax.swing.JPanel pnl_sideBar;
    private javax.swing.JLabel sideBtn_summary;
    private javax.swing.JLabel sideBtn_summary1;
    private javax.swing.JTextField t_cardNo;
    private javax.swing.JTable tbl_report;
    // End of variables declaration//GEN-END:variables
}
