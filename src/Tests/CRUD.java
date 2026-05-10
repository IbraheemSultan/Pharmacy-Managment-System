/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacy.managment.system;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CRUD {

    private static Connection con;

    @BeforeAll
    public static void setup() {
        try {
           
            con = DBConnection.getConnection();
        } catch (SQLException e) {
            System.err.println("Connection Failed: " + e.getMessage());
        }
    }

    @Test
    @Order(1)
    @DisplayName("Test: Create Supplier")
    public void testCreate() throws SQLException {
        assertNotNull(con, "Database connection is null! Check your DB settings.");
        String sql = "INSERT INTO Suppliers (Name, Address, Phone) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "Test Supplier");
            ps.setString(2, "Cairo");
            ps.setString(3, "0123");
            int result = ps.executeUpdate();
            assertEquals(1, result);
        }
    }

    @Test
    @Order(2)
    @DisplayName("Test: Read Supplier")
    public void testRead() throws SQLException {
        String sql = "SELECT * FROM Suppliers WHERE Name = 'Test Supplier'";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            assertTrue(rs.next());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Test: Update Supplier")
    public void testUpdate() throws SQLException {
        String sql = "UPDATE Suppliers SET Address = 'Giza' WHERE Name = 'Test Supplier'";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            int result = ps.executeUpdate();
            assertTrue(result >= 0);
        }
    }

    @Test
    @Order(4)
    @DisplayName("Test: Delete Supplier")
    public void testDelete() throws SQLException {
        String sql = "DELETE FROM Suppliers WHERE Name = 'Test Supplier'";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            int result = ps.executeUpdate();
            assertTrue(result >= 0);
        }
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}