/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp.algo;

/**
 * The factory of estimators
 */
public class EstimationFactory
{
    /**
     * The training set to use for all new estimators
     */
    private ProjectList list;
    
    /**
     * Construct the EstimationFactory
     * @param list The training set to use
     */
    public EstimationFactory(ProjectList list)
    {
        this.list = list;
    }
    
    /**
     * Create a new estimator, equivalent to calling createEstimator("default")
     * @return estimator instance
     */
    public Estimator createEstimator()
    {
        return createEstimator("beta");
    }
    
    /**
     * Construct a specific estimator
     * @param name the specific estimator implementation to instanciate
     * @return estimator instance, null if it is invalid
     */
    public Estimator createEstimator(String name)
    {
        if(name.equals("default"))
            return createNullEstimator();
        else if(name.equals("alpha"))
            return createAlphaEstimator();
        else if(name.equals("beta"))
            return createBetaEstimator();
        else
            return null;
    }
    
    private Estimator createNullEstimator() {
        return new NullEstimator();
    }
    
    private Estimator createAlphaEstimator() {
        return new AlphaEstimator(list);
    }
    
    private Estimator createBetaEstimator() {
        return new BetaEstimator(list);
    }
    /**
     * Get the list of all estimators available
     * @return list of available esimators
     */
    public String[] getIdentifiers() {
        return new String[] {"default", "alpha", "beta"};
    }
}
