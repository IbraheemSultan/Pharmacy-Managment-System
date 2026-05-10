/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.pharmacy.managment.system;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class DBConnectionTest {
    
    public DBConnectionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getConnection method, of class DBConnection.
     */
    
    
    @Test
    public void testDatabaseConnectionSuccess() {
        System.out.println("Testing Database Connection: Success Case");
        try {
           
            Connection result = DBConnection.getConnection();
            
            assertNotNull(result, "The Connection is Faild!");
            
            if (result != null) result.close();
            
            System.out.println("Database is connected perfectly! ✅");
        } catch (SQLException e) {
           
            fail("Test faild: Couldn't connect with the databaseً! " + e.getMessage());
        }
    }
    
    
   @Test
    public void testDatabaseConnectionFail() {
        System.out.println("Testing Database Connection: Forced Failure Case");
        
        Connection result = null; 
       
        assertNotNull(result, "Faild: Database link is inactive: expected an open connectionً!");
    } 
}
