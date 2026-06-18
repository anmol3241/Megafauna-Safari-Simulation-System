/**
 * Tourist class represents a tourist participating in the safari simulation.
 * It stores the tourist's ID, alive status, and injury status.
 *
 * @author Anmol Singh
 * @version 1.0.2
 */
public class Tourist
{
    private int touristId;
    private boolean alive;
    private String injuryStatus;
 
    /**
     * Default constructor initialises a Tourist with default values.
     * Tourist is alive with no injuries and ID set to 0.
     */
    public Tourist()
    {
        this.touristId = 0;
        this.alive = true;
        this.injuryStatus = "none";
    }
 
    /**
     * Parameterized constructor initialises a Tourist with the given ID.
     * Tourist is alive with no injuries.
     *
     * @param touristId the unique positive integer ID of the tourist
     */
    public Tourist(int touristId)
    {
        setTouristId(touristId);
        this.alive = true;
        this.injuryStatus = "none";
    }
 
    /**
     * Accessor method returns the tourist's ID.
     *
     * @return the tourist's ID as a positive integer
     */
    public int getTouristId()
    {
        return this.touristId;
    }

    /**
     * Accessor method returns the tourist's injury status.
     *
     * @return "none", "minor", or "major" as per tourist's injury
     */
    public String getInjuryStatus()
    {
        return this.injuryStatus;
    }
 
    /**
     * Accessor method returns whether the tourist is alive.
     *
     * @return true if the tourist is alive, false if they have been killed
     */
    public boolean isAlive()
    {
        return this.alive;
    }
 
    /**
     * Method to apply a minor injury to the tourist.
     *
     */
    public void inflictMinorInjury()
    {
        setInjuryStatus("minor");
    }
 
    /**
     * Method to apply a major injury to the tourist.
     *
     */
    public void inflictMajorInjury()
    {
        setInjuryStatus("major");
    }
 
    /**
     * Method to kill the tourist by setting their alive status to false.
     *
     */
    public void kill()
    {
        setAlive(false);
    }
 
    /**
     * Mutator method sets the tourist's alive status.
     *
     * @param alive true if tourist is alive, false otherwise
     */
    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }
 
    /**
     * Mutator method sets the tourist's injury status.
     * Only {@code "none"}, {@code "minor"}, or {@code "major"} are valid values.
     *
     * @param injuryStatus the injury status string
     */
    public void setInjuryStatus(String injuryStatus)
    {
        if (injuryStatus != null &&
            (injuryStatus.equals("minor") ||
             injuryStatus.equals("major")))
        {
            this.injuryStatus = injuryStatus;
        }
        else
        {
            this.injuryStatus = "none";
        }
    }
 
    /**
     * Mutator method sets the tourist's ID.
     * If the ID is not a positive integer, it defaults to 0.
     *
     * @param touristId a positive integer ID
     */
    public void setTouristId(int touristId)
    {
        if (touristId > 0)
        {
            this.touristId = touristId;
        }
        else
        {
            this.touristId = 0;
        }
    }
 
    /**
     * Returns the tourist's details as a formatted String.
     *
     * @return a String containing the tourist's ID, alive status, and injury status
     */
    public String toString()
    {
        return "Tourist ID: " + this.touristId +
               "\n\tAlive: " + (this.alive ? "Yes" : "No") +
               "\n\tInjury Status: " + this.injuryStatus;
    }
}
 
