import java.util.ArrayList;
/**
 * TourSummary records and summarises the safari tour data.
 * It tracks locations visited, animals sighted, injuries, deaths,
 * and calculates an overall tour success rating.
 *
 * @author Anmol Singh
 * @version 1.2.0
 */
public class TourSummary
{
    private int locationsVisited;
    private int originalTourists;
    private int totalAnimalsSighted;
    private int totalAnimalsAtVisitedLocations;
    private int minorInjuries;
    private int majorInjuries;
    private int deaths;
    private ArrayList<String> speciesSighted;
    private ArrayList<Animal> killedAnimals;

   /**
    * Constructor initializes the tour summary with the original tourist count.
    * All other statistics are set to zero and lists are initialized as empty.
    *
    * @param originalTourists the number of tourists at the start of the tour as an int.
    */
    public TourSummary(int originalTourists)
    {
        this.locationsVisited = 0;
        this.originalTourists = originalTourists;
        this.totalAnimalsSighted = 0;
        this.totalAnimalsAtVisitedLocations = 0;
        this.minorInjuries = 0;
        this.majorInjuries = 0;
        this.deaths = 0;
        this.speciesSighted  = new ArrayList<String>();
        this.killedAnimals   = new ArrayList<Animal>();
    }

    /**
     * Records a sighted animal and adds its species name if not already recorded.
     *
     * @param animal the Animal that was sighted.
     */
    public void addAnimalSighted(Animal animal)
    {
        this.totalAnimalsSighted++;
        String name = animal.getSpecies().getName();
        if (!this.speciesSighted.contains(name))
            this.speciesSighted.add(name);
    }

    /**
     * Marks the location as visited, increments the locations visited counter,
     * and adds its animal count to the total.
     *
     * @param location the Location that was visited.
     */
    public void addLocationVisited(Location location)
    {
        location.setVisited(true);
        this.locationsVisited++;
        this.totalAnimalsAtVisitedLocations += location.getNumberOfAnimals();
    }

    /**
     * Records the outcome of a tourist by reading their injury and alive
     * status directly from the Tourist object.
     * Increments minor injuries, major injuries, or deaths accordingly.
     *
     * @param tourist the Tourist whose outcome is to be recorded.
     */
    public void recordTouristOutcome(Tourist tourist)
    {
        if (tourist == null) return;

        if (!tourist.isAlive())
        {
            this.deaths++;
        }
        else if (tourist.getInjuryStatus().equals("major"))
        {
            this.majorInjuries++;
        }
        else if (tourist.getInjuryStatus().equals("minor"))
        {
            this.minorInjuries++;
        }
    }

    /**
     * Adds a killed animal to the list if it is not null.
     *
     * @param animal the Animal that was killed.
     */
    public void addKilledAnimal(Animal animal)
    {
        if (animal != null) this.killedAnimals.add(animal);
    }

    /**
     * Accessor method to return the number of tourist deaths.
     *
     * @return the death count as an int.
     */
    public int getDeaths() 
    { 
        return this.deaths; 
    }

    /**
     * Accessor method to return the number of locations visited.
     *
     * @return the locations visited count as an int.
     */
    public int getLocationsVisited() 
    { 
        return this.locationsVisited; 
    }

    /**
     * Accessor method to return the number of major injuries.
     *
     * @return the major injury count as an int.
     */
    public int getMajorInjuries()    
    { 
        return this.majorInjuries; 
    }

    /**
     * Accessor method to return the number of minor injuries.
     *
     * @return the minor injury count as an int.
     */
    public int getMinorInjuries()    
    {   
        return this.minorInjuries; 
    }

    /**
     * Calculates and returns the tour success rating as a percentage.
     * Returns 0.0 if any tourist died, no animals were present, or no tourists participated.
     *
     * @return the tour success rating as a double between 0.0 and 100.0.
     */
    public double calculateRating()
    {
        if (this.deaths > 0 || this.totalAnimalsAtVisitedLocations == 0 || this.originalTourists == 0)
            return 0.0;

        return 100.0 * (
            0.25 * ((double) this.locationsVisited / 5.0) +
            0.50 * ((double) this.speciesSighted.size() / 6.0) +
            0.25 * ((double) this.totalAnimalsSighted / this.totalAnimalsAtVisitedLocations) -
            0.10 * ((double) this.minorInjuries / this.originalTourists) -
            0.20 * ((double) this.majorInjuries / this.originalTourists)
        );
    }

    /**
     * Counts the number of killed animals belonging to the specified species.
     *
     * @param species the Species to count as killed.
     * @return the count of killed animals of that species as an int.
     */
    public int countKilledSpecies(Species species)
    {
        int count = 0;
        for (Animal a : this.killedAnimals)
            if (a.getSpecies().getName().equals(species.getName())) count++;
        return count;
    }

    /**
     * ToString method to return a formatted summary of the tour statistics,
     * including injuries, deaths, species sighted, animals killed, and the success rating.
     *
     * @return a String containing the full tour summary.
     */
    public String toString()
    {
        String summary = "";
        summary += "\n=====================================";
        summary += "\n         Simulation Summary          ";
        summary += "\n=====================================";
        summary += "\nNumber of Locations visited: " + this.locationsVisited;
        summary += "\nNumber of tourists: " + this.originalTourists;
        summary += "\nTotal number of species sighted: " + this.speciesSighted.size();
        summary += "\n\t";
        if (this.speciesSighted.isEmpty()) 
            summary += "None";
        else 
        { 
            int count = 1;
            for (String name : this.speciesSighted)
            {
                 summary = summary + count + ".";
                 summary += name + " ";
                 count++;
            }
        }
        summary += "\nTotal number of animals sighted: " + this.totalAnimalsSighted;
        summary += "\nTotal number of animals at the locations visited: " + this.totalAnimalsAtVisitedLocations;
        summary += "\nNumber of tourists inflicted minor injuries: " + this.minorInjuries;
        summary += "\nNumber of tourists inflicted major injuries: " + this.majorInjuries;
        summary += "\nNumber of tourists' deaths: " + this.deaths;
        summary += "\n\nList of Animals killed during tour:";
        summary += "\n\tDiprotodon: " + countKilledSpecies(SpeciesData.DIPROTODON);
        summary += "\n\tProcoptodon: " + countKilledSpecies(SpeciesData.PROCOPTODON);
        summary += "\n\tThylacoleo: " + countKilledSpecies(SpeciesData.THYLACOLEO);
        summary += "\n\tMegalania: " + countKilledSpecies(SpeciesData.MEGALANIA);
        summary += "\n\tWonambi: " + countKilledSpecies(SpeciesData.WONAMBI);
        summary += "\n\tGenyornis: " + countKilledSpecies(SpeciesData.GENYORNIS);
        summary += String.format("%n%nTour success rating: %.2f%%", calculateRating());
        return summary;
    }
}
