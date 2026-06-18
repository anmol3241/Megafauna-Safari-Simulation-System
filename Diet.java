/**
 * Utility class that stores constant dietary type values for the safari simulation.
 * It cannot be instantiated and is used throughout the program to reference animal diets.
 *
 * @author Anmol Singh
 * @version 1.0.1
 */
public class Diet 
{
    /**
     * Constant representing a herbivore diet.
     */
    public static final String HERBIVORE = "herbivore";

    /**
     * Constant representing a carnivore diet.
     */
    public static final String CARNIVORE = "carnivore";

    /**
     * Constant representing an unknown diet.
     */
    public static final String UNKNOWN = "unknown";

    //Private Constructor to prevent object creation of Diet Class
    private Diet()
    {
    }
}
