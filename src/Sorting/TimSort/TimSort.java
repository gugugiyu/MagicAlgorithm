package src.Sorting.TimSort;

import src.Sorting.Sortable;
import src.Sorting.Sorting;

import src.Sorting.MergeSort.MergeSort;

import java.util.ArrayList;

public class TimSort extends Sorting implements Sortable {
    // Let's first decide our run size
    static final int MIN_RUN_SIZE = 4;

    @Override
    public <T extends Comparable<T>>
    void sort(ArrayList<T> array, boolean isAsc) {
        // Due to the nature of insertion sort to perform better with small dataset, we'll be utilizing in this
        // sorting algorithm

        // First of all, we need to sort the array by runs
        int arrayLength = array.size();
        MergeSort mergeSort = new MergeSort();

        for (int i = 0; i < arrayLength; i+= MIN_RUN_SIZE){
            // Since our array can't probably be divided into equally run size
            // Say our run size is 5, and the arrayLength is 23, hence making the last run only have 3 elements.
            // So we'll have to use Math.min to actually select the right size for it

            int right = Math.min(i + MIN_RUN_SIZE, arrayLength);
            insertionSort(array, i, right, isAsc);
        }

        // And now the merging part
        // This outer loop works like finalizer of runSize. It will double it size every iteration after merging the two sub array that has been
        // sorted, allowing it the merging the bigger and bigger chunks together
        for (int runSize = MIN_RUN_SIZE; runSize < arrayLength; runSize *= 2){
            for (int i = 0; i < arrayLength; i += 2 * runSize){
                int mid = i + runSize - 1;
                int right = Math.min(i + 2 * runSize, arrayLength) - 1;

                if (mid < right)
                    mergeSort.merge(array, isAsc, i, mid, right);
            }
        }
    }

    /**
     * Reimplement the insertion sort for this algorithm so that it only sort a certain part of our array
     */

    private <T extends Comparable<T>>
    void insertionSort(ArrayList<T> array, int left, int right, boolean isAsc){
        for (int i = left + 1; i < right; i++){
            T value = array.get(i);

            //The copy of the current iterator so we can iterate backward and check those previous elements
            int j = i - 1;

            while (j >= left && compareFunction(array.get(j), value, isAsc)){
                array.set(j + 1, array.get(j));
                j--;
            }

            array.set(j + 1, value);
        }
    }
}
