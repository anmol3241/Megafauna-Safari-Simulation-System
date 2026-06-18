/**
 * Test class for Animal class.
 *
 * @author Anmol Singh
 * @version 1.0.2
 */
public class AnimalTest
{
    /**
     * Default constructor for AnimalTest.
     */
    public AnimalTest()
    {

    }

    /**
     * Main method creates an AnimalTest object and runs all test cases.
     *
     * @param args an array of Strings representing command line arguments.
     */
    public static void main(String[] args)
    {
        AnimalTest test = new AnimalTest();
        test.runTest();
    }

    /**
     * Runs required test cases for the Animal class.
     * Tests include valid and invalid data for constructors,
     * accessors, mutators, and toString method.
     */
    public void runTest()
    {
        Species species = new Thylacoleo();

        System.out.println("\nTest Case 1: Default Constructor    ------Animal animal1 = new Animal()");
        Animal animal1 = new Animal();
        System.out.println(animal1);

        System.out.println("\nTest Case 2a: Parameterized Constructor for valid fields   ------Animal animal2 = new Animal(111, species, true, false)");
        Animal animal2 = new Animal(111, species, true, false);
        System.out.println(animal2);

        System.out.println("\nTest Case 2b: Parameterized Constructor for invalid fields  ------Animal animal3 = new Animal(99, species, true, false)");
        Animal animal3 = new Animal(99, species, true, false);
        System.out.println(animal3);

        System.out.println("\nTest Case 3a: getIdentity() for valid value:  ------Using animal2 object");
        System.out.println(animal2.getIdentity());

        System.out.println("\nTest Case 3b: getIdentity() for invalid value:    ------Using animal1 object");
        System.out.println(animal1.getIdentity());

        System.out.println("\nTest Case 4a: setIdentity(100) for valid value:     ------animal1.setIdentity(100)");
        animal1.setIdentity(100);
        System.out.println(animal1.getIdentity()); 

         System.out.println("\nTest Case 4b: setIdentity(-100) for invalid value:    -------animal1.setIdentity(-100)");
        animal1.setIdentity(-100);
        System.out.println(animal1.getIdentity());

        System.out.println("\nTest Case 5: toString():");
        System.out.println(animal2.toString());
    }
}
