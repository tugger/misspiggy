package se.etsf01.aesp.algo;

/**
 * The rating of a project attribute
 * The are ordered from 0 to n in degree. Use ordinal() to get the value
 */
public enum Rating {
    VERY_LOW,
    LOW,
    NOMINAL,
    HIGH,
    VERY_HIGH,
    EXTRA_HIGH;
    
    public static Rating fromString(String rating)
    {
        String value = rating.toUpperCase();
        return Enum.valueOf(Rating.class, value);
    }
}
