/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pharmacy.managment.system;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class OrdersFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(OrdersFrame.class.getName());
    DefaultTableModel model;
    int row, id;
    String customer, date, status, product, quantity;

    Connection con = null;
    Statement stmt = null;
    ResultSet result = null;

    private void loadCustomers() {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select Custm_ID ,Name_Custm from Customer";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            customerSelect.removeAllItems(); // مهم

            while (rs.next()) {
                customerSelect.addItem(
                        rs.getInt("Custm_ID") + " - " + rs.getString("Name_Custm")
                );
            }

        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Customers Error " + e);
        }
    }

    private void loadProducts() {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select Product_ID ,Name from Products";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            productSelect.removeAllItems(); // مهم

            while (rs.next()) {
                productSelect.addItem(
                        rs.getInt("Product_ID") + " - " + rs.getString("Name")
                );
            }

        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Products Error " + e);
        }
    }

    private void loadOrders() {
        try {
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            String query = """
        SELECT o.order_id , o.order_date , o.status, o.amount, p.Name AS ProductName,
        p.price AS ProductPrice,c.Name_Custm AS CustomerName
        FROM Orders o
        JOIN Customer c ON o.Custm_ID = c.Custm_ID
        JOIN Products p ON p.Product_ID  = o.Product_ID 
        """;
            result = stmt.executeQuery(query);

            while (result.next()) {
                model.addRow(new Object[]{
                    result.getString("order_id"),
                    result.getString("CustomerName"),
                    result.getString("order_date"),
                    result.getString("status"),
                    result.getString("ProductName"),
                    result.getString("amount"),
                    Double.parseDouble(result.getString("ProductPrice")) * Integer.parseInt(result.getString("amount"))
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Orders Error " + e);
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
    
    public OrdersFrame() {
        initComponents();
        setLocation(900, 0);
        setTitle("Sales Management");
        model = new DefaultTableModel(
                new String[]{"Id", "Customer", "Date", "Status", "Product", "Quantity", "Price"}, 0
        );
        jTable1.setModel(model);
        loadCustomers();
        loadProducts();
        loadOrders();

    }

    private void clearFields() {
        customerSelect.setSelectedIndex(0);
        orderDate.setText("");
        statusSelect.setSelectedIndex(0);
        productSelect.setSelectedIndex(0);
        quantityInput.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        update = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        customerSelect = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        orderDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        statusSelect = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        productSelect = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        quantityInput = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer", "Date", "Status", "Product", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
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

        update.setText("Update");
        update.addActionListener(this::updateActionPerformed);
        jPanel3.add(update);

        jButton3.setText("Delete");
        jButton3.addActionListener(this::jButton3ActionPerformed);
        jPanel3.add(jButton3);

        jButton4.setText("Clear");
        jButton4.addActionListener(this::jButton4ActionPerformed);
        jPanel3.add(jButton4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel1.setLayout(new java.awt.GridLayout(4, 2, 0, 20));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel1.setText("Customer :");
        jPanel1.add(jLabel1);

        customerSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Hospital", "Pharmacy" }));
        jPanel1.add(customerSelect);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel2.setText(" Order Date : ");
        jPanel1.add(jLabel2);

        orderDate.addActionListener(this::orderDateActionPerformed);
        jPanel1.add(orderDate);

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel3.setText(" Status :");
        jPanel1.add(jLabel3);

        statusSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Delivered" }));
        jPanel1.add(statusSelect);

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel4.setText(" Product : ");
        jPanel1.add(jLabel4);

        productSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Hospital", "Pharmacy" }));
        jPanel1.add(productSelect);

        jLabel5.setText("Quantity :");
        jPanel5.add(jLabel5);

        quantityInput.setPreferredSize(new java.awt.Dimension(154, 24));
        quantityInput.addActionListener(this::quantityInputActionPerformed);
        jPanel5.add(quantityInput);

        add.setText("Add");
        add.addActionListener(this::addActionPerformed);
        jPanel5.add(add);

        Refresh.setText("Refresh");
        Refresh.setToolTipText("");
        Refresh.addActionListener(this::RefreshActionPerformed);
        jPanel5.add(Refresh);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        row = jTable1.getSelectedRow();
        if (row != -1) {
            customerSelect.setSelectedItem(model.getValueAt(row, 1).toString());
            orderDate.setText(model.getValueAt(row, 2).toString());
            statusSelect.setSelectedItem(model.getValueAt(row, 3).toString());
            productSelect.setSelectedItem(model.getValueAt(row, 4).toString());
            quantityInput.setText(model.getValueAt(row, 5).toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        customer = customerSelect.getSelectedItem().toString();
        date = orderDate.getText();
        status = statusSelect.getSelectedItem().toString();
        product = productSelect.getSelectedItem().toString();
        quantity = quantityInput.getText();

        if (customer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please , Enter your Customer Name ");
            return;
        }
        if (date.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please , Enter Date");
            return;
        }

        if (quantity.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please , Enter Quantity");
            return;
        }

        try {
            con = DBConnection.getConnection();
            String sql = "INSERT INTO Orders ( Custm_ID,order_date, status ,Product_ID , amount) VALUES (?, ?, ?, ?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, customer.split(" - ")[0]);
            ps.setString(2, date);
            ps.setString(3, status);
            ps.setString(4, product.split(" - ")[0]);
            ps.setString(5, quantity);
            ps.executeUpdate();

            stmt = con.createStatement();
            String query = "SELECT Amount from Products  ";
            result = stmt.executeQuery(query);
            if (result.next()){
            if (Integer.parseInt(result.getString("Amount")) < Integer.parseInt(quantity)) {
                JOptionPane.showMessageDialog(this, "Sorry ,Avaiable Amount is  : " + Integer.parseInt(result.getString("Amount")) );
                return;
            }
            
            int totalQuantity  = (Integer.parseInt(result.getString("Amount")) - Integer.parseInt(quantity)); 
            String sql2 = "UPDATE  Products SET Amount = '" + totalQuantity  + "' WHERE Product_ID = '" + product.split(" - ")[0] + "'";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this, "Inserted Successfully ✅");

            model.setRowCount(0);
            loadCustomers();
            loadProducts();
            loadOrders();
            clearFields();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error in Add : "+ e);
        }

    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        row = jTable1.getSelectedRow();
        customer = customerSelect.getSelectedItem().toString().split(" - ")[0];
        date = orderDate.getText();
        status = statusSelect.getSelectedItem().toString();
        product = productSelect.getSelectedItem().toString().split(" - ")[0];
        quantity = quantityInput.getText();
        id = Integer.parseInt(model.getValueAt(row, 0).toString());
        try {
            con = DBConnection.getConnection();
            String sql = "UPDATE Pharmace_Mangment.dbo.Orders SET Custm_ID= '" + customer + "', order_date= '" + date + "',status= '" + status + "', Product_ID= '" + product + "', amount= '" + quantity + "' WHERE order_id = '" + id + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Update Successfully ✅");

            model.setRowCount(0);
            loadCustomers();
            loadProducts();
            loadOrders();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_updateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        row = jTable1.getSelectedRow();
        id = Integer.parseInt(model.getValueAt(row, 0).toString());
        try {
            con = DBConnection.getConnection();
            String sql = "delete FROM Pharmace_Mangment.dbo.Orders where order_id   = '" + id + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Delete Successfully ✅");

            model.setRowCount(0);
            loadCustomers();
            loadProducts();
            loadOrders();
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            con = DBConnection.getConnection();
            String sql = "TRUNCATE table Orders ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Delete Successfully ✅");

            model.setRowCount(0);
            loadCustomers();
            loadProducts();
            loadOrders();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void orderDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderDateActionPerformed

    private void quantityInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityInputActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        model.setRowCount(0);
        loadCustomers();
        loadProducts();
        loadOrders();
        clearFields();
    }//GEN-LAST:event_RefreshActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new OrdersFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Refresh;
    private javax.swing.JButton add;
    private javax.swing.JComboBox<String> customerSelect;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField orderDate;
    private javax.swing.JComboBox<String> productSelect;
    private javax.swing.JTextField quantityInput;
    private javax.swing.JComboBox<String> statusSelect;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
