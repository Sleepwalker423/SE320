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
 * Each locale class is organized by either language, language and country, or language, country and variant. The locale classes are used by created instances of their specialized child classes. 
 * Every one of the child classes must be initialized using a get method that is passed the version of the locale class used. Specific settings can be passed to these formats using set
 * methods. 
 * 
 * You can use java.text.* and java.util.* to use any child under those hierachies of libraries. 
 * 
 * Using a get instance method without passing a locale causes the class to use the defualt locale which will always be the locale the program is written in. 
 */

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Task3 {
    
    private final double NUMBER = 12345.678;

    private final String numString = "12,345.678";

    private Number numParsed;

    //Initializing the NumberFormats for each tasks. 
    NumberFormat ukNumberFormat = NumberFormat.getNumberInstance(Locale.UK);
    NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
    NumberFormat numParse = NumberFormat.getNumberInstance();

    public void startTask(){

        //Calls NumberFormat's method to set the max fraction digits.
        ukNumberFormat.setMaximumFractionDigits(2);

        System.out.println("Original number: "+ NUMBER);
        System.out.println("UK number format: "+ ukNumberFormat.format(NUMBER));

        System.out.println("US currency format: "+ usCurrencyFormat.format(NUMBER));

        parseStringToNum();

        System.out.println("String to Number parse: "+ numParsed);

    }

    //Parse throws an excpetion that must be handled. The trycatch method is seperated into this method to help in readability. 
    private void parseStringToNum(){

        try {

            numParsed = numParse.parse(numString);

        }catch(ParseException parseEx) {

            System.out.println("Parse Exception Thrown! Specified string cannot be parsed.");

        }

    }

}
