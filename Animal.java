/**
 * This class represents one individual animal in the safari simulation.
 * It stores the identity, species, alive status, and spotted status of the animal.
 *
 * @author Anmol Singh
 * @version 1.0.6
 */
public class Animal
{
    private int identity;
    private Species species;
    private boolean alive;
    private boolean spotted;
    
    /**
     * Default constructor initializes an Animal object with default values.
     */
    public Animal()
    {
        //The default identity 0 indicates animal doesn't exist.
        this.identity = 0;
        this.species = new UnknownSpecies();
        this.alive = true;
        this.spotted = false;
    }

    /**
     * Parameterized constructor initializes an Animal object with given values.
     *
     * @param identity the unique three-digit identity of the animal
     * @param species the Species object containing details of the animal
     * @param alive true if the animal is alive, else false
     * @param spotted true if the animal spotted, else false
     */
    public Animal(int identity, Species species, boolean alive, boolean spotted)
    {
        setIdentity(identity);
        setSpecies(species);
        this.alive = alive;
        this.spotted = spotted;
    }

    /**
     * Accessor method returns the identity of the animal.
     *
     * @return the identity of the animal
     */
    public int getIdentity()
    {
        return this.identity;
    }
    
    /**
     * Accessor method returns the Species object of the animal.
     *
     * @return the species of the animal
     */
    public Species getSpecies()
    {
        return this.species;
    }

    /**
     * Returns whether the animal has been spotted.
     *
     * @return true if the animal has been spotted, otherwise false
     */
    public boolean getSpotted()
    {
        return this.spotted;
    }

    /**
     * Accessor method returns whether the animal is alive.
     *
     * @return true if the animal is alive, else false
     */
    public boolean isAlive()
    {
        return this.alive;
    }

    /**
     * Marks the animal as dead by setting alive status to false.
     * It'll be used when an animal is killed during the safari simulation.
     */
    public void killAnimal()
    {
        this.alive = false;
    }

    /**
     * Mutator method sets the alive status of the animal.
     *
     * @param alive true if the animal is alive, else false
     */
    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }
    
    /**
     * Mutator method sets the identity of the animal.
     * If an invalid identity is entered, the identity is set to 0.
     *
     * @param identity the unique 3 digit identity of the animal
     */
    public void setIdentity(int identity)
    {
        if(Validation.isValidIdentity(identity))
        {
            this.identity = identity; 
        }
        else
        {
            this.identity = 0;
            System.out.println("\nError: Enter a valid 3 digit ID i.e 001 to 999 INT" );
        }
    }


    /**
     * Mutator method sets the Species object of an animal.
     * If the Species object is null, a default Species object is created.
     *
     * @param species the Species object of the animal
     */
    public void setSpecies(Species species)
    {
        if(Validation.isValidSpecies(species))
        {
            this.species = species;
        }
        else
        {
            this.species = new UnknownSpecies();
        }
    }

    /**
     * Sets the spotted status of the animal.
     *
     * @param spotted true if the animal has been spotted, otherwise false
     */
    public void setSpotted(boolean spotted)
    {
        this.spotted = spotted;
    }
    
    /**
     * Returns the animal details as a String.
     *
     * @return a String containing the animal's identity, alive status, and species details
     */
    public String toString()
    {
        return "\nAnimal Status: " + 
        "\n\tIdentity: " + this.identity + 
        "\n\tAlive: " + (this.alive ? "Yes" : "No") +
        "\n\tSpotted: " + (this.spotted ? "Yes" : "No") +
        "\n\t" + species.toString() ; 
    }
}
