/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp.algo;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Micke
 */
public class SimilarityCalculatorTest {
    
    public SimilarityCalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateSimilarity method, of class SimilarityCalculator.
     */
    @Test
    public void testCalculateSimilarity() {
        System.out.println("calculateSimilarity");
        
        Project firstProj = new Project();
        Project secondProj = new Project();
        SimilarityCalculator instance = new SimilarityCalculator();
        
        firstProj.attributes().put(Attribute.RELY, Rating.LOW);
        secondProj.attributes().put(Attribute.RELY, Rating.LOW);
        double expResult = 1.0;
        double result = instance.calculateSimilarity(firstProj, secondProj);
        assertEquals(expResult, result, 0.0);
        
        firstProj.attributes().clear();
        secondProj.attributes().clear();
        
        //Distance 1, similarity 0
        firstProj.attributes().put(Attribute.RELY, Rating.LOW);
        secondProj.attributes().put(Attribute.RELY, Rating.VERY_HIGH);
        expResult = 0.0;
        result = instance.calculateSimilarity(firstProj, secondProj);
        assertEquals(expResult, result, 0.0);
        
        firstProj.attributes().clear();
        secondProj.attributes().clear();
        
        //Distance 0.5, similarity 0.5 (one value exactly equal one value exactly not equal)
        firstProj.attributes().put(Attribute.RELY, Rating.LOW);
        secondProj.attributes().put(Attribute.RELY, Rating.VERY_HIGH);
        firstProj.attributes().put(Attribute.DATA, Rating.VERY_HIGH);
        secondProj.attributes().put(Attribute.DATA, Rating.VERY_HIGH);
        expResult = 0.5;
        result = instance.calculateSimilarity(firstProj, secondProj);
        assertEquals(expResult, result, 0.0);
        
        firstProj.attributes().clear();
        secondProj.attributes().clear();
        
        //one value exactly equal one value exactly not equal
        //One value 2 steps away out of 6
        firstProj.attributes().put(Attribute.RELY, Rating.LOW);
        secondProj.attributes().put(Attribute.RELY, Rating.VERY_HIGH);
        firstProj.attributes().put(Attribute.DATA, Rating.VERY_HIGH);
        secondProj.attributes().put(Attribute.DATA, Rating.VERY_HIGH);
        firstProj.attributes().put(Attribute.CPLX, Rating.LOW);
        secondProj.attributes().put(Attribute.CPLX, Rating.NOMINAL);
        
        
        expResult = 1.0 - (1.0 + 0.0 + Math.pow( 1.0/(4.0), 2))/3.0;
        result = instance.calculateSimilarity(firstProj, secondProj);
        assertEquals(expResult, result, 0.0);
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype. Projects need to be initialized with attributes before we can test similarity in a good way");
    }
}
