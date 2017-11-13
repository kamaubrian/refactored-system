/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Esperant
 */
public class LoginModelTest {
    
    
    public LoginModelTest() {
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
    public void tearDown() throws SQLException {
      
    }

    /**
     * Test of getAdmin method, of class LoginModel.
     */
    @Test
    public void testGetAdmin() {
        System.out.println("getAdmin");
        String user = "Admin";
        LoginModel instance = new LoginModel();
        ArrayList<String> expResult = new ArrayList();
        expResult.add("admin");
        expResult.add("wamatu");
        ArrayList<String> result = instance.getAdmin(user);
        assertEquals(expResult,result);

    }

    /**
     * Test of getUsername method, of class LoginModel.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        String user = "Admin";
        String table = "customer";
        LoginModel instance = new LoginModel();
        String expResult = "Admin";
        String result = instance.getUsername(table,user);
        assertEquals(expResult, result);

    }

    /**
     * Test of getPassword method, of class LoginModel.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String pass = "wamatu";
        String table = "customer";
        LoginModel instance = new LoginModel();
        String expResult = "wamatu";
        String result = instance.getPassword(table,pass);
        assertEquals(expResult, result);
    }
    
}
