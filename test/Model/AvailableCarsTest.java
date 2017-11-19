/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class AvailableCarsTest {
    
    public AvailableCarsTest() {
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
     * Test of getFilePath method, of class AvailableCars.
     */
    @Test
    public void testGetFilePath() {
        System.out.println("Testing Getting FilePath");
        int id = 1;
        AvailableCars instance = new AvailableCars();
        ArrayList<String> expResult = new ArrayList();
        expResult.add("Resources/availableCars/bmw.jpg");
        ArrayList<String> result = instance.getFilePath(id);
        assertEquals(expResult, result);

    }
    @Test
    public void testGetAvailableCars(){
        System.out.println("Finding whether a car is available");
        String model = "X5";
        String make="BMW";
        AvailableCars instance = new AvailableCars();
       // instance.getCarExists(model, make);
        boolean expectedResult = true;
        boolean result = instance.findCarExists(model, make);
        
    }
    
}
