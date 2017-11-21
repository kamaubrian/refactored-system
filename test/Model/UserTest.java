/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author brian-kamau
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addUser method, of class User.
     */
    @Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        String passport = "";
        String firstname = "";
        String lastname = "";
        String username = "";
        String phone = "";
        String password = "";
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.addUser(passport, firstname, lastname, username, phone, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lookUpUsername method, of class User.
     */
    @Test
    public void testLookUpUsername() throws Exception {
        System.out.println("lookUpUsername");
        String username = "";
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.lookUpUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequestDetails method, of class User.
     */
    @Test
    public void testGetRequestDetails() throws Exception {
        System.out.println("getRequestDetails");
        String username = "";
        User instance = new User();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getRequestDetails(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubscriptionDetails method, of class User.
     */
    @Test
    public void testGetSubscriptionDetails() throws Exception {
        System.out.println("getSubscriptionDetails");
        String username = "wambu";
        User instance = new User();
        List<Object> expResult = new ArrayList();
        expResult.add(1);
        List<Object> result = instance.getSubscriptionDetails(username);
        assertEquals(expResult, result);
  
    }
    
}
