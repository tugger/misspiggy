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
    private static class Intermediate
    {
        private ProjectList selectedProjects;
        private ArrayList<Double> similarity;
        private Project proj;
        
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
        if(interm == null)
            return new EstimationResult();
        
        //Using weighted adaptation
        double effort = 0.0;
        double size = interm.proj.getLinesOfCode();
        double sumSimilarity = 0.0;
        
        //Compute sum of similarity values
        for(double value : interm.similarity)
        {
            sumSimilarity += value;
        }
        
        for(int i = 0; i < interm.selectedProjects.size(); i++)
        {
            //TODO: Check if performance is good enough.
            Project cProj = interm.selectedProjects.get(i);
            double cSim = interm.similarity.get(i); //similarity
            double cEffort = cProj.getActualEffort().toPersonHours();
            double cSize = cProj.getLinesOfCode();
            
            effort += (size * cSim * cEffort) / (cSize * sumSimilarity);
        }
        
        EstimationResult result = new EstimationResult(Effort.instantiatePersonHours((float)effort), interm.selectedProjects);
        return result;
    }
    
    /**
     * Computes similarity for all projects and selects the ones that are above the limit
     * @param similarityThreshold the similarity threshold
     * @param proj the project to match against
     * @return intermediate data structure containing the list of selected projects and their similarity scores
     */
    private Intermediate getSimilarProjects(double similarityThreshold, Project proj) {
        Intermediate interm = new Intermediate();
        interm.proj = proj;
        for(Project cProj : projectlist)
        {
            //calculate similarity between the two
            double similarity = calculateSimilarity(proj, cProj);
            //If similarity is larger then threshold add to the collection
            if(similarity >= similarityThreshold){
                interm.selectedProjects.add(cProj);
                interm.similarity.add(similarity);
            }
        }
        return interm;
    }
    
    /**
     * Computes similarity between two projects
     * @param proj1 
     * @param proj2
     * @return calculated simliarity as double
     */
    private double calculateSimilarity(Project proj1, Project proj2){
        return 0.5d;
    }
    
    
    /**
     * Estimates the effort based on similarity for a new project
     * @param similarity the similarity factor
     * @param proj the new project to estimate effort for
     * @return estimation result, should never be null even if it failed.
     */
    @Override
    public EstimationResult estimate(double similarity, Project proj) {
        return adaptation(getSimilarProjects(similarity, proj));
    }
    
    public AlphaEstimator(ProjectList list) {
        this.projectlist = list;
    }
}
