/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp.algo;

/**
 * Contains the estimation result from the algorithm
 */
public class EstimationResult
{
    /**
     * The estimated effort
     */
    private Effort estimatedEffort;
    
    /**
     * The adapation source, the similiar projects
     */
    private ProjectList adaptiationSource;

    /**
     * Get the adaption source i.e. the similar projects used to compute estimated effort
     * @return adaption source as a project list, null if adaptation failed
     */
    public ProjectList getAdaptiationSource() {
        return adaptiationSource;
    }

    /**
     * Return the estimated effort
     * @return estimated effort
     */
    public Effort getEstimatedEffort() {
        return estimatedEffort;
    }
    
    /**
     * Check if the estimation succeeded or not
     * @return true if did
     */
    public boolean succeeded() {
        return estimatedEffort != null && adaptiationSource != null;
    }
    
    /**
     * Construct the estimation result
     * @param estimatedEffort the estimated effort
     * @param adapationSource the similiar projects used to adapt the effort
     */
    public EstimationResult(Effort estimatedEffort, ProjectList adapationSource) {
        this.estimatedEffort = estimatedEffort;
        this.adaptiationSource = adapationSource;
    }
    
    public EstimationResult() {
        this.estimatedEffort = null;
        this.adaptiationSource = null;
    }
}
