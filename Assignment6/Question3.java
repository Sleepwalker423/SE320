/*
 * Author: Charles J. Walker
 * Date: 12/11/24
 * File Name: BMI_Client.java 
 * Purpose: This program is part 3 of 3 for Assignment 6 in SE320. It requires us to implement a generic method when given its skeleton.
 */

/**
 * Takes a list and a key. Returns the first index value if the key is found in the array or returns -1 if not found or if the array contains a null element.
 * 
 * @param Must be given an array and a key of the same Wrapper class types, or an array and a key of the same type with properly implemented compareTo methods. 
 * @return Returns the index value, int i, of where the key was found in the array or -1 if the value is not found, the array is null, the element is null, or the array contains a null element.
 */
public class Question3 {
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
    //INSERT YOUR IMPLEMENTATION HERE
        if(list == null || key == null) return -1;//Ends the program if the array or key are null. 
        for (E element : list) {//Checks for null elements.
            if (element == null) {
                return -1;
            }
        }

        for (int i = 0; i < list.length; i++){
            
            if (list[i].compareTo(key) == 0){
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Integer[] list = {3, null, 5, 1, -3, -5, -1};
        System.out.println(linearSearch(list, 2));
        System.out.println(linearSearch(list, 5));
    }
}

