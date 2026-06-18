import java.util.*;
import java.io.*;

/**
 * FileIO class handles all file input and output operations for the safari simulation.
 * It reads animal sighting data from a file, creates Location objects,
 * and writes the final tour summary to an output report file.
 *
 * @author Anmol Singh
 * @version 1.0.3
 */
public class FileIO
{
    /**
     * Constant to store the input file containing animal sightings.
     */
    public static final String SIGHTING_FILE = "sighting.txt";

    /**
     * Constant to store the output file containing Megafauna safari tour summary.
     */
    public static final String REPORT_FILE = "tour.txt";
    private ArrayList<Location> locations;
    private int nextAnimalId;

    /**
     * Default constructor initialises the FileIO object.
     * Creates an empty list of locations and sets the next animal ID to 100.
     */
    public FileIO()
    {
        this.locations = new ArrayList<Location>();
        this.nextAnimalId = 100;
    }

    /**
     * Method that adds a specified number of animals of a given species to a location.
     * Each animal has a unique ID and is initially alive and not spotted.
     *
     *
     * @param location the Location object to which animals are added
     * @param species  the Species object representing the Animal's characteristics.
     * @param count    the number of animals to create and add
     */
    private void addAnimals(Location location, Species species, int count)
    {
        for (int i = 0; i < count; i++)
        {
            Animal animal = new Animal(this.nextAnimalId, species, true, false);
            location.addAnimal(animal);
            this.nextAnimalId++;
        }
    }

    /**
     * Method to return all locations created from the sighting file.
     *
     * @return an ArrayList containing all Location objects
     */
    public ArrayList<Location> getLocations()
    {
        return this.locations;
    }

    /**
     * Reads the sighting file and populates the locations list with animals.
     * Invalid lines are skipped and error message print.
     *
     * @throws IOException if the sighting.txt file cannot be found or read
     */
     public void readFile() throws IOException
    {
        this.locations = new ArrayList<Location>();
        this.nextAnimalId = 100;
        FileReader reader = new FileReader(SIGHTING_FILE);
        Scanner fileScanner = new Scanner(reader);
        int locationNumber = 1;

        while (fileScanner.hasNextLine())
        {
            String line = fileScanner.nextLine().trim();

            if (line.isEmpty())
            {
                continue;
            }

            String[] lineContent = line.split(",");

            if (Validation.isValidSightingLine(lineContent))
            {
                int[] animalCounts = new int[6];
                boolean hasNegative = false;

                try
                {
                    for (int i = 0; i < animalCounts.length; i++)
                    {
                        animalCounts[i] = Integer.parseInt(lineContent[i].trim());

                        if (!Validation.isNonNegativeNumber(animalCounts[i]))
                        {
                            hasNegative = true;
                            break;
                        }
                    }

                    if (hasNegative)
                    {
                        System.out.println("Error: Line " + locationNumber + " contains negative values in sighting.txt file.");
                    }
                    else
                    {
                        Location location = new Location(locationNumber);

                        addAnimals(location, SpeciesData.DIPROTODON,  animalCounts[0]);
                        addAnimals(location, SpeciesData.PROCOPTODON, animalCounts[1]);
                        addAnimals(location, SpeciesData.THYLACOLEO,  animalCounts[2]);
                        addAnimals(location, SpeciesData.MEGALANIA,   animalCounts[3]);
                        addAnimals(location, SpeciesData.WONAMBI,     animalCounts[4]);
                        addAnimals(location, SpeciesData.GENYORNIS,   animalCounts[5]);

                        this.locations.add(location);
                    }
                    locationNumber++;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Error: Line " + locationNumber + " contains non-integer values in sighting.txt file.");
                    locationNumber++;
                }
            }
            else
            {
                System.out.println("Error: Line " + locationNumber + " doesn't contain 6 values in sighting.txt file.");
                locationNumber++;
            }
        }

        fileScanner.close();
    }

    /**
    * Method to write Tour summary report to tour.txt file.
    *
    * @param summary the TourSummary object containing simulation results
    * @throws IOException if file cannot be written
    */
    public void writeSummaryToFile(TourSummary summary) throws IOException
    {
        FileWriter fileWriter = new FileWriter(REPORT_FILE);
        PrintWriter writer = new PrintWriter(fileWriter);

        writer.println("****** Megafauna Safari Tour Report ******");
        writer.println(summary.toString());
        System.out.println("\n********* Saving summary Info in file: tour.txt **********");
        System.out.println("\nFile tour.txt created");
        writer.close();
    }
}
