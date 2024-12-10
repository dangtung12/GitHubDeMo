package com.project.app;

import java.awt.BorderLayout;


public class MainFrame extends javax.swing.JFrame {

    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        redesign();
    }
    private void redesign() {
        pnContent.add(new ManagerPanel(), BorderLayout.CENTER);
        pnContent.repaint();
        pnContent.validate();
        
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMnEmployee = new javax.swing.JButton();
        btnMnEmployee1 = new javax.swing.JButton();
        btnMnEmployee2 = new javax.swing.JButton();
        pnContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý tiền lương nhân viên cửa hàng tiện ích ");
        setMaximumSize(new java.awt.Dimension(1200, 700));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 700));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1025, 60));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(102, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý tiền lương nhân viên cửa hàng tiện ích");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setAlignmentX(5.0F);
        jPanel2.setAlignmentY(5.0F);
        jPanel2.setPreferredSize(new java.awt.Dimension(230, 100));

        btnMnEmployee.setBackground(new java.awt.Color(51, 153, 255));
        btnMnEmployee.setText("Quản lý nhân viên");
        btnMnEmployee.setPreferredSize(new java.awt.Dimension(150, 50));
        btnMnEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMnEmployeeMouseClicked(evt);
            }
        });

        btnMnEmployee1.setBackground(new java.awt.Color(51, 153, 255));
        btnMnEmployee1.setText("Tính lương cho quản lý");
        btnMnEmployee1.setPreferredSize(new java.awt.Dimension(150, 50));
        btnMnEmployee1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMnEmployee1MouseClicked(evt);
            }
        });

        btnMnEmployee2.setBackground(new java.awt.Color(51, 153, 255));
        btnMnEmployee2.setText("Tính lương nhân viên bán hàng");
        btnMnEmployee2.setPreferredSize(new java.awt.Dimension(150, 50));
        btnMnEmployee2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMnEmployee2MouseClicked(evt);
            }
        });
        btnMnEmployee2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMnEmployee2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMnEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(btnMnEmployee1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMnEmployee2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnMnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnMnEmployee1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnMnEmployee2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);
        getContentPane().add(pnContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMnEmployee2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMnEmployee2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMnEmployee2ActionPerformed

    private void btnMnEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMnEmployeeMouseClicked
        // TODO add your handling code here:
        pnContent.removeAll();
        
        pnContent.add(new EmployeeJPanel(), BorderLayout.CENTER);
        pnContent.repaint();
        pnContent.validate();
    }//GEN-LAST:event_btnMnEmployeeMouseClicked

    private void btnMnEmployee1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMnEmployee1MouseClicked
        // TODO add your handling code here:
        pnContent.removeAll();
        
        pnContent.add(new ManagerPanel(), BorderLayout.CENTER);
        pnContent.repaint();
        pnContent.validate();
    }//GEN-LAST:event_btnMnEmployee1MouseClicked

    private void btnMnEmployee2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMnEmployee2MouseClicked
        // TODO add your handling code here:
        pnContent.removeAll();
        
        pnContent.add(new SalePanel(), BorderLayout.CENTER);
        pnContent.repaint();
        pnContent.validate();
    }//GEN-LAST:event_btnMnEmployee2MouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//
//        java.awt.EventQueue.invokeLater(() -> {
//            new MainFrame().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMnEmployee;
    private javax.swing.JButton btnMnEmployee1;
    private javax.swing.JButton btnMnEmployee2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnContent;
    // End of variables declaration//GEN-END:variables

}
