package src.Sorting.SelectionSort;

import src.Sorting.Sortable;
import src.Sorting.Sorting;

import java.util.ArrayList;

public class SelectionSort extends Sorting implements Sortable {
    @Override
    public <T extends Comparable<T>>
    void sort(ArrayList<T> array, boolean isAsc) {
        int arrayLength = array.size();

        //Here, variable i will be used to keep track of the first position (which could be in ascending or descending order)
        for (int i = 0; i < arrayLength - 1; i++){
            //Most smallest or largest element index so far
            int min_idx = i;

            for (int j = i + 1; j < arrayLength; j++){
                if (compareFunction(array.get(j), array.get(min_idx) , isAsc)){
                    //compareFunction is an util function that checks whether this swapping operation should be performed
                    //check its source code at the base class (Sorting.java)
                    min_idx = j;
                }
            }

            swap(array, i, min_idx);
        }

    }
}
