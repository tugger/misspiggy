/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp.algo;

import java.util.Map;

/**
 *This class is responsible for supplying the estimator with calculated values
 * of similarity. It depends on the normalized ratings in the attributes class
 * @author Micke
 */
public class SimilarityCalculator {
    
    
     /**
     * Computes similarity between two projects. This depends on ratings being normalized.
     * @param proj1 
     * @param proj2
     * @return calculated simliarity as double
     */
    public double calculateSimilarity(Project proj1, Project proj2){
        double distance = 0;
        Attribute[] attributes = proj1.attributes().keySet().toArray(new Attribute[0]);
        Map<Attribute,Rating> firstProjAttributes = proj1.attributes();
        Map<Attribute,Rating> secondProjAttributes = proj2.attributes();
        
        //Loop through all attributes and add their distances
        for (Attribute attribute : attributes) {
            //Calculate absolute distance between two values
            double valueDistance = Math.abs( attribute.getNormalizedRating( firstProjAttributes.get(attribute) ) - attribute.getNormalizedRating( secondProjAttributes.get(attribute) ) );            
            //Square value for sum
            distance += Math.pow(valueDistance, 2);
        }
        //Divide by number of values if there are more than 0 otherwise divide by 1
        distance /= (attributes.length == 0 ? 1 : attributes.length) ;
        
        //As distance is now a value between 0..1 the similarity is 1 - distance
        return 1 - distance;
    }
}
