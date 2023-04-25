/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Model.Customer;
import Model.Income;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class UtilityTest {

    public UtilityTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

  

    @Test
    public void testCheckOnlyDigitCharacter() {
        System.out.println("checkOnlyDigitCharacter");
        String s = "";
        Utility instance = new Utility();
        boolean expResult = false;
        boolean result = instance.checkOnlyDigitCharacter(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOnlyDigitCharacter2() {
        System.out.println("checkOnlyDigitCharacter");
        String s = "saas@&_sc";
        Utility instance = new Utility();
        boolean expResult = false;
        boolean result = instance.checkOnlyDigitCharacter(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckOnlyDigitCharacter3() {
        System.out.println("checkOnlyDigitCharacter");
        String s = "ab25ssa";
        Utility instance = new Utility();
        boolean expResult = false;
        boolean result = instance.checkOnlyDigitCharacter(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckOnlyDigitCharacter4() {
        System.out.println("checkOnlyDigitCharacter");
        String s = "123456789"; // true
        Utility instance = new Utility();
        boolean expResult = true;
        boolean result = instance.checkOnlyDigitCharacter(s);
        assertEquals(expResult, result);
    }
}
