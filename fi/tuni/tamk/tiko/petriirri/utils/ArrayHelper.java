package fi.tuni.tamk.tiko.petriirri.utils;

/**
* ArrayHelper contains methods which help in handling of arrays.
*
* The methods in this program are used to: create, print and search
* given arrays. 
*
*@author Petri Irri
*@version 1.0
*@since 2020-10-20
*/
public class ArrayHelper {
    /**
    * Creates a new empty array with the given number of indexes.
    *
    *@param numOfIndexes is the number of indexes the array should have
    *@return returns an empty array with the given number of indexes
    */
    public static int [] createLottoArray(int numOfIndexes) {
        int [] userNumbers = new int [numOfIndexes];
        return userNumbers;
    }
    /**
    * Checks if an array contains a given number.
    *
    * The method loops through the given array and searches for
    * matches with the given value. if the value is found in the array
    * returns true.
    *
    *@param array is the array which we want to search
    *@param value is the value to be searched for in the given array
    *@return returns a boolean value depending if the number was found
    */
    public static boolean arrayContains(int [] array, int value) {
        boolean output = false;
        //loop through the array
        for(int i = 0; i < array.length; i++) {
            if(array[i] == value) {
                output = true;
            }
        }
        return output;
    }
    /**
    * Prints the given integer array.
    *
    *@param array is the array to be printed
    */
    public static void printArray(int [] array) {
        for(int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    /**
    * Sorts the given array to an ascending order.
    *
    * The array sorted by comparing the current index to all the
    * other indexes.
    *
    *@param array is the array to be sorted
    *@return returns the given array sorted
    */
    public static int [] sortArray(int [] array) {
        for(int i = 0; i < array.length; i++) {
            int smallest = array[i];
            int indexOfSmallest = i;
            for(int j = i; j < array.length; j++) {
                if(smallest > array[j]) {
                    smallest = array[j];
                    indexOfSmallest = j;
                }
            }
            array[indexOfSmallest] = array[i];
            array[i] = smallest;
        }
        return array;
    }
    /**
    * Fills the given array with numbers between 1 and array length.
    *
    *@param array is the array to be filled with numbers
    *@return returns the array filled with numbers
    */
    public static int [] fillArray(int [] array) {
        for(int i = 1; i <= array.length; i++) {
                array[i - 1] = i;
        }
        return array;
    }
    /**
    * Removes one index in the given array.
    *
    * Method starts by creating a new array to which we save numbers from the 
    * given array. The numbers are saved if their index is not the same as the
    * index we want to be removed. if the index is the same we want to be removed
    * we wont save the number to the new array.
    *
    *@param array is the given array from which we want to remove an index
    *@param index is the index which we want to be removed
    *@return returns new array without the index we wanted to remove
    */
    public static int [] removeIndex(int [] array, int index) {
        int [] newArray = new int [array.length - 1];
        int i = 0;//the index of the given array
        int j = 0;//the index of the new array
        while(i < array.length) {
            if(i == index) {
                i++;
            } else{
                newArray[j] = array[i];
                i++;
                j++;
            }
        }
        return newArray;
    }
    /**
    * Transforms String array to int array.
    *
    * Creates a new int array to which we parse the contents of
    * the string array.
    *
    *@param array is the array to be converted to int array
    *@return returns the converted array
    */
    public static int [] stringArrayToInt(String [] array) {
        int [] intArray = new int [array.length];
        //loop through the array and convert it to int
        for(int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }
}