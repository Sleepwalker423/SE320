/**
 * Author: Charles Walker
 * File Name: Task2.java
 * Date: 10/23/2024
 * Purpose: This class is used to perform the second task of assignment 4. Its task description is:
 *       2. Write a program that reads words from a text file and displays all the nonduplicate words in 
 *          ascending order. (Use a TreeSet to hold the words)
 * 
 * Notes to self: 
 * TreeSet class documentation can be found at: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/TreeSet.html
 * 
 * TreeSet has a constructor that builds the tree set using any class from the Collections hierarchy.
 * 
 * I was getting words with null added to the beginning of them. If you don't initialize a String with "" it will contain null which will concatenate with any word added to it. 
 * 
 * I tried to bypass passing the words from a string, to a string array, to a list, then to a tree set but I could not find an effective way
 * to go from the string to a list without doing so.
 * 
 * (After testing with " " in lieue of \\s+, I found that it still works with my use. I'm keeping this explanation for later reference)
 * Regarding the split(): The \\s+ is used to represent one or more white spaces. the double \ is needed for the regular expression engine to identify the \s 
 * which is an expression that means space. Similar to \t being tab and \n new line. The + is what identifies that it will be one or more
 * white spaces. More info on regex found at: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/regex/package-summary.html 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

public class Task2 {

    private TreeSet<String> wordSet;//Holds the final set of words.
	private String[] words;//Holds the initial set of words from Words.txt with repeats.

    String allWords = "";//Holds all lines as they are read. "" prevents null concatenation 

    //Constructor reads from the file and creates the tree set.
    public Task2(){

        readFile();

        //split is a string method that takes a string and returns a string array containing the words
        //as elements. 
        words = allWords.split(" "); 

        //I kept the below code as a reminder this is an alternative way of accomplishing the same thing.
        //I orginally used for(String s: words) but I recieved the following suggestion through the IDE (Redhat I think): "Manual array copy to 
        //Collection(hints(5): 52:9-52:12)" and this is what it suggests to use because its supposed to be more effecient. 
        //wordSet.addAll(Arrays.asList(words));

        //The method initializes the tree set using the constructor that takes any class in the collections hierarchy (which is why the Arrays.
        //asList() method is called). 
        wordSet = new TreeSet<>(Arrays.asList(words));

    }

    private void readFile() {

        String fileName = "Words.txt";

        //This try-catch block with resources initializes the instances of FileReader and BufferedReader needed
        //to read the random words from the file.
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            //Adds all lines read to a single string.
            while (( line = br.readLine()) != null) {

                //System.out.println("Test read file: "+ line);

                allWords += line; 

            }

        } catch (IOException e) {//REminder: Catches all children of the IOException class

            System.err.println("Error reading file: " + e.getMessage());

        }

    }

    public void startTask(){

        System.out.println("Original input from the file: "+ Arrays.toString(words));

        System.out.println("After passing to the tree set: "+ wordSet+ "\n");

    }


}

