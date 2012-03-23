/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp.algo;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author marcus
 */
public class EffortTest {
    
    public EffortTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of instansiatePersonHours method, of class Effort.
     */
    @Test
    public void testInstansiatePersonHours() {
        System.out.println("instansiatePersonHours");
        
        float ph = 12.000003f;
        
        Effort expResult = Effort.instansiatePersonHours(12.0f);
        Effort result = Effort.instansiatePersonHours(ph);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of toPersonHours method, of class Effort.
     */
    @Test
    public void testToPersonHours() {
        System.out.println("toPersonHours");
        Effort instance = Effort.instansiatePersonHours(120.0f);
        float expResult = 120.0f;
        float result = instance.toPersonHours();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toPersonDays method, of class Effort.
     */
    @Test
    public void testToPersonDays() {
        System.out.println("toPersonDays");
        Effort instance = Effort.instansiatePersonHours(120.0f);
        float expResult = 15.0f;
        float result = instance.toPersonDays();
        assertEquals(expResult, result, 1e-5f);
    }

    /**
     * Test of toPersonMonths method, of class Effort.
     */
    @Test
    public void testToPersonMonths() {
        System.out.println("toPersonMonths");
        Effort instance = Effort.instansiatePersonHours(152.0f);
        float expResult = 1.0F;
        float result = instance.toPersonMonths();
        assertEquals(expResult, result, 1e-5f);
    }

    /**
     * Test of toPersonYear method, of class Effort.
     */
    @Test
    public void testToPersonYear() {
        System.out.println("toPersonYear");
        Effort instance = Effort.instansiatePersonHours(12.0f*152.0f);
        float expResult = 1.0F;
        float result = instance.toPersonYear();
        assertEquals(expResult, result, 1e-5f);
    }
}
