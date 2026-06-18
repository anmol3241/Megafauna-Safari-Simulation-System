/**
 * Megalania is a concrete implementation of the Species class.
 * It is a reptile carnivore with moderate aggression and is a predator.
 *
 * @author Anmol Singh
 * @version 1.0.3
 * @see Species
 */
public class Megalania extends Species
{
    /**
     * Constructor initializes Megalania species name.
     */
    public Megalania()
    {
        super("Megalania");
    }

    /**
     * Method to return aggression level of Megalania Species.
     *
     * @return aggression level
    */
    public String getAggressionLevel()
    {
        return AggressionLevel.MODERATE;
    }

    /**
     * Method to return diet of Megalania Species.
     *
     * @return diet type
     */
    public String getDiet()
    {
        return Diet.CARNIVORE;
    }

    /**
     * Method to return Animal type of Megalania Species.
     *
     * @return animal type
     */
    public String getType()
    {
        return AnimalType.REPTILE;
    }

    /**
     * Method to returns predator status.
     *
     * @return true because Megalania is a predator
     */
    public boolean isPredator()
    {
        return true;
    }
}
