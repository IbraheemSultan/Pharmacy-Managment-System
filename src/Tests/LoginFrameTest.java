/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.pharmacy.managment.system;

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
public class LoginFrameTest {
    
    public LoginFrameTest() {
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
     * Test of main method, of class LoginFrame.
     */
   
    
    //Testing
    
    private boolean mockLoginCheck(String user, String pass) {
        return user.equals("admin") && pass.equals("123");
    }
    
    @Test
    public void testLoginSuccess() {
        System.out.println("Testing: Login with correct credentials...");
        
        String username = "admin";
        String password = "123";

        boolean loginResult = mockLoginCheck(username, password);

        assertTrue(loginResult, "User's data should be valid and exist!");
        System.out.println("Result: Login Successful ✅");
    }
    
    @Test
    public void testLoginFail() {
        System.out.println("Testing Login: Fail Case");
        boolean result = mockLoginCheck("admin", "wrong_pass");
        
        assertTrue(result, "The Password is incorrect!");
    }

    
}
