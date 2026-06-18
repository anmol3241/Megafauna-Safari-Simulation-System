/**
 * Megafauna Meander class is a low-risk type of safari tour.
 * It inherits from Tour class and overrides location suitability..
 *
 *
 * @author Anmol Singh
 * @version 1.0.0
 * @see Tour
 */
public class MegafaunaMeander extends Tour
{
   /**
    * MegafaunaMeander is a low-risk safari tour and a concrete implementation of the Tour class.
    * It defines its own suitability criteria where only locations without Thylacoleo can be visited.
    *
    * @author Anmol Singh
    * @version 1.0.0
    */
    public MegafaunaMeander()
    {
        super("Megafauna Meander", "Low");
    }

    /**
     * Method to determine whether a location is suitable for this tour.
     * A location is only suitable if it contains no Thylacoleo.
     *
     * @param location the location to be checked
     * @return true if no Thylacoleo are present, otherwise false
     */
    public boolean isLocationSuitable(Location location)
    {
        return location.countSpecies(SpeciesData.THYLACOLEO) == 0;
    }
}
