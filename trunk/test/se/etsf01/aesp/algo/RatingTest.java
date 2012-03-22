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
public class RatingTest {
    
    public RatingTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of fromString method, of class Rating.
     */
    @Test
    public void testFromString()
    {
        assertEquals(Rating.VERY_LOW, Rating.fromString("Very_Low"));
        assertEquals(Rating.LOW, Rating.fromString("Low"));
        assertEquals(Rating.NOMINAL, Rating.fromString("Nominal"));
        assertEquals(Rating.HIGH, Rating.fromString("High"));
        assertEquals(Rating.VERY_HIGH, Rating.fromString("Very_High"));
        assertEquals(Rating.EXTRA_HIGH, Rating.fromString("Extra_High"));
    }
}
