/**
 * Diprotodon is a concrete implementation of the Species class.
 * It is a marsupial herbivore with no aggression and is not a predator.
 *
 * @author Anmol Singh
 * @version 1.0.2
 * @see Species
 */
public class Diprotodon extends Species
{
    /** 
    * Constructor to initialize Diprotodon species name.
    */
    public Diprotodon()
    {
        super("Diprotodon");
    }

    /**
     * Method to return aggression level of Diprotodon Species.
     *
     * @return aggression level
    */
    public String getAggressionLevel()
    {
        return AggressionLevel.NONE;
    }

    /**
     * Method to return diet of Diprotodon Species.
     *
     * @return diet type
     */
    public String getDiet()
    {
        return Diet.HERBIVORE;
    }

    /**
     * Method to return Animal type of Diprotodon Species.
     *
     * @return animal type
     */
    public String getType()
    {
        return AnimalType.MARSUPIAL;
    }

    /**
     * Method to returns predator status.
     *
     * @return false because Diprotodon is not a predator
     */
    public boolean isPredator()
    {
        return false;
    }
}
