import java.util;

package assign2;

/**
 * Connor Richards
 * Assignment 2
 * Class ID: 137
 * Description: This file contains the class SimpleList. The class represents a list and provides
 * methods such as add, remove, count, search, and toString to allow operations and visualization of the list.
 **/

public class SimpleList {
    /**
     *  The array of numbers representing the SimpleList
     */
    private int[] list;

    /**
     * The count of how many numbers are currently inside the list
     */
    private int count;

    /**
     * Class constructor
     **/
    public SimpleList() {
        //Initialize class members
        list = new int[10];
        count = 0;
    }

    /**
     * Adds an element to the list.
     * May need to shift elements down the list to make room, or
     * remove the last element in the list to ensure there is space.
     * @param num the number to be added to the list
     */
    public void add(int num) {
        if(count == list.length) {
            increaseListSize();
        }
        for(int index = count - 1; index >= 0; index--) {
            list[index + 1] = list[index];    // Shift elements to the right
        }
        count++;
        list[0] = num;  //add element to list
    }

    /**
     * Removes an element from the list.
     * May need to shift elements up the list to fill the empty space.
     * @param num the number to be removed from the list
     */
    public void remove(int num) {
        int indexToRemove = search(num);    // Find the index of where to remove the element

        boolean foundEleToRemove = false;
        for(int index = 0; index < count; index++) {
            if(foundEleToRemove) {
                if(index + 1 == list.length) {
                    //Handle index out of bounds exception
                    list[index] = 0;

                } else {
                    //Shift elements
                    list[index] = list[index + 1];
                }
            }
            if(index == indexToRemove) {
                foundEleToRemove = true;
                list[index] = list[index + 1];    //start shifting elements to remove param number
            }
        }
        if(foundEleToRemove) count--;

        if(search(num) != -1) remove(num);      //remove all occurrences

        //Check how many spots are empty
        if(count < list.length * 3/4) {
            list = Arrays.copyOf(list, list.length * 3/4);
        }
    }

    /**
     * Returns the number of numbers in the list
     * @return the number of elements in the list
     */
    public int count() {
        return count;
    }

    /**
     * Returns a string representation of the list of numbers, separated by a space
     * @return the string representing the list
     */
    public String toString() {
        if(count == 0) return "";   //empty list case
        String str = "";
        for(int index = 0; index < count; index++) {
            str += list[index];
            str += " ";
        }
        return str.substring(0, str.length() - 1);      //cut off the last space
    }

    /**
     * Searches through the list and returns the index where the param num is located
     * @param num the number to search for in the list
     * @return the index where the number is found in the list
     */
    public int search(int num) {
        int foundIndex = -1;
        boolean foundNum = false;
        for(int index = 0; index < count; index++) {
            if(!foundNum){                          //this extra check ensures we return the first occurrence of the param num
                if(list[index] == num) {
                    foundIndex = index;
                    foundNum = true;
                }
            }
        }
        return foundIndex;
    }

    /**
     * Appends a num to the list
     @param num the number to add
     */
    public void append(int num) {
        if(count == list.length) {
            increaseListSize();
        }
        list[count] = num;
        count++;
    }

    /**
     * Returns first num in list
     * @return First number in list
     */ 
    public int first() {
        return list[0];
    }

    /**
     * Returns number of empty spots in list
     * @return number of empty spaces in the list
     */
    public int size() {
        return list.length - count;
    }

    /**
    * Increases the list size by 50%
     */
    private void increaseListSize() {
       list = Arrays.copyOf(list, list.length + list.length / 2)
    }

    //**** HELPER METHOD DELETE BEFORE SUBMIT *****//
    public int[] getList() {
        return list;
    }
}
