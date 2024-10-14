
/**
 * Author: Charles J. Walker
 * File name: Problem3.java
 * Date: 10/9/2024
 * Programs purpose: This program is used to test the functionality of the assert class. It requests an input from the user and asserts the the value
 * is within a given range. 
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem3{

    //Limits for the user input check
    private static final int MAX_NUMBER = 10; 
    private static final int MIN_NUMBER = 0;

    private static void main(String[] args) {
        
        int userNumber;

        System.out.printf("Please enter a number in the range of 0 to 10.\n");

        userNumber = getNumber();

        assert userNumber >= MIN_NUMBER && userNumber <= MAX_NUMBER: "The number is not within range";

    }

    //Uses a try-catch with resources to get the user input and catch any invalid input exceptions
    public static int getNumber(){

        int input = -1;

        try(Scanner scan = new Scanner(System.in)){

            input = scan.nextInt();

        }catch(InputMismatchException e){

            System.out.printf("!EXCEPTION! Invalid input given. System is terminating.");

        }

        return input;
        
    }
}
