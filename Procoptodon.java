/**
 * Procoptodon is a concrete implementation of the Species class.
 * It is a marsupial herbivore with no aggression and is not a predator.
 *
 * @author Anmol Singh
 * @version 1.0.3
 * @see Species
 */
public class Procoptodon extends Species
{
    /** 
    * Constructor to initialize Procoptodon species name.
    */
    public Procoptodon()
    {
        super("Procoptodon");
    }

    /**
     * Method to return aggression level of Procoptodon Species.
     *
     * @return aggression level
    */
    public String getAggressionLevel()
    {
        return AggressionLevel.NONE;
    }

    /**
     * Method to return diet of Procoptodon Species.
     *
     * @return diet type
     */
    public String getDiet()
    {
        return Diet.HERBIVORE;
    }

    /**
     * Method to return Animal type of Procoptodon Species.
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
     * @return false because Procoptodon is not a predator
     */
    public boolean isPredator()
    {
        return false;
    }
}
