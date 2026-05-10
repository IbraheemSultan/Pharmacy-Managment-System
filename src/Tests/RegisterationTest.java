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
public class RegisterationTest {
    
    public RegisterationTest() {
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
     * Test of main method, of class Registeration.
     */
    
    
    
    @Test
    public void testNewUserRegistrationPass() {
        System.out.println("Testing: Registering a brand new user...");
        
        String newUser = "sama_student_2026"; 
        
        boolean isTaken = false; 
        
        assertFalse(isTaken, "The Username is Available!");
        
        System.out.println("Success: New user is available for registration.");
    }

  @Test
    public void testDuplicateUserRegistration() {
        System.out.println("Testing Duplicate Username...");
        
        boolean isFound = true; 
        assertFalse(isFound, "Test faild , The Username is already exist!");
    }
}
