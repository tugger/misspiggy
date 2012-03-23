package se.etsf01.aesp.algo;

import java.util.*;

/**
 * Represents a single project
 */
public class Project
{

    private HashMap<Attribute,Rating> attributes;
    
    /**
     * The attributes of the project
     */
    public Map<Attribute,Rating> attributes()
    {
        return attributes;
    }
    
    private String identifier;
    private int linesOfCode;
    private Effort actualEffort;
    
    /**
     * Get the project identifier
     * @return a string of the project identifier/name
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Set the project identifier
     * @param identifier the project identifier/name
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    /**
     * The actual effort in seconds
     */
    public Effort getActualEffort() {
        return actualEffort;
    }

    /**
     * The number of lines of code
     */
    public int getLinesOfCode() {
        return linesOfCode;
    }

    /**
     * Set the actual effort
     * @param actualEffort the effort, must be something
     */
    public void setActualEffort(Effort actualEffort) {
        if(actualEffort == null)
            throw new RuntimeException("There must be an effort set!");
        
        this.actualEffort = actualEffort;
    }

    /**
     * Set the number of lines of code
     * @param linesOfCode the number of lines of code
     */
    public void setLinesOfCode(int linesOfCode) {
        if(linesOfCode < 0)
            throw new RuntimeException("Invalid number of lines of code, it has to be >= 0");
            
        this.linesOfCode = linesOfCode;
    } 
    
    /**
     * Create an empty project with default values, contains no charachteristics
     */
    public Project()
    {
        this.attributes = new HashMap<Attribute, Rating>();
        this.linesOfCode = 0;
        this.actualEffort = Effort.instansiatePersonHours(0);
        this.identifier = "Undefined Project";
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;
        else if(o == this) {
            return true;
        }
        else if(o instanceof Project) {
            Project proj = (Project)o;
            return proj.identifier.equals(this.identifier) &&
                   proj.actualEffort.equals(this.actualEffort) &&
                   proj.attributes.equals(this.attributes);
        }
        else
            return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Attribute attr : Attribute.values()) {
            sb.append(attributes.get(attr));
            sb.append(",");
        }
        
        //Remove trailing ","
        sb.deleteCharAt(sb.length()-1);
        
        return String.format("Project: %1$ {%2$,%3$,%4$}", identifier, sb.toString(), linesOfCode, actualEffort.toPersonHours());
    }
}
