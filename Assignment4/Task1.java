/**
 * Author: Charles Walker
 * File Name: Task1.java
 * Date: 10/23/2024
 * Purpose: This class is used to perform the first task of assignment 4. Its task description is:
 *      1. Create two linked hash sets {"George", "Jim", "John", "Blake", "Kevin", "Michael"} and 
 *      {"George", "Katie", "Kevin", "Michelle", "Ryan"} and find their union, difference, and 
 *      intersection. (You can clone the sets to preserve the original sets from being changed by 
 *      these set methods.)
 * 
 * Notes to self: 
 * Use addAll() for union, removeAll() for difference, and retainAll() for intersection.
 * 
 * All of these methods are inherited from the Set interface. 
 * 
 * LinkedHashSet class documentation: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedHashSet.html
 * 
 * The LinkedHashSet class has a constructor (LinkedHashSet(Collection<? extends E> c)) that can take any child of the 
 * collection hierarchy. Testing confirms that this creates a deep clone of the original, but I can't find source
 * code showing how this is performed. 
 * 
 * A set containing only the elements that are present in A or B but not both is called a symmetric difference.
 */

import java.util.LinkedHashSet;

public class Task1 {

    //Initialize two LinkedHashSets to hold the names
    LinkedHashSet<String> names1  = new LinkedHashSet<>();
    LinkedHashSet<String> names2  = new LinkedHashSet<>();

    //Declares three LinkedHashSets to hold the changed sets
    LinkedHashSet<String> union;
    LinkedHashSet<String> difference1;//Will contain the difference from Names1 compared to Names2
    LinkedHashSet<String> difference2;//Will contain the difference from Names2 compared to Names1
    LinkedHashSet<String> intersection;



    //Constructor adds names to the original LinkedHashSets;
    public Task1(){

        names1.add("George");
        names1.add("Jim");
        names1.add("John");
        names1.add("Blake");
        names1.add("Kevin");
        names1.add("Michael");

        names2.add("George");
        names2.add("Katie");
        names2.add("Kevin");
        names2.add("Michelle");
        names2.add("Ryan");

    }

    public void createUnion(){

        union = new LinkedHashSet<>(names1);

        union.addAll(names2);
    }

    //Each set is loaded with the opposite set and differenced with the other to show the difference form both 
    //perspectives. 
    public void createDifference(){

        difference1 = new LinkedHashSet<>(names1);

        difference2 = new LinkedHashSet<>(names2);

        difference1.removeAll(names2);

        difference2.removeAll(names1);
    }

    public void createIntersection(){

        intersection = new LinkedHashSet<>(names1);

        intersection.retainAll(names2);
    }

    public void startTask(){

        //This statement is used to ensure the originals remain unchanged in initial testing.
        System.out.println("Names1: " + names1 + "\nNames2: " + names2 + "\n");

        createUnion();

        System.out.println("Union: " + union + "\n");

        createDifference();

        System.out.println("Difference of Names1 from Names2: " + difference1 + "\n");

        System.out.println("Difference of Names2 from Names1: " + difference2 + "\n");

        createIntersection();

        System.out.println("Intersection: " + intersection + "\n");

        //This print statement is used to ensure the originals remain unchanged.
        System.out.println("Names1: " + names1 + "\nNames2: " + names2 + "\n");
        
    }
}
