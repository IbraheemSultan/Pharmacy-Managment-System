package com.mycompany.pharmacy.managment.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ProductsFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ProductsFrame.class.getName());
    JTable table;
    DefaultTableModel model;
    int row, id;
    String name, price, data, quantity, supplier;
    Connection con = null;
    Statement stmt = null;
    ResultSet result = null;

    private void loadSuppliers() {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select Sup_ID ,Name from Suppliers";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            supplierSelect.removeAllItems(); // مهم

            while (rs.next()) {
                supplierSelect.addItem(
                        rs.getInt("Sup_ID") + " - " + rs.getString("Name")
                );
            }

        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "suppliers Error " + e);
        }
    }

    private void loadProducts() {
        try {
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            String query = """
        SELECT p.Product_ID, p.Name, p.price, p.Expiry_Date, p.Amount,
        s.Name AS SupplierName
        FROM Products p
        JOIN Suppliers s ON p.Sup_ID = s.Sup_ID
        """;
            result = stmt.executeQuery(query);

            while (result.next()) {
                model.addRow(new Object[]{
                    result.getString("Product_ID"),
                    result.getString("Name"),
                    result.getString("price"),
                    result.getString("Expiry_Date"),
                    result.getString("Amount"),
                    result.getString("SupplierName"),});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Products Error " + e);
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

    public ProductsFrame() {
        initComponents();
        setTitle("Products Management");
        setLocation(900, 500);
        model = new DefaultTableModel(
                new String[]{"Id", "Name", "Price", "Expiry", "Quantity", "Supplier"}, 0
        );
        jTable3.setModel(model);
        loadSuppliers();
        loadProducts();
    }

    private void clearFields() {
        nameInput.setText("");
        priceInput.setText("");
        dataInput.setText("");
        quantityInput.setText("");
        supplierSelect.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        add2 = new javax.swing.JButton();
        update2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        priceInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dataInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        quantityInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        supplierSelect = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Expiry", "Quantity", "Supplier"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable3.setToolTipText("");
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel7.setLayout(new java.awt.GridLayout(1, 4, 20, 0));

        add2.setText("Add");
        add2.addActionListener(this::add2ActionPerformed);
        jPanel7.add(add2);

        update2.setText("Update");
        update2.addActionListener(this::update2ActionPerformed);
        jPanel7.add(update2);

        jButton7.setText("Delete");
        jButton7.addActionListener(this::jButton7ActionPerformed);
        jPanel7.add(jButton7);

        Refresh.setText("Refresh");
        Refresh.setToolTipText("");
        Refresh.addActionListener(this::RefreshActionPerformed);
        jPanel7.add(Refresh);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel1.setLayout(new java.awt.GridLayout(5, 2, 0, 14));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel1.setText("Product Name :");
        jPanel1.add(jLabel1);

        nameInput.addActionListener(this::nameInputActionPerformed);
        jPanel1.add(nameInput);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel2.setText("Price :");
        jPanel1.add(jLabel2);
        jPanel1.add(priceInput);

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel3.setText("Expiry Data (YYYY-MM-DD) :");
        jPanel1.add(jLabel3);

        dataInput.addActionListener(this::dataInputActionPerformed);
        jPanel1.add(dataInput);

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel5.setText("Quantity :");
        jPanel1.add(jLabel5);

        quantityInput.addActionListener(this::quantityInputActionPerformed);
        jPanel1.add(quantityInput);

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel4.setText("Supplier : ");
        jPanel1.add(jLabel4);

        supplierSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Hospital", "Pharmacy" }));
        jPanel1.add(supplierSelect);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        row = jTable3.getSelectedRow();
        if (row != -1) {
            nameInput.setText(model.getValueAt(row, 1).toString());
            priceInput.setText(model.getValueAt(row, 2).toString());
            dataInput.setText(model.getValueAt(row, 3).toString());
            quantityInput.setText(model.getValueAt(row, 4).toString());
            supplierSelect.setSelectedItem(
                    model.getValueAt(row, 5).toString()
            );
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add2ActionPerformed
        name = nameInput.getText();
        price = priceInput.getText();
        data = dataInput.getText();
        quantity = quantityInput.getText();
        supplier = supplierSelect.getSelectedItem().toString();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please , Enter your Product Name ");
            return;
        }

        if (price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please , Enter Price");
            return;
        }

        if (data.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please , Enter Data");
            return;
        }

        if (quantity.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please , Enter Quantity");
            return;
        }

        try {
            con = DBConnection.getConnection();
            String sql = "INSERT INTO Products (Name, price,Expiry_Date, Amount,Sup_ID) VALUES (?, ?, ?, ?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, data);
            ps.setString(4, quantity);
            ps.setString(5, supplier.split(" - ")[0]);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Inserted Successfully ✅");

            model.setRowCount(0);
            loadProducts();

            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_add2ActionPerformed

    private void update2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update2ActionPerformed
        row = jTable3.getSelectedRow();
        name = nameInput.getText();
        price = priceInput.getText();
        data = dataInput.getText();
        quantity = quantityInput.getText();
        supplier = supplierSelect.getSelectedItem().toString().split(" - ")[0];
        id = Integer.parseInt(model.getValueAt(row, 0).toString());
        try {
            con = DBConnection.getConnection();
            String sql = "UPDATE Pharmace_Mangment.dbo.Products SET Name= '" + name + "', price= '" + price + "',Expiry_Date = '" + data + "', Amount = '" + quantity + "', Sup_ID = '" + supplier + "' WHERE Product_ID = '" + id + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Update Successfully ✅");

            model.setRowCount(0);
            loadProducts();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_update2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        row = jTable3.getSelectedRow();
        id = Integer.parseInt(model.getValueAt(row, 0).toString());
        try {
            con = DBConnection.getConnection();
            String sql = "delete FROM Pharmace_Mangment.dbo.Products where Product_ID = '" + id + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Delete Successfully ✅");

            model.setRowCount(0);
            loadProducts();

            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(  this, e.getMessage());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void nameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInputActionPerformed

    private void dataInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataInputActionPerformed

    private void quantityInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityInputActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        model.setRowCount(0);
        loadSuppliers();
        loadProducts();
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
        java.awt.EventQueue.invokeLater(() -> new ProductsFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Refresh;
    private javax.swing.JButton add2;
    private javax.swing.JTextField dataInput;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField nameInput;
    private javax.swing.JTextField priceInput;
    private javax.swing.JTextField quantityInput;
    private javax.swing.JComboBox<String> supplierSelect;
    private javax.swing.JButton update2;
    // End of variables declaration//GEN-END:variables
}
