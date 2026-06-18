/**
 * GiantsTrail is a medium-risk safari tour and a concrete implementation of the Tour class.
 * It defines its own suitability criteria where any location can be visited.
 *
 * @author Anmol Singh
 * @version 1.0.0
 * @see Tour
 */
public class GiantsTrail extends Tour
{
    /**
     * Constructor initializes Giants Trail tour with medium risk.
     */
    public GiantsTrail()
    {
        super("Giants Trail", "Medium");
    }

    /**
     * Method to determine whether a location is suitable for tour.
     * As GiantsTrail on medium risk locations is suitable for this tour.
     *
     * @param location the location to be checked
     * @return true because any location may be visited
     */
    public boolean isLocationSuitable(Location location)
    {
        return true;
    }
}
