/**
 * Genyornis is a concrete implementation of the Species class.
 * It is a bird herbivore with no aggression and is not a predator.
 *
 * @author Anmol Singh
 * @version 1.0.3
 * @see Species
 */
public class Genyornis extends Species
{
    /** 
    * Constructor to initialize Genyornis species name.
    */
    public Genyornis()
    {
        super("Genyornis");
    }

    /**
     * Method to return aggression level of Genyornis Species.
     *
     * @return aggression level
    */
    public String getAggressionLevel()
    {
        return AggressionLevel.NONE;
    }

    /**
     * Method to return diet of Genyornis Species.
     *
     * @return diet type
     */
    public String getDiet()
    {
        return Diet.HERBIVORE;
    }

    /**
     * Method to return Animal type of Genyornis Species.
     *
     * @return animal type
     */
    public String getType()
    {
        return AnimalType.BIRD;
    }

    /**
     * Method to returns predator status.
     *
     * @return false because Genyornis is not a predator
     */
    public boolean isPredator()
    {
        return false;
    }
}
