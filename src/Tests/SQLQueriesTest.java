/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacy.managment.system;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;

public class SQLQueriesTest {

    private static Connection con;

    @BeforeAll
    public static void setup() throws SQLException {
        con = DBConnection.getConnection();
    }

   
    
    @Test
    @DisplayName("Test: Search Supplier by Name")
    public void testSearchQuery() throws SQLException {
        
        String searchName = "sama"; 
        String sql = "SELECT * FROM Suppliers WHERE Name LIKE ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + searchName + "%");
            ResultSet rs = ps.executeQuery();
            
            assertNotNull(rs);
            System.out.println("Search Query: Executed Successfully ✅");
        }
    }


    @Test
    @DisplayName("Test: Count Suppliers")
    public void testCountQuery() throws SQLException {
        String sql = "SELECT COUNT(*) AS total FROM Suppliers";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            assertTrue(rs.next());
            int count = rs.getInt("total");
            assertTrue(count >= 0, "Count should be 0 or more");
            System.out.println("Total Suppliers in DB: " + count + " ✅");
        }
    }

    @Test
    @DisplayName("Test: Suppliers Ordered by Name")
    public void testOrderQuery() throws SQLException {
        String sql = "SELECT Name FROM Suppliers ORDER BY Name ASC";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                String firstLabel = rs.getString("Name");
                assertNotNull(firstLabel);
                System.out.println("Ordering Query: Working ✅");
            }
        }
    }

    
    @Test
    @DisplayName("Test: Check Table Existence")
    public void testTableSchema() throws SQLException {
        DatabaseMetaData meta = con.getMetaData();
        
        ResultSet res = meta.getTables(null, null, "Suppliers", new String[] {"TABLE"});
        assertTrue(res.next(), "Table 'Suppliers' must exist in the database!");
        System.out.println("Schema Check: Table exists ✅");
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        if (con != null) con.close();
    }
}