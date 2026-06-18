/**
 * Utility class that stores constant animal type values for the safari simulation.
 * It cannot be instantiated and is used throughout the program to reference animal types.
 *
 * @author Anmol Singh
 * @version 1.0.1
 */
public class AnimalType
{
    /**
    * Constant representing a marsupial, directly access by class name.
    */
    public static final String MARSUPIAL = "marsupial";

    /**
    * Constant representing a reptile, directly access by class name.
    */
    public static final String REPTILE = "reptile";

    /**
    * Constant representing a bird, directly access by class name.
    */
    public static final String BIRD = "bird";

    /**
    * Constant representing an unknown animal type, directly access by class name.
    */
    public static final String UNKNOWN = "unknown";

    //Private Constructor to prevent object creation of AnimalType class
    private AnimalType()
    {
    }
}
