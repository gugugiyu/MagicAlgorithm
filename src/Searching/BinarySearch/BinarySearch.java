package src.Searching.BinarySearch;

import src.Searching.Searchable;

import java.util.ArrayList;

public class BinarySearch implements Searchable {

    /**
     * Searches for the specified value in the ArrayList using binary search algorithm.
     *
     * @param array the ArrayList to be searched (must be sorted in ascending order)
     * @param value the value to search for
     * @return the index of the first occurrence of the specified value in the ArrayList,
     *         or -1 if the value is not found
     */
    public int search(ArrayList<Integer> array, Integer value){
        // Delegate the search to the recursive implementation method
        // Switch the approach here
        return search__recursion_impl(array, value, 0, array.size() - 1);
        // return search__iteration_impl(array, value, 0, array.size() - 1);
    }

    /**
     * Recursively performs binary search on the specified sub-array of the ArrayList.
     *
     * @param array the ArrayList being searched
     * @param value the value to search for
     * @param left the left boundary of the sub-array being searched
     * @param right the right boundary of the sub-array being searched
     * @return the index of the first occurrence of the specified value in the sub-array,
     *         or -1 if the value is not found
     */
    private int search__recursion_impl(ArrayList<Integer> array, Integer value, int left, int right){
        // Base case: If the left boundary exceeds the right boundary, the value is not found
        if (left > right){
            return -1;
        }

        // Calculate the middle index of the sub-array
        int mid = (left + right) / 2;

        // If the value is greater than the middle element, search the right half
        if (value > array.get(mid)){
            return search__recursion_impl(array, value, mid + 1, right);
        }
        // If the value is less than the middle element, search the left half
        else if (value < array.get(mid)){
            return search__recursion_impl(array, value, left, mid - 1);
        }
        // If the value is equal to the middle element, return its index
        else{
            return mid;
        }
    }

    /**
     * Iteratively performs binary search with a while loop
     *
     * @param array the ArrayList being searched
     * @param value the value to search for
     * @param left the left boundary of the sub-array being searched
     * @param right the right boundary of the sub-array being searched
     * @return the index of the first occurrence of the specified value
     *         or -1 if the value is not found
     */
    private int search__iteration_impl(ArrayList<Integer> array, Integer value, int left, int right){
        while (left < right){
            int mid = (left + right) / 2;

            // If the value is greater than the middle element, search the right half
            if (value > array.get(mid)){
                left = mid + 1;
            }
            // If the value is less than the middle element, search the left half
            else if (value < array.get(mid)){
                right = mid - 1;
            }
            // If the value is equal to the middle element, return its index
            else{
                return mid;
            }
        }

        //If the value doesn't exist
        return -1;
    }
}
