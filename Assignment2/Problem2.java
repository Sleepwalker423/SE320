/**
 * Author: Charles J. Walker
 * File name: Problem2.java
 * Date: 10/9/2024
 * Programs purpose: This program is used to test the functionality of the array list methods. The program's task is to create a list of hard-coded elements and 
 * remove any repeating elements. 
 */
import java.util.ArrayList;

public class Problem2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(14);
        list.add(24);
        list.add(14);
        list.add(42);
        list.add(25);
        //Added the three elements below to further test functionality
        list.add(14);
        list.add(24);
        list.add(42);
        ArrayList<Integer> newList = removeDuplicates(list);
        System.out.print(newList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){

        //Used to track if changes were made.
        int listSize;

        //The do-while loop iterates until there are no repeating objects, which is idicated by no change in the list size.
        do{
            listSize = list.size();//Records the starting size of the list to check if the list is altered.

            for(int i = 0; i < list.size() - 1; i++){

                for(int j = i+1; j < list.size(); j ++){

                    if(list.get(i) == list.get(j)){

                        System.out.printf("Removing index "+ j + " containing "+ list.get(j) +"\n");

                        list.remove(j);

                    }
                }

            }

        }while(listSize != list.size());
        
        return list;
        
    }
}



