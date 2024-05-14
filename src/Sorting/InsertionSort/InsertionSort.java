package src.Sorting.InsertionSort;

import src.Sorting.Sortable;
import src.Sorting.Sorting;

import java.util.ArrayList;

public class InsertionSort extends Sorting implements Sortable {
    @Override
    public <T extends Comparable<T>>
    void sort(ArrayList<T> array, boolean isAsc) {
        // We start from the second element, as the first one is assumed to be already sorted
        int arrayLength = array.size();

        for (int i = 1; i < arrayLength; i++){
            T value = array.get(i);

            //The a copy of the current iterator so we can iterate backward and check those previous elements
            int j = i - 1;

            while (j >= 0 && compareFunction(array.get(j), value, isAsc)){
                //compareFunction is an util function that checks whether this swapping operation should be performed
                //check its source code at the base class (Sorting.java)
                array.set(j + 1, array.get(j));
                j--;
            }

            //The reason why we have to set value at j + 1 instead of j is that in the previous while loop
            //We end it with "j--", which means that our j will be offset 1 index behind our insert location
            //So we need to add j + 1 to compensate for it
            array.set(j + 1, value);
        }
    }
}
