/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp.algo;

/**
 * Represents the estimators as functions, used to compute estimates
 */
public interface Estimator
{
    /**
     * Estimates the effort based on similarity for a new project
     * @param similarity the similarity factor
     * @param proj the new project to estimate effort for
     * @return estimation result, should never be null even if it failed.
     */
    public EstimationResult estimate(double similarity, Project proj);
}
