import java.util.Scanner;

/**
 * Input class reads and validates all user input for the safari simulation.
 * It uses a Scanner object to read from the keyboard and delegates
 * validation to the Validation class before returning values.
 *
 * @author Anmol Singh
 * @version 1.0.0
 */
public class Input
{
    private Scanner input;

    /**
    * Default constructor creates a Scanner object for 
    * reading input from the keyboard.
    */
    public Input()
    {
        this.input = new Scanner(System.in);
    }

        /**
    * Method to read and validate entered location choice by user.
    *
    * @param numberOfLocations available locations
    * @return the selected location number
    */
    public int readLocationChoice(int numberOfLocations)
    {
        int choice = 0;

        do
        {
            System.out.print("Choose the next location (1-" + numberOfLocations + "): ");

            if (input.hasNextInt())
            {
                choice = input.nextInt();
                input.nextLine();

                if (!Validation.isValidLocationChoice(choice, numberOfLocations))
                {
                    System.out.println("Error: location choice must be between 1 and " + numberOfLocations);
                }
            }
            else
            {
                String invalidInput = input.next();
                input.nextLine();
                System.out.println("Error: value is not an integer: '" + invalidInput + "'");
            }

        } while (!Validation.isValidLocationChoice(choice, numberOfLocations));

        return choice;
    }

    /**
    * Method to read and validate the number of tourists from the user.
    * 
    *
    * @return the valid number of tourists
    */
    public int readNumberOfTourists()
    {
        int numberOfTourist = 0;

        do
        {
            System.out.print("Enter number of people: ");

            if (input.hasNextInt())
            {
                numberOfTourist = input.nextInt();
                input.nextLine();

                if (!Validation.isValidTouristCount(numberOfTourist))
                {
                    System.out.println("Error: number not in range: 1 to 4");
                }
            }
            else
            {
                String invalidInput = input.next();
                input.nextLine();
                System.out.println("Error: value is not an integer: '" + invalidInput + "'");
            }

        } while (!Validation.isValidTouristCount(numberOfTourist));

        return numberOfTourist;
    }

    /**
    * Method to read and validate the entered tour choice.
    *
    * @return the selected tour number
    */
    public int readTourChoice()
    {
        int choice = 0;

        do
        {
            System.out.print("\nSelect tour: ");

            if (input.hasNextInt())
            {
                choice = input.nextInt();
                input.nextLine();

                if (!Validation.isValidTourChoice(choice))
                {
                    System.out.println("Error: tour choice must be between 1 and 3");
                }
            }
            else
            {
                String invalidInput = input.next();
                input.nextLine();
                System.out.println("Error: value is not a number: '" + invalidInput + "'");
            }

        } while (!Validation.isValidTourChoice(choice));

        return choice;
    }
}
