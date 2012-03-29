package se.etsf01.aesp.algo;

import java.util.*;

/**
 * The first estimator for iteration 1
 */
public class AlphaEstimator implements Estimator 
{
    private ProjectList projectlist;
    
    /**
     * Inner data structure to handle intermediate results
     */
    private static class Intermediate {
        private ProjectList selectedProjects;
        private ArrayList<Double> similarity;
        
        public Intermediate()
        {
            this.selectedProjects = new ProjectList();
            this.similarity = new ArrayList<Double>();
        }
    }
    
    /**
     * Adapt the selected projects
     * @param interm the intermediate instance
     * @return the estimated result
     */
    private EstimationResult adaptation(Intermediate interm) {
        return new EstimationResult();
    }
    
    /**
     * Computes similarity for all projects and selects the ones that are above the limit
     * @param similarity the similarity threshold
     * @param proj the project to match against
     * @return intermediate data structure containing the list of selected projects and their similarity scores
     */
    private Intermediate similarity(double similarity, Project proj) {
        return new Intermediate();
    }
    
    /**
     * Estimates the effort based on similarity for a new project
     * @param similarity the similarity factor
     * @param proj the new project to estimate effort for
     * @return estimation result, should never be null even if it failed.
     */
    @Override
    public EstimationResult estimate(double similarity, Project proj) {
        return adaptation(similarity(similarity, proj));
    }
}
