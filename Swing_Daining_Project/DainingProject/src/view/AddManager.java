/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.pojo.Manager;
import controller.pojo.Role;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.dao.DeptNmaesServices;
import model.dao.ManagerService;
import model.dao.RoleServices;

public class AddManager extends javax.swing.JFrame {

    /**
     * Creates new form PersonalInfo
     */
    DeptNmaesServices deptNmaesServices = new DeptNmaesServices();
    ManagerService managerService = new ManagerService();
    RoleServices roleServices = new RoleServices();

    public AddManager() {
        initComponents();
        this.setLocationRelativeTo(null);
        t_cardNo.setBackground(new Color(0, 0, 0, 0));
        t_eamil.setBackground(new Color(0, 0, 0, 0));
        //com_month.setBackground(new Color(0, 0, 0, 0));
        //com_year.setBackground(new Color(0, 0, 0, 0));
        pnl_sideBar1.setBackground(new Color(0, 0, 0, 100));
        
        sideBtn_addDept1.setBackground(new Color(0, 0, 0, 0));
        sideBtn_addAdmin1.setBackground(new Color(0, 0, 0, 0));
        sideBtn_home.setBackground(new Color(0, 0, 0, 0));
        sideBtn_addmmeber1.setBackground(new Color(0, 0, 0, 0));
        sideBtn_monthlyReport1.setBackground(new Color(0, 0, 0, 0));
        sideBtn_summary1.setBackground(new Color(0, 0, 0, 0));
        

        designTable(tbl_managerList);
    }

    private void designTable(JTable tableName) {
        tableName.getTableHeader().setForeground(new Color(255, 255, 255));
        tableName.getTableHeader().setBackground(Color.BLACK);
        tableName.getTableHeader().setForeground(Color.black);
        ((DefaultTableCellRenderer) tableName.getDefaultRenderer(Object.class)).setOpaque(false);

        tableName.setBackground(new Color(0, 0, 0));
        jScrollPane1.setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.getViewport().setOpaque(false);
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

        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_oprtnFeedbck = new javax.swing.JLabel();
        btn_dlt = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_managerList = new javax.swing.JTable();
        t_eamil = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        com_year = new javax.swing.JComboBox<>();
        com_month = new javax.swing.JComboBox<>();
        t_cardNo = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        pnl_sideBar1 = new javax.swing.JPanel();
        sideBtn_home = new javax.swing.JPanel();
        eeee1 = new javax.swing.JLabel();
        sideBtn_addManager1 = new javax.swing.JPanel();
        lblgg1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        sideBtn_summary1 = new javax.swing.JPanel();
        www1 = new javax.swing.JLabel();
        sideBtn_monthlyReport1 = new javax.swing.JPanel();
        eeee2 = new javax.swing.JLabel();
        sideBtn_addAdmin1 = new javax.swing.JPanel();
        dddd1 = new javax.swing.JLabel();
        sideBtn_addDept1 = new javax.swing.JPanel();
        sdd1 = new javax.swing.JLabel();
        sideBtn_addmmeber1 = new javax.swing.JPanel();
        sss1 = new javax.swing.JLabel();
        lbl_bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(" Assign Manager");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 620, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 1020, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Month");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 70, 30));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 250, 10));
        getContentPane().add(lbl_oprtnFeedbck, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 250, 30));

