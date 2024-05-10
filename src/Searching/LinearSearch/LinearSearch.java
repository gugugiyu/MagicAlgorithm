package src.Searching.LinearSearch;

import src.Searching.Searchable;

import java.util.ArrayList;

public class LinearSearch implements Searchable {

    /**
     * Searches for the specified value in the ArrayList using linear search algorithm.
     *
     * @param array the ArrayList to be searched
     * @param value the value to search for
     * @return the index of the first occurrence of the specified value in the ArrayList,
     *         or -1 if the value is not found
     */
    public int search(ArrayList<Integer> array, Integer value){
        // Get the length of the array
        int arrayLength = array.size();

        // Iterate through the array elements
        for (int i = 0; i < arrayLength; i++){
            // Check if the current element is equal to the specified value
            if (array.get(i).equals(value)){
                // Return the index if found
                return i;
            }
        }

        // Return -1 if the value is not found
        return -1;
    }
}
