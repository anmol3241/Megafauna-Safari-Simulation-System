/**
 * RandomSafariEvent generates random outcomes for events during the safari simulation.
 * It determines whether animals are spotted, whether predators attack,
 * and the outcome of a predator attack on a tourist.
 *
 * @author Anmol Singh
 * @version 1.0.2
 */
public class RandomSafariEvent
{
    /**
     * Default constructor initializes a RandomSafariEvent object.
     */
    public RandomSafariEvent()
    {
    }
 
    /**
     * Method returns true if an animal is spotted by the tourists.
     * Each animal has a 50% chance of being spotted.
     *
     * @return true if the animal is spotted
     */
    public boolean isAnimalSpotted()
    {
        return Math.random() < 0.50;
    }
 
    /**
     * Method returns true if a spotted predator attacks a tourist.
     * Attack probability depends on the predator's aggression level:
     *
     *
     * @param aggressionLevel the aggression level string of the predator
     * @return true if the predator attacks
     */
    public boolean doesPredatorAttack(String aggressionLevel)
    {
        if (aggressionLevel == null)
        {
            return false;
        }
    
        //If AggressionLevel is extreme probability of attactck is 10%.
        if (aggressionLevel.equals(AggressionLevel.EXTREME))
        {
            return Math.random() < 0.10;
        }
        //If AggressionLevel is moderate probability of attactck is 5%.
        else if (aggressionLevel.equals(AggressionLevel.MODERATE))
        {
            return Math.random() < 0.05;
        }
        //If AggressionLevel is passive probability of attactck is 1%.
        else if (aggressionLevel.equals(AggressionLevel.PASSIVE))
        {
            return Math.random() < 0.01;
        }
 
        return false;
    }
 
    /**
     * Returns a random integer between 0 and 99 to determine
     * the outcome of a predator attack on a tourist.
     *
     *  Minor injury: tourist continues(0-14).
     *  Major injury: tourist leaves the tour(15-79).
     *  Tourist death: tour stops immediately(80-99).
     *
     * @return random integer in range [0, 99]
     */
    public int getInjuryOutcome()
    {
        return (int)(Math.random() * 100);
    }
}
