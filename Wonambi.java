/**
 * Wonambi is a concrete implementation of the Species class.
 * It is a reptile carnivore with passive aggression and is a predator.
 *
 * @author Anmol Singh
 * @version 1.0.3
 * @see Species
 */
public class Wonambi extends Species
{
    /** 
    * Constructor to initialize Wonambi species name.
    */
    public Wonambi()
    {
        super("Wonambi");
    }

    /**
     * Method to return aggression level of Wonambi Species.
     *
     * @return aggression level
    */
    public String getAggressionLevel()
    {
        return AggressionLevel.PASSIVE;
    }

    /**
     * Method to return diet of Wonambi Species.
     *
     * @return diet type
     */
    public String getDiet()
    {
        return Diet.CARNIVORE;
    }

    /**
     * Method to return Animal type of Wonambi Species.
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
     * @return true because Wonambi is predator
     */
    public boolean isPredator()
    {
        return true;
    }
}
