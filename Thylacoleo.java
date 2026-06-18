/**
 * Thylacoleo is a concrete implementation of the Species class.
 * It is a marsupial carnivore with extreme aggression and is a predator.
 *
 * @author Anmol Singh
 * @version 1.0.3
 * @see Species
 */
public class Thylacoleo extends Species
{
    /** 
    * Constructor to initialize Thylacoleo species name.
    */
    public Thylacoleo()
    {
        super("Thylacoleo");
    }

    /**
     * Method to return aggression level of Thylacoleo Species.
     *
     * @return aggression level
    */
    public String getAggressionLevel()
    {
        return AggressionLevel.EXTREME;
    }

    /**
     * Method to return diet of Thylacoleo Species.
     *
     * @return diet type
     */
    public String getDiet()
    {
        return Diet.CARNIVORE;
    }

    /**
     * Method to return Animal type of Thylacoleo Species.
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
     * @return true because Thylacoleo is predator
     */
    public boolean isPredator()
    {
        return true;
    }
}
