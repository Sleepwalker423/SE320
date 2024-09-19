/**
 * Author: Charles J. Walker
 * File name: Assignment1.java
 * Date: 9/19/2024
 * Programs purpose: This program performs two tasks. The first task takes two integers from the user and
 * displays their sum while checking for invalid input exceptions. The second task creates an array of random numbers
 * and requests an index from the user to display the value at that index while checking for invalid input and index
 * out of bounds exceptions.
 */
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Assignment1 {

    // Constants used in the program
    private static final int MAX_INT = (int) (Math.pow(2, 31) - 1); //Max value of an integer
    private static final int MIN_INT = (int) Math.pow(-2, 31); //Min value of an integer
    private static final int MIN_INDEX = 0;  //Min value of the array index
    private static final int SIZE = 100; //Max size of the array
    
    private static final int[] array = new int[SIZE]; //Array of random numbers used in the RandomArray method
    private static final Scanner scan = new Scanner(System.in); 
    

    public static void main(String[] args) {

        System.out.println("Welcome to Assignment 1 of SE320 Software Construction!");

        Summation();    //Performs the summation portion of the assignment.

        RandomArray();  //Performs the random array portion of the assignment.

        System.out.println("On behalf of Charles J. Walker, we hope you have a great day!");

        scan.close();
        
    }

    //Part one of the assignment. This class is used to sum two integers and display the result.
    private static void Summation(){

        int number1;

        int number2;

        long sumResult; //The sum of the two integers initialized as a long to avoid overflow.

        System.out.println("Enter two integers in the range of " + MIN_INT + " to " + MAX_INT + " to find their sum.");

        number1 = requestNumber("first number", MIN_INT, MAX_INT); // Requests the first number and checks for an exception if the user gives an invalid input.

        System.out.println("Thank you. Now for the second integer.");

        number2 = requestNumber("second number", MIN_INT, MAX_INT); // Requests the second number and checks for an exception if the user gives an invalid input.

        sumResult = (long)number1 + (long)number2; 

        System.out.println("The sum of " + number1 + " and " + number2 + " is " + sumResult + ".");
            
    }

    //Part two of the assignment. This class is used to create an array of random numbers and dispplays the value at a user specified index.
    private static void RandomArray(){

        int value = -1;

        int index = 0;

        createArray();

        System.out.println("Enter an index between "+ MIN_INDEX + " and " + (SIZE - 1) + " to display the value of the array at that index.");

        while(value == -1){//Loops until a valid index is entered.

            index = requestNumber("Chosen index", MIN_INDEX, SIZE - 1); // Requests the index and checks for an exception if the user gives an invalid input.

            value = requestIndex(index); // Checks to ensure that the given index isn't out of bounds.
        }

        System.out.println("The value at index " + index + " is " + value + ".");

    }

    private static void createArray(){ 

        Random rand = new Random();

        for(int i = 0; i < SIZE; i++){
            array[i] = rand.nextInt(MAX_INT);
        }
    }

    // Checks to ensure that the given index isn't out of bounds.
    private static int requestIndex(int index){

        int value;
            
        try {
            
            value = array[index];
            
            return value; //Returns the value at the given index.

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Exception: !" + e + "! Please enter an integer in the range of " + MIN_INDEX + " to " + (SIZE - 1) + ".");

            return -1; //Returns -1 to indicate that the index is out of bounds.
        }
        
    }

    
    // Requests the integer from the user and range checks the input while also catching invalid inputs.
    private static int requestNumber(String message, int min, int max) {

        boolean validInteger = false;
    
        int number = 0;

        while(!validInteger){ // Loop until a valid input is entered.
            
            try {

                System.out.print("Your "+ message +": ");

                number = scan.nextInt(); 

                validInteger = true;

            } catch (InputMismatchException e) {

                System.out.println("!Exception: Out of Bounds! Please enter a valid integer in the range of " + min + " to " + max + ".");

                scan.next(); //Used to avoid infinite loop when an invalid input is entered.

            }
        }
        return number;
    } 
}
