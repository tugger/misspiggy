/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp.algo;

//TODO: Remove from production code once one exists that actually does something useful.
/**
 * Dummy estimator
 */
public class NullEstimator implements Estimator {

    @Override
    public EstimationResult estimate(double similarity, Project proj) {
        return new EstimationResult();
    }
    
}
