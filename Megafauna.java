import java.io.IOException;
import java.util.ArrayList;

/**
 * This is main controller class for the Megafauna Safari Simulation.
 * It serves as main client class and controls the flow of program.
 *
 * @author Anmol Singh
 * @version 1.2.0
 */
public class Megafauna
{
    private static final int MAX_LOCATIONS = 5;
    private ArrayList<Location> locations;
    private ArrayList<Tourist> tourists;
    private FileIO fileIO;
    private Input input;
    private RandomSafariEvent randomSafariEvent;
    private Tour selectedTour;
    private TourSummary tourSummary;

    /**
     * Default constructor initialises default objects and empty lists.
     */
    public Megafauna()
    {
        this.locations = new ArrayList<Location>();
        this.tourists = new ArrayList<Tourist>();
        this.fileIO = new FileIO();
        this.input = new Input();
        this.randomSafariEvent = new RandomSafariEvent();
        this.selectedTour = null;
        this.tourSummary = null;
    }

    /**
     * Displays the report at the end of every visit.
     *
     *
     * @param location      the location that was just visited
     * @param attackedCount total tourists attacked this visit
     * @param minorBefore   minor injury count before this visit
     * @param majorBefore   major injury count before this visit
     * @param deathsBefore  death count before this visit
     */
    public void displayEndOfVisit(Location location, int attackedCount, int minorBefore, int majorBefore, int deathsBefore)
    {
        System.out.println("\n----------------");
        System.out.println("  End of visit  ");
        System.out.println("----------------");
        System.out.println("Animal spotted:");
        System.out.println("\tDiprotodon: " + location.countSpotted(SpeciesData.DIPROTODON));
        System.out.println("\tProcoptodon: " + location.countSpotted(SpeciesData.PROCOPTODON));
        System.out.println("\tThylacoleo: " + location.countSpotted(SpeciesData.THYLACOLEO));
        System.out.println("\tMegalania: " + location.countSpotted(SpeciesData.MEGALANIA));
        System.out.println("\tWonambi: " + location.countSpotted(SpeciesData.WONAMBI));
        System.out.println("\tGenyornis: " + location.countSpotted(SpeciesData.GENYORNIS));
        System.out.println("Number of tourists attacked: " + attackedCount);
        System.out.println("\tKilled Tourist: " + (this.tourSummary.getDeaths() - deathsBefore));
        System.out.println("\tMajor injury: " + (this.tourSummary.getMajorInjuries() - majorBefore));
        System.out.println("\tMinor injury: " + (this.tourSummary.getMinorInjuries() - minorBefore));
    }

    /**
     * Method to display a formatted table showing each suitable location with animal count.
     *
     * @param locations the list of suitable locations to display
     */
    public void displayLocations(ArrayList<Location> locations)
    {
        // Array of all species
        Species[] allSpecies = {
            SpeciesData.DIPROTODON,
            SpeciesData.PROCOPTODON,
            SpeciesData.THYLACOLEO,
            SpeciesData.MEGALANIA,
            SpeciesData.WONAMBI,
            SpeciesData.GENYORNIS
        };
        System.out.printf("%-10s| %-12s| %-13s| %-12s| %-11s| %-9s| %-10s%n",
            "Location", "Diprotodon", "Procoptodon", "Thylacoleo", "Megalania", "Wonambi", "Genyornis");
        System.out.println("-".repeat(84));

        for (int i = 0; i < locations.size(); i++)
        {
            Location loc = locations.get(i);
            System.out.printf("%-10d", (i + 1));
            for (Species species : allSpecies)
            {
                System.out.printf("| %-12d", loc.countSpecies(species));
            }
            System.out.println();
        }

        System.out.print("\nChoose the next location (1-" + locations.size() + "): ");
    }

    /**
     * Displays the welcome message.
     */
    public void displayWelcome()
    {
        System.out.println("=========================================");
        System.out.println("  Welcome to Megafauna Safari Simulation  ");
        System.out.println("=========================================");
    }

    /**
     * Displays the reason of tour ended as per tour simulation status.
     */
    public void endTour()
    {
        System.out.println("\n***********************************************");
        if (this.tourSummary.getDeaths() > 0)
        {
            System.out.println("  A tourist has died, Hence Tour is terminated ");
        }
        else if (this.tourists.size() == 0)
        {
            System.out.println(" No more tourist left, Hence Tour is terminated ");
        }
        else if (this.tourSummary.getLocationsVisited() >= MAX_LOCATIONS)
        {
            System.out.println("  Maximum locations visited, Tour Completed ");
        }
        else
        {
            System.out.println("  No suitable locations remain, Tour Completed ");
        }
        System.out.println("***********************************************");
    }

    /**
     * Returns all locations that are both suitable for the selected tour
     * and have not yet been visited.
     *
     * @return ArrayList of eligible Location objects
     */
    public ArrayList<Location> getSuitableLocations()
    {
        ArrayList<Location> suitable = new ArrayList<Location>();

        for (Location location : this.locations)
        {
            if (!location.isVisited() && this.selectedTour.isLocationSuitable(location))
            {
                suitable.add(location);
            }
        }

        return suitable;
    }

