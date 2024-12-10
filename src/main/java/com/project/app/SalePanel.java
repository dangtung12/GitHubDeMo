package com.project.app;

import com.project.app.dao.EmployeeDAO;
import com.project.app.dao.ManagerDAO;
import com.project.app.dao.SaleDAO;
import com.project.app.dto.Manager;
import com.project.app.dto.SalesEmployee;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SalePanel extends javax.swing.JPanel {

    Locale vnLocale = new Locale("vi", "VN");
    NumberFormat nf = NumberFormat.getCurrencyInstance(vnLocale);

    public SalePanel() {
        initComponents();
        redesign();
    }

    private void hideButton() {
        btnSave.setVisible(false);
        btnReload.setVisible(false);

        btnAdd.setVisible(true);
        btnDel.setVisible(true);
        btnDel.setEnabled(false);
    }

    private void showButton() {
        btnSave.setVisible(true);
        btnReload.setVisible(true);

        btnAdd.setVisible(false);
        btnDel.setVisible(false);
    }

    private void redesign() {

        tableModel = (DefaultTableModel) tblData.getModel();
        tableModel.setRowCount(0);

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pos = tblData.rowAtPoint(e.getPoint());
                txtId.setText(tblData.getValueAt(pos, 0).toString());
                cboEmp.setSelectedItem(tblData.getValueAt(pos, 1).toString());
                txtDate.setText(tblData.getValueAt(pos, 2).toString());
                txtOt.setText(tblData.getValueAt(pos, 3).toString());
                txtHour.setText(tblData.getValueAt(pos, 4).toString());
                txtBase.setText(tblData.getValueAt(pos, 5).toString());
                txtNet.setText(tblData.getValueAt(pos, 6).toString());
                btnDel.setEnabled(true);
            }
        });
        fillData();
        hideButton();
        loadCombobox();
        disableTextbox();
        cboEmpActionPerformed(null);
    }

    private void disableTextbox() {
        txtId.setEnabled(false);
        txtId.setEditable(false);

        txtDate.setEnabled(false);
        txtDate.setEditable(false);

        txtOt.setEnabled(false);
        txtOt.setEditable(false);

        txtHour.setEnabled(false);
        txtHour.setEditable(false);

        cboEmp.setEnabled(false);
    }

    private void enableTextbox() {
        txtDate.setEnabled(true);
        txtDate.setEditable(true);

        txtOt.setEnabled(true);
        txtOt.setEditable(true);

        txtHour.setEnabled(true);
        txtHour.setEditable(true);

        cboEmp.setEnabled(true);
    }

    private void fillData() {
        tableModel.setRowCount(0);
        try {
            for (var b : SaleDAO.getInstance().getAll()) {
                Object data[] = new Object[10];
                data[0] = b.get_id();
                data[1] = b.getId() + " - " + b.getFullName();
                data[2] = b.getDateReceived();
                data[3] = b.getOtHours();
                data[4] = b.getHourWork();
                data[5] = nf.format(b.getBaseSalary());
                data[6] = nf.format(b.getNetSalary());

                tableModel.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void clearTextbox() {
        txtDate.setText("");
        txtId.setText("");
        txtHour.setText("");
        txtOt.setText("");
        txtNet.setText("");
    }

    private void reload() {
        fillData();
        disableTextbox();
        hideButton();
        clearTextbox();
    }

    private void loadCombobox() {
        try {
            cboEmpModel = new DefaultComboBoxModel<>();
            var allEmpl = EmployeeDAO.getInstance().getAll("Nhân viên bán hàng");
            for (var employee : allEmpl) {
                cboEmpModel.addElement(employee.getId() + " - " + employee.getFullName());
            }
            cboEmp.setModel(cboEmpModel);
        } catch (Exception ex) {
            Logger.getLogger(ManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtOt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboEmp = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtHour = new javax.swing.JTextField();
        txtBase = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNet = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnDel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 200));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Mã nhận lương:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 30));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 2, 290, 30));
        jPanel1.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 290, 30));

        jLabel2.setText("Nhân viên:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        jLabel3.setText("Số giờ OT:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 100, 30));
        jPanel1.add(txtOt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 290, 30));

        jLabel4.setText("Ngày nhận lượng:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, 30));

        cboEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmpActionPerformed(evt);
            }
        });
        jPanel1.add(cboEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 42, 290, 30));

        jLabel5.setText("Số giờ làm việc:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 100, 30));
        jPanel1.add(txtHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 290, 30));

        txtBase.setEditable(false);
        txtBase.setEnabled(false);
        jPanel1.add(txtBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 290, 30));

        jLabel6.setText("Lương cơ bản:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 100, 30));

        txtNet.setEditable(false);
        txtNet.setEnabled(false);
        jPanel1.add(txtNet, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 290, 30));

        jLabel7.setText("Lương thực lãnh");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 100, 30));

        btnDel.setText("Xóa");
        btnDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelMouseClicked(evt);
            }
        });
        jPanel1.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 80, 30));

        btnAdd.setText("Thêm");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 80, 30));

        btnSave.setText("Lưu");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 80, 30));

        btnReload.setText("Làm mới");
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReloadMouseClicked(evt);
            }
        });
        jPanel1.add(btnReload, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, 80, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Lương thực lãnh = (lương cơ bản * số giờ làm việc) + (số giờ OT * 30.000đ)");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 540, 30));

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhận lương", "Nhân viên", "Ngày nhận lương", "Số giờ OT", "Số giờ làm việc", "Lương cơ bản", "Lương thực lãnh"
            }
        ));
        jScrollPane1.setViewportView(tblData);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void cboEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmpActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            for (var o : EmployeeDAO.getInstance().getAll("Nhân viên bán hàng")) {
                if (Objects.equals(o.getId(), getIdEmployee())) {
                    txtBase.setText(nf.format(o.getBaseSalary()));
                    break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboEmpActionPerformed

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        enableTextbox();
        showButton();
        clearTextbox();
        txtDate.requestFocus();
    }//GEN-LAST:event_btnAddMouseClicked
    private Integer getIdEmployee() {
        if (cboEmp.getSelectedItem() == null) {
            return null;
        }
        var text = cboEmp.getSelectedItem().toString();
        return Integer.valueOf(text.split("-")[0].trim());
    }

    private Double getPrice(String text) {
        try {
            return nf.parse(text).doubleValue();
        } catch (ParseException e) {
        }
        try {
            return Double.valueOf(text);
        } catch (NumberFormatException e) {
        }
        return Double.valueOf(0);
    }
    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
        try {
            SalesEmployee item = new SalesEmployee();
            item.set_id(txtId.getText().isEmpty() ? 0 : Integer.valueOf(txtId.getText()));
            item.setOtHours(Integer.valueOf(txtOt.getText()));
            item.setHourWork(Integer.valueOf(txtHour.getText()));
            item.setDateReceived(txtDate.getText());
            item.setId(getIdEmployee());
            item.setBaseSalary(getPrice(txtBase.getText()));
            SaleDAO.getInstance().add(item);
            reload();
            JOptionPane.showMessageDialog(null, "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnDelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelMouseClicked
        // TODO add your handling code here:
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu để xóa", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            SaleDAO.getInstance().delete(Integer.parseInt(txtId.getText()));
            reload();
            JOptionPane.showMessageDialog(null, "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDelMouseClicked

    private void btnReloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReloadMouseClicked
        // TODO add your handling code here:
        reload();
    }//GEN-LAST:event_btnReloadMouseClicked

    private javax.swing.DefaultComboBoxModel<String> cboEmpModel;
    private javax.swing.table.DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboEmp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtBase;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtHour;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNet;
    private javax.swing.JTextField txtOt;
    // End of variables declaration//GEN-END:variables

}
