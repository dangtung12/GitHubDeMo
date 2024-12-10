package com.project.app;

import com.project.app.dao.EmployeeDAO;
import com.project.app.dao.ManagerDAO;
import com.project.app.dto.Manager;
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

public class ManagerPanel extends javax.swing.JPanel {

    Locale vnLocale = new Locale("vi", "VN");
    NumberFormat nf = NumberFormat.getCurrencyInstance(vnLocale);

    public ManagerPanel() {
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
                cboMana.setSelectedItem(tblData.getValueAt(pos, 1).toString());
                txtDate.setText(tblData.getValueAt(pos, 2).toString());
                txtRevenue.setText(tblData.getValueAt(pos, 3).toString());
                txtRate.setText(tblData.getValueAt(pos, 4).toString());
                txtBaseSalary.setText(tblData.getValueAt(pos, 5).toString());
                txtNetSalary.setText(tblData.getValueAt(pos, 6).toString());
                btnDel.setEnabled(true);
            }
        });
        fillData();
        hideButton();
        loadCombobox();
        disableTextbox();
        cboManaActionPerformed(null);
    }

    private void disableTextbox() {
        txtId.setEnabled(false);
        txtId.setEditable(false);

        txtDate.setEnabled(false);
        txtDate.setEditable(false);

        txtNetSalary.setEnabled(false);
        txtNetSalary.setEditable(false);

        txtRate.setEnabled(false);
        txtRate.setEditable(false);

        txtRevenue.setEnabled(false);
        txtRevenue.setEditable(false);

        cboMana.setEnabled(false);
    }

    private void enableTextbox() {
        txtDate.setEnabled(true);
        txtDate.setEditable(true);

        txtRate.setEnabled(true);
        txtRate.setEditable(true);

        txtRevenue.setEnabled(true);
        txtRevenue.setEditable(true);

        cboMana.setEnabled(true);
    }

    private void fillData() {
        tableModel.setRowCount(0);
        try {
            for (Manager b : ManagerDAO.getInstance().getAll()) {
                Object data[] = new Object[10];
                data[0] = b.get_id();
                data[1] = b.getId() + " - " + b.getFullName();
                data[2] = b.getDateReceived();
                data[3] = nf.format(b.getRevenue());
                data[4] = b.getCommissionRate();
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
        txtNetSalary.setText("");
        txtRate.setText("");
        txtRevenue.setText("");
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
            var allEmpl = EmployeeDAO.getInstance().getAll("Quản lý");
            for (var employee : allEmpl) {
                cboEmpModel.addElement(employee.getId() + " - " + employee.getFullName());
            }
            cboMana.setModel(cboEmpModel);
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
        jLabel2 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRevenue = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNetSalary = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cboMana = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBaseSalary = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 180));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Quản lý:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, 30));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 290, 30));

        jLabel2.setText("Ngày nhận:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 30));
        jPanel1.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 290, 30));

        jLabel3.setText("Doanh thu:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, 30));
        jPanel1.add(txtRevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 290, 30));

        jLabel4.setText("Phần trăm hoa hồng:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 130, 30));
        jPanel1.add(txtRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 290, 30));

        jLabel5.setText("Lương thực lãnh:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 130, 30));
        jPanel1.add(txtNetSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 290, 30));

        btnSave.setText("Lưu");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 100, 30));

        btnAdd.setText("Thêm");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 100, 30));

        btnReload.setText("Làm mới");
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReloadMouseClicked(evt);
            }
        });
        jPanel1.add(btnReload, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 100, 30));

        btnDel.setText("Xóa");
        btnDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelMouseClicked(evt);
            }
        });
        jPanel1.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 100, 30));

        jLabel6.setText("Mã nhận lương quản lý");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        cboMana.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboManaItemStateChanged(evt);
            }
        });
        cboMana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboManaActionPerformed(evt);
            }
        });
        jPanel1.add(cboMana, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 290, 30));

        jLabel7.setBackground(new java.awt.Color(255, 204, 204));
        jLabel7.setForeground(new java.awt.Color(0, 51, 255));
        jLabel7.setText("Lương của quản lý = Lương cơ bản + (doanh thu * phần trăm)");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 390, -1));

        jLabel8.setText("Lương cơ bản:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 130, 30));

        txtBaseSalary.setEditable(false);
        txtBaseSalary.setEnabled(false);
        jPanel1.add(txtBaseSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 290, 30));

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
                "Mã nhận lương", "Quản lý", "Ngày nhận", "Doanh thu", "Phần trăm hoa hồng", "Lương cơ bản", "Lương thực lãnh"
            }
        ));
        jScrollPane1.setViewportView(tblData);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        enableTextbox();
        showButton();
        clearTextbox();
        txtDate.requestFocus();
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnReloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReloadMouseClicked
        // TODO add your handling code here:
        reload();
    }//GEN-LAST:event_btnReloadMouseClicked

    private Integer getIdEmployee() {
        if (cboMana.getSelectedItem() == null) {
            return null;
        }
        var text = cboMana.getSelectedItem().toString();
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
            Manager item = new Manager();
            item.set_id(txtId.getText().isEmpty() ? 0 : Integer.valueOf(txtId.getText()));
            item.setCommissionRate(Double.valueOf(txtRate.getText()));
            item.setRevenue(Double.valueOf(txtRevenue.getText()));
            item.setDateReceived(txtDate.getText());
            item.setId(getIdEmployee());
            item.setBaseSalary(getPrice(txtBaseSalary.getText()));
            ManagerDAO.getInstance().add(item);
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
            ManagerDAO.getInstance().delete(Integer.parseInt(txtId.getText()));
            reload();
            JOptionPane.showMessageDialog(null, "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDelMouseClicked

    private void cboManaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboManaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboManaItemStateChanged

    private void cboManaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboManaActionPerformed
        try {
            // TODO add your handling code here:
            for (var o : EmployeeDAO.getInstance().getAll("Quản lý")) {
                if(Objects.equals(o.getId(), getIdEmployee())){
                    txtBaseSalary.setText(nf.format(o.getBaseSalary()));
                    break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboManaActionPerformed
    private javax.swing.DefaultComboBoxModel<String> cboEmpModel;
    private javax.swing.table.DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboMana;
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
    private javax.swing.JTextField txtBaseSalary;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNetSalary;
    private javax.swing.JTextField txtRate;
    private javax.swing.JTextField txtRevenue;
    // End of variables declaration//GEN-END:variables

}
