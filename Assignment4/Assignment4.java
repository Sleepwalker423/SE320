/**
 * Author: Charles Walker
 * File Name: Assignment4.java
 * Date: 10/23/2024
 * Purpose: This is the main class for assignment 4 in SE310. Its purpose is to perform the listed
 * tasks below using 3 seperate classes. 
 * 1. Create two linked hash sets {"George", "Jim", "John", "Blake", "Kevin", "Michael"} and 
 *      {"George", "Katie", "Kevin", "Michelle", "Ryan"} and find their union, difference, and 
 *      intersection. (You can clone the sets to preserve the original sets from being changed by 
 *      these set methods.)
 * 2. Write a program that reads words from a text file and displays all the nonduplicate words in 
 *      ascending order. (Use a TreeSet to hold the words)
 * 3. Answer the following questions:
 *      a. Write the code to format number 12345.678 in the United Kingdom locale. Keep two digits after the decimal point.
 *      b. Write the code to format number 12345.678 in U.S. currency.
 *      c. Write the code to parse '12,345.678' into a number.
 * Notes to self: File location: C:\Users\charl\OneDrive\Documents\GitHub\SE320\Assignment4
 */
public class Assignment4 {

    public static void main(String[] args){

        Task1 t1 = new Task1();

        t1.testPrint();
    }
}
