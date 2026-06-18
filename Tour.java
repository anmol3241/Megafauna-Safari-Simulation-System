/**
 * Abstract Tour class represents a safari tour in the simulation.
 * It stores the tour type and risk level, and defines suitability
 * criteria to be implemented by each concrete subclass.
 *
 * @author Anmol Singh
 * @version 1.0.0
 */
public abstract class Tour
{
    /**
    * Stores type of tour.
    */
    protected String tourType;

    /**
    * Stores the risk level of the tour.
    */
    protected String riskLevel;

    /**
    * Default constructor initializes the tour with default values.
    * 
    */
    public Tour()
    {
        tourType = "unknown";
        riskLevel = "unknown";
    }

    /**
    * Parameterized constructor initializes a tour with the specified 
    * tour type and risk level.
    *
    * @param tourType the name of the tour as String.
    * @param riskLevel the risk level of the tour as String.
    */
    public Tour(String tourType, String riskLevel)
    {
        this.tourType = tourType;
        this.riskLevel = riskLevel;
    }

    /**
    * Accessor method to return the risk level of the tour.
    *
    * @return the tour risk level as String.
    */
    public String getRiskLevel()
    {
        return this.riskLevel;
    }

    /**
    * Accessor method to return the type of the tour.
    *
    * @return the tour type as String.
    */
    public String getTourType()
    {
        return this.tourType;
    }
    
    /**
    * Abstract method to determine the location according to Tour.
    *
    *
    * @param location the location to be checked
    * @return true if the location can be visited, otherwise false
    */
    public abstract boolean isLocationSuitable(Location location);

    /**
    * Mutator method to set the risk level of the tour.
    *
    * @param riskLevel the risk level to assign, a String.
    */
    public void setRiskLevel(String riskLevel)
    {
        this.riskLevel = riskLevel;
    }

    /**
    * Mutator method to set the type of the tour.
    *
    * @param tourType the tour type to assign, a String.
    */
    public void setTourType(String tourType)
    {
        this.tourType = tourType;
    }

    /**
    * To String method to return the tour details as a formatted String.
    *
    * @return a String containing the tour details
    */
    public String toString()
    {
        return "\nTour Details: " +
               "\n\tTour Type: " + this.tourType + 
               "\n\tRisk Level" + this.riskLevel;
    }
}




