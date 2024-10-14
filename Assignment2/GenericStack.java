
/**
 * Author: Charles J. Walker
 * File name: GenericStack.java
 * Date: 10/9/2024
 * Programs purpose: This program redesigns the original functionality of a Generic Stack to use an array rather than an array list. It is also designed to 
 * double the size of the array if the user attempts to add an element outside the bounds of the original index size. 
 */
import java.util.EmptyStackException;

public class GenericStack<E>{

    private E[] array;//Declares the array to be used.

    private static final int DEFAULT_SIZE = 10;//The default size used if no size is specified
    
    private int numOfElements;//Tracks the number of elements stored in the array to emulate a typical stack

    private int arraySize;//Tracks the current size of the array.

    //Constructor used if the size is given.
    GenericStack(int size){

        arraySize = size;

        array = (E[]) new Object[arraySize];

    }

    //Constructor used if the size is not given.
    GenericStack(){

        this(DEFAULT_SIZE);

    }

    //Returns the numOfElements variable which tracks the amount of elements stored.
    public int getSize(){

        return numOfElements;

    }

    //Checks to see if the stack is empty by checking the recorded number of elements. I followed Oracle's method
    //of reporting the exception as seen on the source code for the stack class in java util seen at 
    //https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/Stack.java 
    public E peek(){

        if (numOfElements == 0){

            throw new EmptyStackException();

        }

        return array[numOfElements - 1];
    }

    public void push(E newElement){

        if (numOfElements == arraySize){//Checks to see if the size of the array needs to be increased

            increaseArraySize();

        }

        array[numOfElements] = newElement;

        numOfElements++;
    }

    //This method increase the array's size by creating a new array and copying over the contents.
    private void increaseArraySize(){

        E[] temp = (E[]) new Object[arraySize];//Holds the original contents.

        //This format was suggested by the Red Hat extension to replace the for-loop I was using to
        //copy the array. The first array is the source, followed by the starting index for it. The 
        //second array is the destination and is followed by its starting index. The last int in the 
        //argument is the total number of indexes to be copied, which in this case is the current size
        //of the array.
        System.arraycopy(array, 0, temp, 0, temp.length);

        arraySize = arraySize * 2;

        array = (E[]) new Object[arraySize];//Reinitializes the array to the new size.

        //Copies the original contents of the array from temp to the new array. 
        System.arraycopy(temp, 0, array, 0, temp.length);

    }

    //Uses peek() to return the element and reduces the numOfElement
    public E pop(){

        E element = peek();

        numOfElements--;

        return element;
    }

    public boolean isEmpty(){

        boolean empty = false;

        if (numOfElements == 0) empty = true;

        return empty;
    }

    @Override
    public String toString(){

        return "Stack: " + array.toString();
    }

}
