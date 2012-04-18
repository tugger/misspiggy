/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp.algo;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
/**
 *
 * @author marcus
 */
public class EstimationTest {
    
    public EstimationTest() {
    }

    /**
     * This method shall load the training set that will be used for accuracy
     * tests
     * @return populated project list of all trainging set data. 
     */
    private ProjectList loadTraingset() {
        Parser parser = new Parser("test/se/etsf01/aesp/algo/similarity_test_data");
        return parser.parseFile();
    }
    
    /**
     * Creates default estimators for use, the default should be the one used, 
     * could be changed over time
     * @return default estimator
     */
    private Estimator createDefaultEstimator()
    {
        ProjectList list = loadTraingset();
        
        EstimationFactory factory = new EstimationFactory(list);
        Estimator estim = factory.createEstimator();
        assertNotNull(estim);
        return estim;
    }
    
    @Test
    public void testEstimatorAccuracy()
    {
        double similarity = 0.7;
        ProjectList trainginset = loadTraingset();
        
        Estimator estim = createDefaultEstimator();
        
        ArrayList<EstimationResult> results = new ArrayList<EstimationResult>();
        
        //TODO: Might not be the fastest way to do it, but it is simple.
        ProjectList testList = new ProjectList();
        for(int i = 0; i < trainginset.size(); i++) {
            testList.addAll(trainginset);
            testList.remove(i);
            
            EstimationResult result = estim.estimate(similarity, trainginset.get(i));
            assertNotNull(result);
            results.add(result);
        }
        
        //check if >=80% of estimated results are within +/- 30% compared to
        //actual effort spent
        
        int numWithinTolerance = 0;
        
        for(int i = 0; i < results.size(); i++)
        {
            float ph = results.get(i).getEstimatedEffort().toPersonHours();
            float act_ph = trainginset.get(i).getActualEffort().toPersonHours();
            float relerror = (ph - act_ph) / act_ph;
            
            if(Math.abs(relerror) < 0.3)
                numWithinTolerance++;
            
            String pmEffort = String.valueOf(results.get(i).getEstimatedEffort().toPersonMonths());
            
            System.out.println("Estimated Project " + String.valueOf(i) + ": " + 
                    String.valueOf(Math.round(relerror*10000.0f) / 100.0f) + "% ( " + pmEffort + " pm)");
            
            System.out.println(trainginset.get(i));
        }
        
        System.out.println(String.valueOf(numWithinTolerance) + "/" + String.valueOf(results.size()) + " are within tolerance.");
        if(numWithinTolerance / (float)results.size() < 0.8f){
            float percent = Math.round((numWithinTolerance / (float)results.size()) * 1000.0f) / 10.0f;
            fail("Estimation not good enough! " + String.valueOf(percent) + "% are within tolerance");
        }
    }

    @Test
    public void testProject() 
    {
        Project proj = new Project();
        proj.setLinesOfCode(105);
        proj.setActualEffort(Effort.instantiatePersonHours(150.0f));
        proj.attributes().put(Attribute.RELY, Rating.NOMINAL);
        proj.attributes().put(Attribute.LEXP, Rating.VERY_HIGH);
        
        Project proj2 = new Project();
        proj2.setLinesOfCode(105);
        proj2.setActualEffort(Effort.instantiatePersonHours(150.0f));
        proj2.attributes().put(Attribute.RELY, Rating.NOMINAL);
        proj2.attributes().put(Attribute.LEXP, Rating.VERY_HIGH);
        
        assertEquals(proj, proj2);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        
    }
}
