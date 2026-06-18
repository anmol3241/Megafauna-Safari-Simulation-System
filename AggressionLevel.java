/**
 * Utility class that stores the constant aggression level values for safari animals.
 * It cannot be instantiated and is used throughout the program to reference aggression levels.
 *
 * @author Anmol Singh
 * @version 1.0.1
 */
public class AggressionLevel
{
    /**
     * Constant represen an extreme aggression level.
     */
    public static final String EXTREME = "extreme";

    /**
     * Constant represents a moderate aggression level.
     */
    public static final String MODERATE = "moderate";

    /**
     * Constant represents a passive aggression level.
     */
    public static final String PASSIVE = "passive";

    /**
     * Constant represents no aggression.
     */
    public static final String NONE = "none";

    /**
     * Constant represents an unknown aggression level.
     */
    public static final String UNKNOWN = "unknown";

    //Private Constructor to prevent object creation of AggressionLevel class
    private AggressionLevel()
    {
    }
}
