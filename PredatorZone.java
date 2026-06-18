/**
 * PredatorZone is a high-risk safari tour and a concrete implementation of the Tour class.
 * It defines its own suitability criteria where only locations with predator species can be visited.
 *
 * @author Anmol Singh
 * @version 1.0.0
 * @see Tour
 */
public class PredatorZone extends Tour
{
    /**
     * Constructor initializes Predator Zone tour with high risk.
     */
    public PredatorZone()
    {
        super("Predator Zone", "High");
    }

    /**
     * Method to determine whether a location is suitable for this tour.
     * A location is suitable if it contains at least one Thylacoleo,
     * Megalania, or a Wonambi.
     *
     * @param location the location to be checked
     * @return true if any predator species is present, otherwise false
     */
    public boolean isLocationSuitable(Location location)
    {
        return location.countSpecies(SpeciesData.THYLACOLEO) > 0 || location.countSpecies(SpeciesData.MEGALANIA) > 0 || location.countSpecies(SpeciesData.WONAMBI) > 0;
    }
}
