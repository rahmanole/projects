/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.pojo.Role;
import java.awt.Color;
import java.awt.Font;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.dao.DeptNmaesServices;
import model.dao.RoleServices;

/**
 *
 * @author OLEE
 */
public class AddAdminView extends javax.swing.JFrame {

    /**
     * Creates new form PersonalInfo
     */
    DeptNmaesServices deptNmaesServices = new DeptNmaesServices();
    RoleServices roleServices = new RoleServices();

    public AddAdminView() {
        initComponents();
        this.setLocationRelativeTo(null);
        t_eamil.setBackground(new Color(0, 0, 0, 0));
        //com_role.setBackground(new Color(0, 0, 0, 0));
        pnl_sideBar.setBackground(new Color(0, 0, 0, 100));
        sideBtn_addDept.setBackground(new Color(0, 0, 0, 0));
        sideBtn_addManager.setBackground(new Color(0, 0, 0, 0));
        sideBtn_home.setBackground(new Color(0, 0, 0, 0));
        sideBtn_addmmeber.setBackground(new Color(0, 0, 0, 0));
        sideBtn_monthlyReport.setBackground(new Color(0, 0, 0, 0));
        sideBtn_summary.setBackground(new Color(0, 0, 0, 0));

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
        lbl_oprtnFeedbck = new javax.swing.JLabel();
        btn_dlt = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_managerList = new javax.swing.JTable();
        t_eamil = new javax.swing.JTextField();
        com_role = new javax.swing.JComboBox<>();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        pnl_sideBar = new javax.swing.JPanel();
        sideBtn_home = new javax.swing.JPanel();
        eeee1 = new javax.swing.JLabel();
        sideBtn_addManager = new javax.swing.JPanel();
        lblgg = new javax.swing.JLabel();
        sideBtn_summary = new javax.swing.JPanel();
        www = new javax.swing.JLabel();
        sideBtn_monthlyReport = new javax.swing.JPanel();
        eeee = new javax.swing.JLabel();
        sideBtn_addAdmin = new javax.swing.JPanel();
        dddd = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        sideBtn_addDept = new javax.swing.JPanel();
        sdd = new javax.swing.JLabel();
        sideBtn_addmmeber = new javax.swing.JPanel();
        sss = new javax.swing.JLabel();
        lbl_bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Admin");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 620, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 1020, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Role");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 70, 30));
        getContentPane().add(lbl_oprtnFeedbck, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 250, 30));

        btn_dlt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_dlt.setForeground(new java.awt.Color(255, 255, 255));
        btn_dlt.setText("Delete");
        btn_dlt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_dlt.setContentAreaFilled(false);
        btn_dlt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btn_dlt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 100, 40));

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
        getContentPane().add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 100, 40));

        tbl_managerList.setBackground(new java.awt.Color(0, 0, 0));
        tbl_managerList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_managerList.setForeground(new java.awt.Color(255, 255, 255));
        tbl_managerList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "Role", "PIN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_managerList.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_managerList.setRowHeight(40);
        jScrollPane1.setViewportView(tbl_managerList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 460, 290));

        t_eamil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_eamil.setForeground(new java.awt.Color(255, 255, 255));
        t_eamil.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_eamil.setBorder(null);
        t_eamil.setOpaque(false);
        getContentPane().add(t_eamil, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 250, 30));

        com_role.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        com_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select role", "Admin" }));
        getContentPane().add(com_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 250, 30));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 250, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 70, 30));

        pnl_sideBar.setBackground(new java.awt.Color(0, 0, 0));
        pnl_sideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        pnl_sideBar.add(sideBtn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 190, 40));

        sideBtn_addManager.setBackground(new java.awt.Color(102, 102, 102));
        sideBtn_addManager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_addManagerMouseClicked(evt);
            }
        });
        sideBtn_addManager.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblgg.setBackground(new java.awt.Color(51, 0, 153));
        lblgg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblgg.setForeground(new java.awt.Color(255, 255, 255));
        lblgg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Manager_22px.png"))); // NOI18N
        lblgg.setText("Add Manager");
        lblgg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblgg.setIconTextGap(20);
        sideBtn_addManager.add(lblgg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

        pnl_sideBar.add(sideBtn_addManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 190, 40));

        sideBtn_summary.setBackground(new java.awt.Color(102, 102, 102));
        sideBtn_summary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_summaryMouseClicked(evt);
            }
        });
        sideBtn_summary.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        www.setBackground(new java.awt.Color(51, 0, 153));
        www.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        www.setForeground(new java.awt.Color(255, 255, 255));
        www.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Brief_22px.png"))); // NOI18N
        www.setText("Add Summary");
        www.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        www.setIconTextGap(20);
        sideBtn_summary.add(www, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

        pnl_sideBar.add(sideBtn_summary, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 190, 40));

        sideBtn_monthlyReport.setBackground(new java.awt.Color(102, 102, 102));
        sideBtn_monthlyReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_monthlyReportMouseClicked(evt);
            }
        });
        sideBtn_monthlyReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eeee.setBackground(new java.awt.Color(51, 0, 153));
        eeee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eeee.setForeground(new java.awt.Color(255, 255, 255));
        eeee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Report_Card_22px_3.png"))); // NOI18N
        eeee.setText("Monthly Report");
        eeee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eeee.setIconTextGap(20);
        sideBtn_monthlyReport.add(eeee, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

        pnl_sideBar.add(sideBtn_monthlyReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 190, 40));

        sideBtn_addAdmin.setBackground(new java.awt.Color(102, 102, 102));
        sideBtn_addAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_addAdminMouseClicked(evt);
            }
        });
        sideBtn_addAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dddd.setBackground(new java.awt.Color(51, 0, 153));
        dddd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dddd.setForeground(new java.awt.Color(255, 255, 255));
        dddd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Admin_Settings_Male_22px_1.png"))); // NOI18N
        dddd.setText("Add Admin");
        dddd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dddd.setIconTextGap(20);
        sideBtn_addAdmin.add(dddd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setOpaque(true);
        sideBtn_addAdmin.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        pnl_sideBar.add(sideBtn_addAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 190, 40));

        sideBtn_addDept.setBackground(new java.awt.Color(102, 102, 102));
        sideBtn_addDept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_addDeptMouseClicked(evt);
            }
        });
        sideBtn_addDept.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sdd.setBackground(new java.awt.Color(51, 0, 153));
        sdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sdd.setForeground(new java.awt.Color(255, 255, 255));
        sdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Department_22px.png"))); // NOI18N
        sdd.setText("Add Department");
        sdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sdd.setIconTextGap(20);
        sideBtn_addDept.add(sdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

        pnl_sideBar.add(sideBtn_addDept, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 190, 40));

        sideBtn_addmmeber.setBackground(new java.awt.Color(102, 102, 102));
        sideBtn_addmmeber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBtn_addmmeberMouseClicked(evt);
            }
        });
        sideBtn_addmmeber.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sss.setBackground(new java.awt.Color(51, 0, 153));
        sss.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sss.setForeground(new java.awt.Color(255, 255, 255));
        sss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Member_22px_1.png"))); // NOI18N
        sss.setText("Add Member");
        sss.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sss.setIconTextGap(20);
        sideBtn_addmmeber.add(sss, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

        pnl_sideBar.add(sideBtn_addmmeber, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, 40));

        getContentPane().add(pnl_sideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 650));

        lbl_bg.setBackground(new java.awt.Color(51, 0, 51));
        lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/251850.jpg"))); // NOI18N
        lbl_bg.setOpaque(true);
        getContentPane().add(lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:

        String email = t_eamil.getText().trim();

        String roleName = com_role.getSelectedItem().toString();
        String pin = generatePin().toLowerCase();

        if (email.isEmpty() || roleName.equals("Select role")) {
            lbl_oprtnFeedbck.setText("Enter all data");
            lbl_oprtnFeedbck.setForeground(Color.red);
        } else {
            Role role = new Role(email, roleName, pin);
            if (!roleServices.isEmailExists(email)) {
                if (roleServices.save(role, lbl_oprtnFeedbck) > 0) {
                    addToTable(role);
                    lbl_oprtnFeedbck.setText("PIN Code:" + pin);
                    lbl_oprtnFeedbck.setForeground(Color.WHITE);
                    lbl_oprtnFeedbck.setFont(new Font("Serif", Font.PLAIN, 14));
                }
            } else {
                lbl_oprtnFeedbck.setText("Email already exists");
                lbl_oprtnFeedbck.setForeground(Color.red);
            }
        }


    }//GEN-LAST:event_btn_saveActionPerformed

    private void sideBtn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBtn_homeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sideBtn_homeMouseClicked

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

    private void addToTable(Role role) {
        DefaultTableModel model = (DefaultTableModel) tbl_managerList.getModel();

        Object[] obj = new Object[3];

        obj[0] = role.getEmail();
        obj[1] = role.getRoleNmae();
        obj[2] = role.getPin();
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
            java.util.logging.Logger.getLogger(AddAdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AddAdminView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dlt;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> com_role;
    private javax.swing.JLabel dddd;
    private javax.swing.JLabel eeee;
    private javax.swing.JLabel eeee1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbl_bg;
    private javax.swing.JLabel lbl_oprtnFeedbck;
    private javax.swing.JLabel lblgg;
    private javax.swing.JPanel pnl_sideBar;
    private javax.swing.JLabel sdd;
    private javax.swing.JPanel sideBtn_addAdmin;
    private javax.swing.JPanel sideBtn_addDept;
    private javax.swing.JPanel sideBtn_addManager;
    private javax.swing.JPanel sideBtn_addmmeber;
    private javax.swing.JPanel sideBtn_home;
    private javax.swing.JPanel sideBtn_monthlyReport;
    private javax.swing.JPanel sideBtn_summary;
    private javax.swing.JLabel sss;
    private javax.swing.JTextField t_eamil;
    private javax.swing.JTable tbl_managerList;
    private javax.swing.JLabel www;
    // End of variables declaration//GEN-END:variables
}
