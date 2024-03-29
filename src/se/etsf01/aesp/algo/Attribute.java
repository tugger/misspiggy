package se.etsf01.aesp.algo;

/**
 * The project attribute, project charachteristics
 */
public enum Attribute
{
    
    /* Data specification of the attributes:
    
       @attribute RELY {Nominal,Very_High,High,Low} %1
       @attribute DATA {High,Low,Nominal,Very_High} %2 
       @attribute CPLX {Very_High,High,Nominal,Extra_High,Low} %3
       @attribute TIME {Nominal,Very_High,High,Extra_High} %4
       @attribute STOR {Nominal,Very_High,High,Extra_High} %5
       @attribute VIRT {Low,Nominal,High} %6
       @attribute TURN {Nominal,High,Low} %7
       @attribute ACAP {High,Very_High,Nominal} %8
       @attribute AEXP {Nominal,Very_High,High} %9
       @attribute PCAP {Very_High,High,Nominal} %10
       @attribute VEXP {Low,Nominal,High} %11
       @attribute LEXP {Nominal,High,Very_Low,Low} %12
       @attribute MODP {High,Nominal,Very_High,Low} %13
       @attribute TOOL {Nominal,High,Very_High,Very_Low,Low} %14
       @attribute SCED {Low,Nominal,High} %15
       @attribute LOC numeric %16
       @attribute ACT_EFFORT numeric %17

     * The effort multipliers description, that is the description of e.g RELY
     * was found in the source.
     *
     * Source:
     * http://promise.site.uottawa.ca/SERepository/datasets/cocomonasa.arff
     */

    RELY("Required software reliability", Rating.VERY_LOW, Rating.VERY_HIGH, new double[] { 0.75, 0.88, 1.00, 1.15, 1.40}),
    DATA("Database size"                , Rating.LOW     , Rating.VERY_HIGH, new double[] {0.94, 1.00, 1.08, 1.16} ),
    CPLX("Process complexity"           , Rating.VERY_LOW, Rating.EXTRA_HIGH, new double[] {0.70, 0.85, 1.00, 1.15, 1.30, 1.65}),
    TIME("Time constraint for cpu"      , Rating.NOMINAL , Rating.EXTRA_HIGH, new double[] {1.00, 1.11, 1.30, 1.66}),
    STOR("Main memory constraint"       , Rating.NOMINAL , Rating.EXTRA_HIGH, new double[] {1.00, 1.06, 1.21, 1.56}),
    VIRT("Machine volatility"           , Rating.LOW     , Rating.VERY_HIGH, new double[] {0.87, 1.00, 1.15, 1.30} ),
    TURN("Turnaround time"              , Rating.LOW , Rating.VERY_HIGH, new double[] {0.87, 1.00, 1.07, 1.15}),
    ACAP("Analysts capability"          , Rating.VERY_LOW, Rating.VERY_HIGH, new double[] {1.46, 1.19, 1.00, 0.86, 0.71}),
    AEXP("Application experience"       , Rating.VERY_LOW, Rating.VERY_HIGH, new double[] {1.29, 1.13, 1.00, 0.91, 0.82}),
    PCAP("Programmers capability"       , Rating.VERY_LOW, Rating.VERY_HIGH, new double[] {1.42, 1.17, 1.00, 0.86, 0.70}),
    VEXP("Virtual machine experience"   , Rating.VERY_LOW, Rating.HIGH, new double[] {1.21, 1.10, 1.00, 0.90}),
    LEXP("Language experience"          , Rating.VERY_LOW, Rating.HIGH, new double[] {1.14, 1.07, 1.00, 0.95}),
    MODP("Modern programing practices"  , Rating.VERY_LOW, Rating.VERY_HIGH, new double[] {1.24, 1.10, 1.00, 0.91, 0.82}),
    TOOL("Use of software tools"        , Rating.VERY_LOW, Rating.VERY_HIGH, new double[] {1.24, 1.10, 1.00, 0.91, 0.83}),
    SCED("Schedule constraint"          , Rating.VERY_LOW, Rating.HIGH, new double[] {1.23, 1.08, 1.00, 1.04, 1.10});
    
    /**
     * The description of a particular attribute, human readable
     */
    private final String description;
    
    /**
     * The minimum rating for the particular attribute
     */
    private final Rating min;
    
    /**
     * Weights for the EAF calculation
     */
    private double[] weights;
    
    /**
     * The maximum rating allowed for this multiplier
     * @return a rating of the maximum
     */
    public Rating getMax() {
        return max;
    }

    /**
     * The minimum rating allowed for this multiplier
     * @return a rating of the minimum
     */
    public Rating getMin() {
        return min;
    }
    
    private double minWeight;

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getMinWeight() {
        return minWeight;
    }
    private double maxWeight;
    
    /**
     * Get EAF Weight
     * @param rating The current rating
     * @return a factor that gives the weight for this characteristic
     */
    public double getWeight(Rating rating) {
        int index = rating.ordinal() - this.min.ordinal();
        if(index < 0)
            throw new RuntimeException("Invalid Rating accepted!");
        
        return weights[index];
    }
   
    private double[] getMinMaxWeight() {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        
        for(int i = 0; i < weights.length; i++) {
            if(weights[i] < min)
                min = weights[i];
             
            if(weights[i] > max)
                max = weights[i];
        }
        
        return new double[] {min, max};
    }
    /**
     * The maximum rating for a particular attribute
     */
    private final Rating max;

    /**
     * Get the description of an attribute in human readable form
     * @return 
     */
    public String getDescription() {
        return description;
    }

    /**
     * The constructor for the num
     * @param description 
     */
    private Attribute(String description, Rating min, Rating max, double[] weights) {
        this.description = description;
        this.min = min;
        this.max = max;
        this.weights = weights;
        double[] minmax = getMinMaxWeight();
        this.minWeight = minmax[0];
        this.maxWeight = minmax[1];
    }
    
    /**
     * Helper method to fast get an attribute from an index
     * @param index the index
     * @return attribute or null if invalid index
     */
    public static Attribute fromIndex(int index)
    {
        Attribute[] attributes = Attribute.values();
        if(index >= attributes.length || index < 0)
            return null;
        else
            return attributes[index];
    }
    
    /**
     * Get the normalized rating, that is the value between 0 and 1 for the 
     * given rating
     * @param rating The specific project rating
     * @return a value between 0 and 1 (inclusive), the range is clamped
     */
    public double getNormalizedRating(Rating rating)
    {
        //TODO: Add support for discrete values where rating=0 if not the same and rating=1 if it is
        int length = (this.max.ordinal() - this.min.ordinal());
        int clamped = Math.min(Math.max(min.ordinal(),rating.ordinal()),max.ordinal());
        
        return (clamped - min.ordinal()) / (double)length;
    }
    
    /**
     * Helper method to get the number of attributes defined
     * @return the number of defined enums
     */
    public static int length()
    {
        return Attribute.values().length;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