        btn_dlt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_dlt.setForeground(new java.awt.Color(255, 255, 255));
        btn_dlt.setText("Delete");
        btn_dlt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_dlt.setContentAreaFilled(false);
        btn_dlt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btn_dlt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, 100, 40));

        btn_save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("Save");
        btn_save.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_save.setContentAreaFilled(false);
        btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        getContentPane().add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 100, 40));

        tbl_managerList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_managerList.setForeground(new java.awt.Color(255, 255, 255));
        tbl_managerList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Card No", "Month", "Year", "PIN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_managerList.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_managerList.setRowHeight(30);
        jScrollPane1.setViewportView(tbl_managerList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 460, 420));

        t_eamil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_eamil.setForeground(new java.awt.Color(255, 255, 255));
        t_eamil.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_eamil.setBorder(null);
        t_eamil.setOpaque(false);
        getContentPane().add(t_eamil, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 250, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Card No");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 70, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Year");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 70, 30));

        com_year.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        com_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select year", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
        getContentPane().add(com_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 250, 30));

        com_month.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        com_month.setForeground(new java.awt.Color(255, 255, 255));
        com_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        getContentPane().add(com_month, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 250, 30));

        t_cardNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_cardNo.setForeground(new java.awt.Color(255, 255, 255));
        t_cardNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_cardNo.setBorder(null);
        t_cardNo.setOpaque(false);
        getContentPane().add(t_cardNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 250, 30));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 250, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 70, 30));

        pnl_sideBar1.setBackground(new java.awt.Color(0, 0, 0));
        pnl_sideBar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideBtn_home.setBackground(new java.awt.Color(102, 102, 102));
        sideBtn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_homeMouseClicked(evt);
            }
        });
        sideBtn_home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eeee1.setBackground(new java.awt.Color(51, 0, 153));
        eeee1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eeee1.setForeground(new java.awt.Color(255, 255, 255));
        eeee1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Home_22px_3.png"))); // NOI18N
        eeee1.setText("Home");
        eeee1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eeee1.setIconTextGap(20);
        sideBtn_home.add(eeee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

        pnl_sideBar1.add(sideBtn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 190, 40));

        sideBtn_addManager1.setBackground(new java.awt.Color(102, 102, 102));
        sideBtn_addManager1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_addManager1MouseClicked(evt);
            }
        });
        sideBtn_addManager1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblgg1.setBackground(new java.awt.Color(51, 0, 153));
        lblgg1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblgg1.setForeground(new java.awt.Color(255, 255, 255));
        lblgg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Manager_22px.png"))); // NOI18N
        lblgg1.setText("Add Manager");
        lblgg1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblgg1.setIconTextGap(20);
        sideBtn_addManager1.add(lblgg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setOpaque(true);
        sideBtn_addManager1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        pnl_sideBar1.add(sideBtn_addManager1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 190, 40));

        sideBtn_summary1.setBackground(new java.awt.Color(102, 102, 102));
        sideBtn_summary1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_summary1MouseClicked(evt);
            }
        });
        sideBtn_summary1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        www1.setBackground(new java.awt.Color(51, 0, 153));
        www1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        www1.setForeground(new java.awt.Color(255, 255, 255));
        www1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Brief_22px.png"))); // NOI18N
        www1.setText("Add Summary");
        www1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        www1.setIconTextGap(20);
        sideBtn_summary1.add(www1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

        pnl_sideBar1.add(sideBtn_summary1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 190, 40));

        sideBtn_monthlyReport1.setBackground(new java.awt.Color(102, 102, 102));
        sideBtn_monthlyReport1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_monthlyReport1MouseClicked(evt);
            }
        });
        sideBtn_monthlyReport1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eeee2.setBackground(new java.awt.Color(51, 0, 153));
        eeee2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eeee2.setForeground(new java.awt.Color(255, 255, 255));
        eeee2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Report_Card_22px_3.png"))); // NOI18N
        eeee2.setText("Monthly Report");
        eeee2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eeee2.setIconTextGap(20);
        sideBtn_monthlyReport1.add(eeee2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

        pnl_sideBar1.add(sideBtn_monthlyReport1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 190, 40));

        sideBtn_addAdmin1.setBackground(new java.awt.Color(102, 102, 102));
        sideBtn_addAdmin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_addAdmin1MouseClicked(evt);
            }
        });
        sideBtn_addAdmin1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dddd1.setBackground(new java.awt.Color(51, 0, 153));
        dddd1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dddd1.setForeground(new java.awt.Color(255, 255, 255));
        dddd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Admin_Settings_Male_22px_1.png"))); // NOI18N
        dddd1.setText("Add Admin");
        dddd1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dddd1.setIconTextGap(20);
        sideBtn_addAdmin1.add(dddd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

        pnl_sideBar1.add(sideBtn_addAdmin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 190, 40));

        sideBtn_addDept1.setBackground(new java.awt.Color(102, 102, 102));
        sideBtn_addDept1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_addDept1MouseClicked(evt);
            }
        });
        sideBtn_addDept1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sdd1.setBackground(new java.awt.Color(51, 0, 153));
        sdd1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sdd1.setForeground(new java.awt.Color(255, 255, 255));
        sdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Department_22px.png"))); // NOI18N
        sdd1.setText("Add Department");
        sdd1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sdd1.setIconTextGap(20);
        sideBtn_addDept1.add(sdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

        pnl_sideBar1.add(sideBtn_addDept1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 190, 40));

        sideBtn_addmmeber1.setBackground(new java.awt.Color(102, 102, 102));
        sideBtn_addmmeber1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_addmmeber1MouseClicked(evt);
            }
        });
        sideBtn_addmmeber1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sss1.setBackground(new java.awt.Color(51, 0, 153));
        sss1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sss1.setForeground(new java.awt.Color(255, 255, 255));
        sss1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Member_22px_1.png"))); // NOI18N
        sss1.setText("Add Member");
        sss1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sss1.setIconTextGap(20);
        sideBtn_addmmeber1.add(sss1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

        pnl_sideBar1.add(sideBtn_addmmeber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, 40));

        getContentPane().add(pnl_sideBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 650));

        lbl_bg.setBackground(new java.awt.Color(51, 0, 51));
        lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/251850.jpg"))); // NOI18N
        lbl_bg.setOpaque(true);
        getContentPane().add(lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:

        int cardNo = 0;
        String email = t_eamil.getText().trim().toLowerCase();
        try {
            cardNo = Integer.parseInt(t_cardNo.getText().trim());
        } catch (NumberFormatException e) {
            lbl_oprtnFeedbck.setText("Card no should be digit only");
            lbl_oprtnFeedbck.setForeground(Color.red);
        }
        String month = com_month.getSelectedItem().toString();
        String year = com_year.getSelectedItem().toString();
        String pin = generatePin().toLowerCase();
        while (roleServices.getPinList().contains(pin)) {
            pin = generatePin().toLowerCase();
        }

        if (cardNo == 0 || month.equals("Select month") || year.equals("Select year")) {
            lbl_oprtnFeedbck.setText("Enter all data");
            lbl_oprtnFeedbck.setForeground(Color.red);
        } else {
            List<Manager> managerList = managerService.getManagerByMonthYear(month, year);
            Manager manager = new Manager(cardNo, month, year, pin);

            if (managerList.size() < 2) {
                if (managerService.isThisCardAssignedForThisMonth(month, year, cardNo)) {
                    lbl_oprtnFeedbck.setText("This manager already aasinged for this month");
                    lbl_oprtnFeedbck.setForeground(Color.red);
                } else {
                    if (managerService.save(manager, lbl_oprtnFeedbck) > 0) {
                        addToTable(manager);
                        Role role = new Role(email, "manager", pin);
                        roleServices.save(role, lbl_bg);
                        lbl_oprtnFeedbck.setText("PIN Code: " + pin.toUpperCase());
                        lbl_oprtnFeedbck.setForeground(Color.WHITE);
                        lbl_oprtnFeedbck.setFont(new Font("Serif", Font.PLAIN, 14));
                    }
                }

            } else {
                lbl_oprtnFeedbck.setText("Two Manager added For This Month");
                lbl_oprtnFeedbck.setForeground(Color.red);
            }

        }


    }//GEN-LAST:event_btn_saveActionPerformed

    private void sideBtn_addManagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_addManagerMouseClicked
        // TODO add your handling code here:
        new AddManager().setVisible(true);
    }//GEN-LAST:event_sideBtn_addManagerMouseClicked

    private void sideBtn_summaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_summaryMouseClicked
        // TODO add your handling code here:
        new AddSummaryView().setVisible(true);
    }//GEN-LAST:event_sideBtn_summaryMouseClicked

    private void sideBtn_monthlyReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_monthlyReportMouseClicked
        // TODO add your handling code here:
        new AdminDashboard().setVisible(true);
    }//GEN-LAST:event_sideBtn_monthlyReportMouseClicked

    private void sideBtn_addAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_addAdminMouseClicked
        // TODO add your handling code here:
        new AddAdminView().setVisible(true);
    }//GEN-LAST:event_sideBtn_addAdminMouseClicked

    private void sideBtn_addDeptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_addDeptMouseClicked
        // TODO add your handling code here:
        new AddDeptView().setVisible(true);
    }//GEN-LAST:event_sideBtn_addDeptMouseClicked

    private void sideBtn_addmmeberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_addmmeberMouseClicked
        // TODO add your handling code here:
        new Addmember().setVisible(true);
    }//GEN-LAST:event_sideBtn_addmmeberMouseClicked

    private void sideBtn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_homeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sideBtn_homeMouseClicked

    private void sideBtn_addManager1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_addManager1MouseClicked
        // TODO add your handling code here:
        new AddManager().setVisible(true);
    }//GEN-LAST:event_sideBtn_addManager1MouseClicked

    private void sideBtn_summary1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_summary1MouseClicked
        // TODO add your handling code here:
        new AddSummaryView().setVisible(true);
    }//GEN-LAST:event_sideBtn_summary1MouseClicked

    private void sideBtn_monthlyReport1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_monthlyReport1MouseClicked
        // TODO add your handling code here:
        new AdminDashboard().setVisible(true);
    }//GEN-LAST:event_sideBtn_monthlyReport1MouseClicked

    private void sideBtn_addAdmin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_addAdmin1MouseClicked
        // TODO add your handling code here:
        new AddAdminView().setVisible(true);
    }//GEN-LAST:event_sideBtn_addAdmin1MouseClicked

    private void sideBtn_addDept1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_addDept1MouseClicked
        // TODO add your handling code here:
        new AddDeptView().setVisible(true);
    }//GEN-LAST:event_sideBtn_addDept1MouseClicked

    private void sideBtn_addmmeber1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_addmmeber1MouseClicked
        // TODO add your handling code here:
        new Addmember().setVisible(true);
    }//GEN-LAST:event_sideBtn_addmmeber1MouseClicked

    private String generatePin() {
        String pin = "";

        for (int i = 0; i < 7; i++) {

            if (i == 3 || i == 4 || i == 6) {
                pin += (char) ThreadLocalRandom.current().nextInt(65, 90 + 1);
            } else {
                pin += (int) (10 * Math.random()) + "";
            }

        }
        return pin;
    }

    private void addToTable(Manager manager) {
        DefaultTableModel model = (DefaultTableModel) tbl_managerList.getModel();

        Object[] obj = new Object[4];

        obj[0] = manager.getCardNo();
        obj[1] = manager.getMonthName();
        obj[2] = manager.getYear();
        obj[3] = manager.getPin().toUpperCase();
        model.addRow(obj);
    }

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
            java.util.logging.Logger.getLogger(AddManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dlt;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> com_month;
    private javax.swing.JComboBox<String> com_year;
    private javax.swing.JLabel dddd1;
    private javax.swing.JLabel eeee1;
    private javax.swing.JLabel eeee2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbl_bg;
    private javax.swing.JLabel lbl_oprtnFeedbck;
    private javax.swing.JLabel lblgg1;
    private javax.swing.JPanel pnl_sideBar1;
    private javax.swing.JLabel sdd1;
    private javax.swing.JPanel sideBtn_addAdmin1;
    private javax.swing.JPanel sideBtn_addDept1;
    private javax.swing.JPanel sideBtn_addManager1;
    private javax.swing.JPanel sideBtn_addmmeber1;
    private javax.swing.JPanel sideBtn_home;
    private javax.swing.JPanel sideBtn_monthlyReport1;
    private javax.swing.JPanel sideBtn_summary1;
    private javax.swing.JLabel sss1;
    private javax.swing.JTextField t_cardNo;
    private javax.swing.JTextField t_eamil;
    private javax.swing.JTable tbl_managerList;
    private javax.swing.JLabel www1;
    // End of variables declaration//GEN-END:variables
}