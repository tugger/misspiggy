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

    RELY("Required software reliability", Rating.LOW     , Rating.VERY_HIGH),
    DATA("Database size"                , Rating.LOW     , Rating.VERY_HIGH),
    CPLX("Process complexity"           , Rating.LOW     , Rating.EXTRA_HIGH),
    TIME("Time constraint for cpu"      , Rating.NOMINAL , Rating.EXTRA_HIGH),
    STOR("Main memory constraint"       , Rating.NOMINAL , Rating.EXTRA_HIGH),
    VIRT("Machine volatility"           , Rating.LOW     , Rating.HIGH),
    TURN("Turnaround time"              , Rating.LOW     , Rating.HIGH),
    ACAP("Analysts capability"          , Rating.NOMINAL , Rating.VERY_HIGH),
    AEXP("Application experience"       , Rating.NOMINAL , Rating.VERY_HIGH),
    PCAP("Programmers capability"       , Rating.NOMINAL , Rating.VERY_HIGH),
    VEXP("Virtual machine experience"   , Rating.LOW     , Rating.HIGH),
    LEXP("Language experience"          , Rating.VERY_LOW, Rating.HIGH),
    MODP("Modern programing practices"  , Rating.LOW     , Rating.VERY_HIGH),
    TOOL("Use of software tools"        , Rating.VERY_LOW, Rating.VERY_HIGH),
    SCED("Schedule constraint"          , Rating.LOW     , Rating.HIGH);
    
    /**
     * The description of a particular attribute, human readable
     */
    private final String description;
    
    /**
     * The minimum rating for the particular attribute
     */
    private final Rating min;

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
    private Attribute(String description, Rating min, Rating max) {
        this.description = description;
        this.min = min;
        this.max = max;
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
