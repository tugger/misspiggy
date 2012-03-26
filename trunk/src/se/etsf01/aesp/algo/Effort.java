/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp.algo;

/**
 * Represents effort
 * @author marcus
 */
public class Effort {
    private float time_hour;
    
    private Effort(float time_hour) {
        this.time_hour = time_hour;
    }
    
    /**
     * Create an effort from person hours
     * @param ph The number of person hours
     * @return instance of an new effort with the the person hours set
     */
    public static Effort instantiatePersonHours(float ph)
    {
        return new Effort(ph);
    }
    
    /**
     * Get the person hour effort
     * @return person hour effort
     */
    public float toPersonHours() {
        return time_hour;
    }
    
    /**
     * Get the person day effort
     * @return the number of person day effort
     */
    public float toPersonDays() {
        return time_hour / 8.0f; //Standard work day as defined by COCOMO
    }
   
    /**
     * Get the person month effort
     * Reference 1: http://www.softstarsystems.com/faq.htm#What's the definition of a "Staff-Month"
     * Reference 2: http://www.mysecretroom.com/www/programming-and-software/estimating-software-development-cost
     * @return the number of person months of effort
     */
    public float toPersonMonths() {
        return time_hour / 152.0f;
    }
    
    /**
     * Get the person year effort
     * @return the number of person year effort
     */
    public float toPersonYear() {
        return time_hour / 1824.0f; //152 * 12
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;
        else if(o == this)
            return true;
        else if(o instanceof Effort)
        {
            Effort e = (Effort)o;
            
            //Comparing floating point numbers requires care!
            float epsilon = 1e-5f;
            return e.time_hour >= this.time_hour - epsilon && e.time_hour <= this.time_hour + epsilon;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "Effort: " + String.valueOf(time_hour) + " ph";
    }
}
