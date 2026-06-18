/**
 * Utility class that provides static validation methods for the safari program.
 * It cannot be instantiated and is used to validate input data throughout the program.
 *
 * @author Anmol Singh
 * @version 1.0.0
 */public class Validation
{
    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private Validation()
    {
    }

    /**
     * Checks if an identity number is valid.
     *
     * @param identity the identity number to validate as an int.
     * @return true if valid, otherwise false.
     */
    public static boolean isValidIdentity(int identity)
    {
        return identity >= 100 && identity <= 999;
    }

    /**
     * Checks if a location number is valid (greater than 0).
     *
     * @param locationNumber the location number to validate as an int.
     * @return true if valid, otherwise false.
     */
    public static boolean isValidLocationNumber(int locationNumber)
    {
        return locationNumber > 0;
    }

    /**
     * Checks if a name is valid (not null and not blank).
     *
     * @param name the name to validate as a String.
     * @return true if valid, otherwise false.
     */
    public static boolean isValidName(String name)
    {
        return name != null && !name.trim().isEmpty();
    }

    /**
     * Checks if an animal type matches a known type constant.
     *
     * @param type the animal type to validate as a String.
     * @return true if valid, otherwise false.
     */
    public static boolean isValidType(String type)
    {
        return type != null &&
            (type.equals(AnimalType.MARSUPIAL) ||
             type.equals(AnimalType.REPTILE) ||
             type.equals(AnimalType.BIRD));
    }
    
    /**
     * Checks if a diet matches a known diet constant.
     *
     * @param diet the diet to validate as a String.
     * @return true if valid, otherwise false.
     */
    public static boolean isValidDiet(String diet)
    {
        return diet != null &&
            (diet.equals(Diet.HERBIVORE) ||
             diet.equals(Diet.CARNIVORE));
    }

    /**
     * Checks if an aggression level matches a known aggression constant.
     *
     * @param aggressionLevel the aggression level to validate as a String.
     * @return true if valid, otherwise false.
     */
    public static boolean isValidAggressionLevel(String aggressionLevel)
    {
        return aggressionLevel != null &&
            (aggressionLevel.equals(AggressionLevel.EXTREME) ||
             aggressionLevel.equals(AggressionLevel.MODERATE) ||
             aggressionLevel.equals(AggressionLevel.PASSIVE) ||
             aggressionLevel.equals(AggressionLevel.NONE)) ||
             aggressionLevel.equals(AggressionLevel.UNKNOWN);
    }

    /**
     * Checks if a species object is not null.
     *
     * @param species the Species object to validate.
     * @return true if not null, otherwise false.
     */
    public static boolean isValidSpecies(Species species)
    {
        return species != null;
    }

    /**
     * Checks if an animal object is not null.
     *
     * @param animal the Animal object to validate.
     * @return true if not null, otherwise false.
     */
    public static boolean isValidAnimal(Animal animal)
    {
        return animal != null;
    }

    /**
     * Checks if a sighting line has the correct number of fields (exactly 6).
     *
     * @param lineContent the parsed sighting line as a String array.
     * @return true if not null and contains 6 elements, otherwise false.
     */
    public static boolean isValidSightingLine(String[] lineContent)
    {
        return lineContent != null && lineContent.length == 6;
    }

    /**
     * Checks if a number is non-negative (zero or greater).
     *
     * @param number the number to validate as an int.
     * @return true if non-negative, otherwise false.
     */
    public static boolean isNonNegativeNumber(int number)
    {
        return number >= 0;
    }

    /**
     * Checks if a tourist count is valid (between 1 and 4 inclusive).
     *
     * @param numberOfTourist the number of tourists to validate as an int.
     * @return true if valid, otherwise false.
     */
    public static boolean isValidTouristCount(int numberOfTourist)
    {
        return numberOfTourist >= 1 && numberOfTourist <= 4;
    }

    /**
     * Checks if a tour choice is valid (between 1 and 3 inclusive).
     *
     * @param choice the tour choice to validate as an int.
     * @return true if valid, otherwise false.
     */
    public static boolean isValidTourChoice(int choice)
    {
        return choice >= 1 && choice <= 3;
    }

    /**
     * Checks if a location choice is within the available range.
     *
     * @param choice the selected location index as an int.
     * @param numberOfLocations the total number of available locations as an int.
     * @return true if valid, otherwise false.
     */
    public static boolean isValidLocationChoice(int choice, int numberOfLocations)
    {
        return choice >= 1 && choice <= numberOfLocations;
    }
}