    /**
     * Method to handle one predator's attack on the first tourist in the group.
     *
     *
     * @param animal the predator that attacked
     */
    public void handleAttack(Animal animal)
    {
        if (this.tourists.size() == 0)
        {
            return;
        }

        Tourist tourist = this.tourists.get(0);
        int result = this.randomSafariEvent.getInjuryOutcome();
        animal.killAnimal();
        this.tourSummary.addKilledAnimal(animal);

        if (result < 15)
        {
            tourist.inflictMinorInjury();
            this.tourSummary.recordTouristOutcome(tourist);
        }
        else if (result < 80)
        {
            tourist.inflictMajorInjury();
            this.tourSummary.recordTouristOutcome(tourist);
            this.tourists.remove(tourist);
         }
        else
        {
            tourist.kill();
            this.tourSummary.recordTouristOutcome(tourist);
            this.tourists.remove(tourist);
        }
    }

    /**
     * Loads locations and animals from sighting.txt via FileIO.
     *
     * @throws IOException if the file cannot be read
     */
    public void loadData() throws IOException
    {
        this.fileIO.readFile();
        this.locations = this.fileIO.getLocations();
    }

    /**
     * Main method creates a Megafauna object and starts the simulation.
     *
     * @param args   An array of Strings representing command line arguments.
     */
    public static void main(String[] args)
    {
        Megafauna megafauna = new Megafauna();
        megafauna.simulate();
    }

    /**
     * Displays tour options, reads the guide's choice
     * and initialises TourSummary.
     */
    public void setupTour()
    {
        System.out.println("\n--------------------");
        System.out.println("  Available Tours  ");
        System.out.println("--------------------");
        System.out.println("1: Megafauna meander (risk: LOW)");
        System.out.println("2: Giants trail (risk: MEDIUM)");
        System.out.println("3: Predator zone (risk: HIGH)");

        int choice = this.input.readTourChoice();

        if (choice == 1)
        {
            this.selectedTour = new MegafaunaMeander();
        }
        else if (choice == 2)
        {
            this.selectedTour = new GiantsTrail();
        }
        else
        {
            this.selectedTour = new PredatorZone();
        }

        this.tourSummary = new TourSummary(this.tourists.size());

        System.out.println("\nSelected tour: " + this.selectedTour.getTourType());
        System.out.println("\nThis tour will visit up to " + MAX_LOCATIONS + " locations.");
    }

    /**
     * Method to prompt the number of tourists for safari.
     */
    public void setupTourists()
    {
        int count = this.input.readNumberOfTourists();

        for (int i = 1; i <= count; i++)
        {
            this.tourists.add(new Tourist(i));
        }
    }

    /**
     * Method to run the full simulation i.e. load data, welcome message, setup tour and summary.
     */
    public void simulate()
    {
        try
        {
            loadData();
            displayWelcome();
            setupTourists();
            setupTour();
            startTour();
            endTour();
            System.out.println(this.tourSummary);
            this.fileIO.writeSummaryToFile(this.tourSummary);
        }
        catch (IOException e)
        {
            System.out.println("Error: Could not read sighting.txt. Please check the file exists.");
        }
    }
    
    /**
     * Tour simulation loop.
     *
     */
    public void startTour()
    {
        while (this.tourSummary.getLocationsVisited() < MAX_LOCATIONS)
        {
            ArrayList<Location> suitable = getSuitableLocations();

            if (suitable.size() == 0)
            {
                break;
            }

            System.out.println("\n----------------------------------");
            System.out.println(" Get ready for the next location ");
            System.out.println("----------------------------------\n");

            displayLocations(suitable);

            int choice = this.input.readLocationChoice(suitable.size());
            Location location = suitable.get(choice - 1);

            visitLocation(location);

            if (this.tourSummary.getDeaths() > 0 || this.tourists.size() == 0)
            {
                break;
            }
        }
    }
    
    /**
     * Simulates visiting one location and tracking TourSummary.
     *
     * @param location the Location to visit
     */
    public void visitLocation(Location location)
    {
        this.tourSummary.addLocationVisited(location);

        int attackedCount = 0;
        int minorBefore = this.tourSummary.getMinorInjuries();
        int majorBefore = this.tourSummary.getMajorInjuries();
        int deathsBefore = this.tourSummary.getDeaths();

        for (Animal animal : location.getAnimals())
        {
            if (this.tourSummary.getDeaths() > 0 || this.tourists.size() == 0)
            {
                break;
            }

            //Each alive animal has a 50% chance of being spotted.
            if (animal.isAlive() && this.randomSafariEvent.isAnimalSpotted())
            {
                animal.setSpotted(true);
                this.tourSummary.addAnimalSighted(animal);

                if (animal.getSpecies().isPredator())
                {
                    //Spotted predators may attack a tourist.
                    if (this.randomSafariEvent.doesPredatorAttack(animal.getSpecies().getAggressionLevel()))
                    {
                        attackedCount++;
                        handleAttack(animal);
                    }
                }
            }
        }

        displayEndOfVisit(location, attackedCount, minorBefore, majorBefore, deathsBefore);
    }
}
