/**
 * Abstract Species class represents a megafauna species in the safari simulation.
 * It stores the name of the species and declares abstract methods for type, diet,
 * predator status, and aggression level to be implemented by each concrete subclass.
 *
 * @author Anmol Singh
 * @version 1.0.4
 */
public abstract class Species
{  
    private String name;
    /**
     * Default constructor initializes a Species object with default values.
    */
    public Species()
    {
        this.name = "unknown";
    }
    /**
     * Parameterized constructor initializes a Species object with species name.
     *
     * @param name the name of the species
     */
    public Species(String name)
    {
        setName(name);
    }

    /**
     * Accessor method returns the aggression level of the species.
     *
     * @return the aggression level of the species
     */
    public abstract String getAggressionLevel();

    /**
     * Accessor method returns the diet of the species.
     *
     * @return the diet of the species
     */
    public abstract String getDiet();

    /**
     * Accessor method returns the name of the species.
     *
     * @return the name of the species
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Accessor method returns the type of the species.
     *
     * @return the type of the species
     */
    public abstract String getType();
    
    /**
     * Accessor method returns whether the species is a predator.
     *
     * @return true if the species is a predator, else false
     */
    public abstract boolean isPredator();
    
    /**
     * Mutator method sets the name of the species.
     *
     * @param name the name of the species
     */
    public void setName(String name)
    {
        if (Validation.isValidName(name))
        {
            this.name = name;
        }
        else
        {
            this.name = "unknown";
        }
    }

    /**
     * Returns the species details as a formatted String.
     *
     * @return a String containing the species details
     */
    public String toString()
    {
        return "\nSpecies: " +
        "\n\tName: " + getName() + 
        "\n\tType: " + getType() + 
        "\n\tDiet: " + getDiet() +
        "\n\tPredator: " + (isPredator() ? "Yes" : "No") + 
        "\n\tAggression Level: " + getAggressionLevel();
    }
}
