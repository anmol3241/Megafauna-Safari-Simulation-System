/**
 * SpeciesData class stores predefined instances of all safari species.
 * It helps to provide a single access point for all available species.
 *
 * @author Anmol Singh
 * @version 1.0.0
 */
public class SpeciesData
{   
    /**
     * Private constructor prevents object creation.
     */
    private SpeciesData()
    {
    }

    /** 
     * A globally accessible instance of the Diprotodon species. 
     */
    public static final Species DIPROTODON = new Diprotodon();

    /** 
     * A globally accessible instance of the Procoptodon species. 
     */
    public static final Species PROCOPTODON = new Procoptodon();

    /** 
     *A globally accessible instance of the Thylacoleo species. 
     */
    public static final Species THYLACOLEO = new Thylacoleo();

    /**
     * A globally accessible instance of the Megalania species. 
     */
    public static final Species MEGALANIA = new Megalania();

    /**
     * A globally accessible instance of the Wonambi species. 
     */
    public static final Species WONAMBI = new Wonambi();

    /** 
     *A globally accessible instance of the Genyornis species. 
     */
    public static final Species GENYORNIS = new Genyornis();
}
