/**
 * UnknownSpecies is a concrete implementation of the Species class.
 * It is used as a default species when no valid species is provided.
 *
 * @author Anmol Singh
 * @version 1.0.0
 * @see Species
 */
public class UnknownSpecies extends Species
{
    /**
     * Constructor initializes unknown species.
     */
    public UnknownSpecies()
    {
        super("unknown");
    }

    /**
     * 
     * Method to return unknown aggression level.
     *
     * @return unknown aggression level
     */
    public String getAggressionLevel()
    {
        return AggressionLevel.UNKNOWN;
    }

    /**
     * Method to return unknown diet.
     *
     * @return unknown diet
     */
    public String getDiet()
    {
        return Diet.UNKNOWN;
    }

    /**
     * Method to return unknown Animal type.
     *
     * @return unknown type
     */
    public String getType()
    {
        return AnimalType.UNKNOWN;
    }

    /**
     * Method to return default predator status.
     *
     * @return false
     */
    public boolean isPredator()
    {
        return false;
    }
}
