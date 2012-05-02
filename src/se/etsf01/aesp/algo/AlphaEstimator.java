package se.etsf01.aesp.algo;

import java.util.*;

/**
 * The first estimator for iteration 1
 */
public class AlphaEstimator implements Estimator 
{
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
     * Adapt the selected projects
     * @param interm the intermediate instance
     * @return the estimated result
     */
    private EstimationResult adaptation(Intermediate interm) {
        if(interm == null)
            return new EstimationResult();
        else if(interm.selectedProjects.size() == 0)
            return new EstimationResult();
        
        //Using weighted adaptation
        double effort = 0.0;
        double size = interm.proj.getLinesOfCode();
        double sumSimilarity = 0.0;
        
        //Compute sum of similarity values
        for(double value : interm.similarity)
        {
            sumSimilarity += value * value;
        }
        
        for(int i = 0; i < interm.selectedProjects.size(); i++)
        {
            //TODO: Check if performance is good enough.
            Project cProj = interm.selectedProjects.get(i);
            double cSim = interm.similarity.get(i); //similarity
            cProj.setSimilarity(cSim);
            double cEffort = cProj.getActualEffort().toPersonHours();
            double cSize = cProj.getLinesOfCode();
            
            effort += (size / cSize) * cEffort * (Math.pow(cSim,2) / sumSimilarity);
        }
        
       
        ProjectList similarProjects = interm.selectedProjects;
        Comparator c = Collections.reverseOrder();
        Collections.sort(similarProjects,c);
        EstimationResult result = new EstimationResult(Effort.instantiatePersonHours((float)effort), similarProjects);
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
        
        TreeMap<Double,Project> similarities = new TreeMap<Double, Project>();
        
        for(Project cProj : projectlist)
        {
            //calculate similarity between the two
            double similarity = similarityCalculator.calculateSimilarity(proj, cProj);
            similarities.put(similarity, cProj);
        }
        
        Iterator<Map.Entry<Double,Project>> iter = similarities.descendingMap().entrySet().iterator();
        if(iter.hasNext()) {
            while(iter.hasNext() && interm.selectedProjects.size() < 15) {
                Map.Entry<Double,Project> entry = iter.next();
                if(entry.getKey() < similarityThreshold)
                    break;
                
                interm.selectedProjects.add(entry.getValue());
                interm.similarity.add(entry.getKey());
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
    
    public AlphaEstimator(ProjectList list) {
        this.projectlist = list;
        this.similarityCalculator = new SimilarityCalculator();
    }
}
