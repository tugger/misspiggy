/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp.algo;

import java.util.*;

/**
 *
 * @author marcus
 */
public class BetaEstimator implements Estimator {
        private ProjectList projectlist;
    private SimilarityCalculator similarityCalculator;
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
     * Compute the EAF factor
     * @param proj the project
     * @return eaf factor
     */
    private double eaf(Project proj)
    {
        double eaf = 1.0;
        Iterator<Map.Entry<Attribute, Rating>> iter = proj.attributes().entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<Attribute,Rating> entry = iter.next();
            eaf *= entry.getKey().getWeight(entry.getValue());
        }
        
        return eaf;
    }
    
    /**
     * Adapt the selected projects
     * @param interm the intermediate instance
     * @return the estimated result
     */
    private EstimationResult adaptation(Intermediate interm) {
        if(interm == null)
            return new EstimationResult();
        else if(interm.selectedProjects.size() == 0)
            return new EstimationResult();
        
        //1. Find most optimal a and b
        //1.a calcuate EAF factors
        double eafFactors[] = new double[interm.selectedProjects.size()];
        int i = 0;
        for(Project proj : interm.selectedProjects) {
            eafFactors[i] = eaf(proj);
            i++;
        }
        
        double bestA[] = new double[interm.selectedProjects.size()];
        double bestB[] = new double[interm.selectedProjects.size()];
        double lastError[] = new double[interm.selectedProjects.size()];
        
        //1.b all errors are infinite from the start so the first will be used.
        for(i = 0; i < lastError.length; i++)
            lastError[i] = Double.POSITIVE_INFINITY;
        
        i = 0;
        for(Project proj : interm.selectedProjects) {
            double act = proj.getActualEffort().toPersonMonths();
            for(double a = 2.6; a <= 3.2; a += 0.1) {
                
                for(double b = 1.0; b <= 1.3; b += 0.05) {
                    
                    double est = a*Math.pow(proj.getLinesOfCode()/1000.0,b)*eafFactors[i];
                    double e = (est - act) / act;
                    
                    if(Math.abs(e) < Math.abs(lastError[i]))
                    {
                        bestA[i] = a;
                        bestB[i] = b;
                        lastError[i] = e;
                    }
                }
            }
            i++;
        }
        
        double sumSimilarity = 0.0;
        double sumError = 0.0;
        
        //Compute sum of similarity values
        for(double value : interm.similarity)
        {
            sumSimilarity += value;
        }
        
        for(i = 0; i < lastError.length; i++) {
            sumError += lastError[i];
        }
        
        double a = 0.0;
        double b = 0.0;

        //Compute a and b based on similarity weighting.
        for(i = 0; i < interm.selectedProjects.size(); i++)
        {
            a += bestA[i] * (interm.similarity.get(i) / sumSimilarity);
            b += bestB[i] * (interm.similarity.get(i) / sumSimilarity);
        }
        
        double effort = a * Math.pow(interm.proj.getLinesOfCode() / 1000.0, b) * eaf(interm.proj);
       
        ProjectList similarProjects = interm.selectedProjects;
        Comparator c = Collections.reverseOrder();
        Collections.sort(similarProjects,c);
        EstimationResult result = new EstimationResult(Effort.instantiatePersonMonths((float)effort), similarProjects);
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
            double similarity = similarityCalculator.calculateSimilarity(proj, cProj);
            //If similarity is larger then threshold add to the collection
            if(similarity >= similarityThreshold){
                interm.selectedProjects.add(cProj);
                interm.similarity.add(similarity);
            }
        }
        return interm;
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
    
    public BetaEstimator(ProjectList list) {
        this.projectlist = list;
        this.similarityCalculator = new SimilarityCalculator();
    }
}
