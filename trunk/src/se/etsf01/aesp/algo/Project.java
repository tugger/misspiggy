package se.etsf01.aesp.algo;

import java.util.*;

/**
 * Represents a single project
 */
public class Project
{
    /**
     * The attributes of the project
     */
    public HashMap<Attribute,Rating> attributes;
    
    /**
     * The number of lines of code
     */
    public int linesOfCode;
    
    /**
     * The actual effort in seconds
     */
    public int actualEffort;
    
    
    public Project()
    {
        this.attributes = new HashMap<Attribute, Rating>();
        this.linesOfCode = 0;
        this.actualEffort = 0;
    }
}
