package com.mycompany.pharmacy.managment.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class CustomersFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CustomersFrame.class.getName());

    DefaultTableModel model;
    String name, address, phone, type;
    int row, id;
    Connection con = null;
    Statement stmt = null;
    ResultSet result = null;

    private void loadCustomers() {
        try {
            con = DBConnection.getConnection(); 
            stmt = con.createStatement();
            String query = "select  * from Customer;";
            result = stmt.executeQuery(query);

            while (result.next()) {
                model.addRow(new Object[]{
                    result.getString("Custm_ID"),
                    result.getString("Name_Custm"),
                    result.getString("Address_Custm"),
                    result.getString("Phone_Custm"),
                    result.getString("Type")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            }
            if (result != null) {
                try {
                    result.close();
                } catch (Exception e) {
                }
            }
        }
    }

    private void clearFields() {
        nameInput.setText(" ");
        addressInput.setText(" ");
        phoneInput.setText(" ");
        typeSelect.setSelectedItem("Individual");
    }

    public CustomersFrame() {
        initComponents();

        // set model for table
        model = new DefaultTableModel(
                new String[]{"Id", "Name", "Address", "Phone", "Type"}, 0
        );
        jTable1.setModel(model);
        setTitle("Customers Management");
        setSize(700, 500);
        setLocation(0, 600);
        loadCustomers();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        addressInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        phoneInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        typeSelect = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(4, 2, 0, 20));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel1.setText(" Name :");
        jPanel1.add(jLabel1);

        nameInput.addActionListener(this::nameInputActionPerformed);
        jPanel1.add(nameInput);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel2.setText(" Address : ");
        jPanel1.add(jLabel2);
        jPanel1.add(addressInput);

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel3.setText(" Phone :");
        jPanel1.add(jLabel3);

        phoneInput.addActionListener(this::phoneInputActionPerformed);
        jPanel1.add(phoneInput);

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel4.setText(" Type : ");
        jPanel1.add(jLabel4);

        typeSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Hospital", "Pharmacy" }));
        jPanel1.add(typeSelect);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Address", "Phone", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setLayout(new java.awt.GridLayout(1, 4, 20, 0));

        add.setText("Add");
        add.addActionListener(this::addActionPerformed);
        jPanel3.add(add);

        update.setText("Update");
        update.addActionListener(this::updateActionPerformed);
        jPanel3.add(update);

        jButton3.setText("Delete");
        jButton3.addActionListener(this::jButton3ActionPerformed);
        jPanel3.add(jButton3);

        Refresh.setText("Refresh");
        Refresh.setToolTipText("");
        Refresh.addActionListener(this::RefreshActionPerformed);
        jPanel3.add(Refresh);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void nameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInputActionPerformed

    private void phoneInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneInputActionPerformed


    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        name = nameInput.getText();
        address = addressInput.getText();
        phone = phoneInput.getText();
        type = typeSelect.getSelectedItem().toString();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please , Enter your Name ");
            return;
        }

        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please , Enter your Address ");
            return;
        }

        if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please , Enter your Phone ");
            return;
        }

        try {
            con = DBConnection.getConnection();
            String sql = "INSERT INTO Customer (Name_Custm, Address_Custm, Phone_Custm, [Type]) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phone);
            ps.setString(4, type);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Inserted Successfully ✅");

            model.setRowCount(0);
            loadCustomers();

            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }


    }//GEN-LAST:event_addActionPerformed


    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        row = jTable1.getSelectedRow();
        name = nameInput.getText();
        address = addressInput.getText();
        phone = phoneInput.getText();
        type = typeSelect.getSelectedItem().toString();
        id = Integer.parseInt(model.getValueAt(row, 0).toString());
        try {
            con = DBConnection.getConnection();
            String sql = "UPDATE Pharmace_Mangment.dbo.Customer SET Name_Custm = '" + name + "', Address_Custm = '" + address + "',Phone_Custm = '" + phone + "', Type = '" + type + "' WHERE Custm_ID = '" + id + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Update Successfully ✅");

            model.setRowCount(0);
            loadCustomers();

            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_updateActionPerformed

    private void selecteRow() {
        row = jTable1.getSelectedRow();
        if (row != -1) {
            nameInput.setText(model.getValueAt(row, 1).toString());
            addressInput.setText(model.getValueAt(row, 2).toString());
            phoneInput.setText(model.getValueAt(row, 3).toString()
            );
            typeSelect.setSelectedItem(
                    model.getValueAt(row, 4).toString()
            );
        }
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        selecteRow();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        row = jTable1.getSelectedRow();
        id = Integer.parseInt(model.getValueAt(row, 0).toString());
        try {
            con = DBConnection.getConnection();
            String sql = "delete FROM Pharmace_Mangment.dbo.Customer where Custm_ID = '" + id + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Delete Successfully ✅");

            model.setRowCount(0);
            loadCustomers();

            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        model.setRowCount(0);
        loadCustomers();
        
        clearFields();
    }//GEN-LAST:event_RefreshActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new CustomersFrame().setVisible(true));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Refresh;
    private javax.swing.JButton add;
    private javax.swing.JTextField addressInput;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameInput;
    private javax.swing.JTextField phoneInput;
    private javax.swing.JComboBox<String> typeSelect;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
