import java.util.ArrayList;
/**
 * Location class represent a safari location that can be visited during a tour.
 * Each location has a location no., visit status, and a list of animals present.
 *
 *
 * @author Anmol Singh
 * @version 1.0.3
 */

public class Location
{
    private int locationNumber;
    private boolean visited;
    private ArrayList<Animal> animals;

   /**
    * Default constructor initializes a location with default values.
    * Location number is set to 0, visited is false, and animals list is empty.
    */
    public Location()
    {
        this.locationNumber = 0;
        this.visited = false;
        this.animals = new ArrayList<Animal>();
    }

    /**
     * Parameterized constructor initializes a location with a specific location number,
     * false visit status and empty animal list.
     *
     * @param locationNumber, an integer used as location identity.
     */
    public Location(int locationNumber)
    {
        setLocationNumber(locationNumber);
        this.visited = false;
        this.animals = new ArrayList<Animal>();
    }

    /**
     * Method to add an animal to this location.
     *
     * @param animal the Animal object to add to this location.
     */
    public void addAnimal(Animal animal)
    {
        if (Validation.isValidAnimal(animal))
        {
            this.animals.add(animal);
        }
    }

    /**
     * Method to count the number of animals at specific location that belong to the
     * specific species.
     *
     * @param species the Species to count animal's occurrences.
     * @return the number of animals of the given species as an int.
     */
    public int countSpecies(Species species)
    {
        int count = 0;

        for (Animal animal : this.animals)
        {
            if (animal.getSpecies().getName().equals(species.getName()))
            {
                count++;
            }
        }

        return count;
    }

   /**
    * Counts the number of spotted animals at this location belonging to the specified species.
    *
    * @param species the Species to count spotted occurrences of.
    * @return the number of spotted animals of that species as an int.
    */
    public int countSpotted(Species species)
    {
        int count = 0;
        for (Animal animal : this.animals)
        {
            if (animal.getSpotted() && animal.getSpecies().getName().equals(species.getName()))
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Accessor method to return the list of animals at this location.
     *
     * @return the animals at this location as an ArrayList of Animal objects.
     */
    public ArrayList<Animal> getAnimals()
    {
        return this.animals;
    }

    /**
     * Accessor method to return the location number.
     *
     * @return the location number as an int.
     */
    public int getLocationNumber()
    {
        return this.locationNumber;
    }

    /**
     * Accessor method to return the total number of animals at this location.
     *
     * @return the number of animals as an int.
     */
    public int getNumberOfAnimals()
    {
        return this.animals.size();
    }

    /**
     * Accessor method to check whether the location visited.
     *
     * @return true if the location has been visited, otherwise false.
     */
    public boolean isVisited()
    {
        return this.visited;
    }

    /**
     * Mutator method to set the location number.
     *
     * @param locationNumber the location number to assign as an int.
     */
    public void setLocationNumber(int locationNumber)
    {
        if (Validation.isValidLocationNumber(locationNumber))
        {
            this.locationNumber = locationNumber;
        }
        else
        {
            this.locationNumber = 0;
            System.out.println("Error: Location number must be greater than 1.");
        }
    }

    /**
     * Mutator method to set the visit status of this location.
     *
     * @param visited true if the location is visited, otherwise false.
     */
    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }


    /**
     * ToString method to return the location details as a formatted String.
     *
     * @return a String containing the full location details.
     */
    public String toString()
    {
        return "\nLocation: " + this.locationNumber +
            "\n\tVisited: " + (this.visited ? "Yes" : "No") +
            "\n\tNumber of Animals: " + this.animals.size() +
            "\n\tDiprotodon: " + countSpecies(SpeciesData.DIPROTODON) +
            "\n\tProcoptodon: " + countSpecies(SpeciesData.PROCOPTODON) +
            "\n\tThylacoleo: " + countSpecies(SpeciesData.THYLACOLEO) +
            "\n\tMegalania: " + countSpecies(SpeciesData.MEGALANIA) +
            "\n\tWonambi: " + countSpecies(SpeciesData.WONAMBI) +
            "\n\tGenyornis: " + countSpecies(SpeciesData.GENYORNIS);
    }
}
