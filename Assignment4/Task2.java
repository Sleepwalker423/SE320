/**
 * Author: Charles Walker
 * File Name: Task2.java
 * Date: 10/23/2024
 * Purpose: This class is used to perform the second task of assignment 4. Its task description is:
 *       2. Write a program that reads words from a text file and displays all the nonduplicate words in 
 *          ascending order. (Use a TreeSet to hold the words)
 * Notes to self: 
 * TreeSet class documentation can be found at: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/TreeSet.html
 * 
 * TreeSet
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

public class Task2 {

    private TreeSet<String> wordSet = new TreeSet<>();
	private String[] words;

    String allWords = "";

    public Task2(){

        readFile();

    }

    private void readFile() {

        String fileName = "Words.txt";

        //This try-catch block with resources initializes the instances of FileReader and BufferedReader needed
        //to read the random words from the file.
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            //Adds all lines read to a single string
            while (( line = br.readLine()) != null) {

                System.out.println("Test read file: "+ line);

                allWords += line; 

            }

        } catch (IOException e) {

            System.err.println("Error reading file: " + e.getMessage());

        }

        //The \\s+ is used to represent one or more white spaces. the double \ is needed for the regular expression engine to identify the \s 
        //which is an expression that means space. Similar to \t being tab and \n new line. The + is what identifies that it will be one or more
        //white space. More info on regex found at: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/regex/package-summary.html
        words = allWords.split("\\s+"); 

        //I orginally used for(String s: words) but I recieved the following suggestion through the IDE (Redhat I think): "Manual array copy to 
        //Collection(hints(5): 52:9-52:12)" and this is what it suggest because its supposed to be more effecient. 
        wordSet.addAll(Arrays.asList(words));

    }

    public void testPrint(){

        System.out.println("Original input from the file: "+ Arrays.toString(words) + "\n");

        System.out.println("After passing to the tree set: "+ wordSet);

    }


}

