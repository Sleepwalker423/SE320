/**
 * Author: Charles Walker
 * File Name: Task3.java
 * Date: 10/23/2024
 * Purpose: This class is used to perform the third task of assignment 4. Its task description is:
 *      3. Answer the following questions:
 *          a. Write the code to format number 12345.678 in the United Kingdom locale. Keep two digits after the decimal point.
 *          b. Write the code to format number 12345.678 in U.S. currency.
 *          c. Write the code to parse '12,345.678' into a number.
 * Notes to self: 
 * 
 */

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Task3 {
    
    private final double NUMBER = 12345.678;

    private final String numString = "12,345.678";

    private Number numParsed;

    //Different NumberFormat instances used for the tasks a and b. This is due to the NumberFormat class being abstract and requiring the use of its methods
    //that initialize the NumberFormat's specialized child classes. 
    NumberFormat ukNumberFormat = NumberFormat.getNumberInstance(Locale.UK);

    NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

    public void testPrint(){

        //Calls NumberFormat's method to set the max fraction digits.
        ukNumberFormat.setMaximumFractionDigits(2);

        System.out.println("Test number format: "+ ukNumberFormat.format(NUMBER));

        System.out.println("Test currency format: "+ usCurrencyFormat.format(NUMBER));

        parseStringToNum();

        System.out.println("Test String to Number parse: "+ numParsed);

    }

    private void parseStringToNum(){

        NumberFormat numParse = NumberFormat.getNumberInstance();

        try {

            numParsed = numParse.parse(numString);

        }catch(ParseException parseEx) {

            System.out.println("Parse Exception Thrown! Specified string cannot be parsed.");

        }

    }

}
