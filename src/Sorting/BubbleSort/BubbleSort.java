package src.Sorting.BubbleSort;

import src.Sorting.Sortable;
import src.Sorting.Sorting;

import java.util.ArrayList;

public class BubbleSort extends Sorting implements Sortable {
    @Override
    public  <T extends Comparable<T>> void sort(ArrayList<T> array, boolean isAsc) {
        int arrayLength = array.size();

        // The inner for loop only loops to len - 1 to prevent overflow as we compare the element and its forward neighbor
        for (int i = 0; i < arrayLength; i++){
            for (int j = 0; j < arrayLength - i -  1; j++){

                //Here's the "bubble part", by comparing two adjacent elements, we make sure the the smaller / largest value will
                //"float" to either sides of the array one by one
                if (compareFunction(array.get(j), array.get(j + 1), isAsc)){
                    //compareFunction is an util function that checks whether this swapping operation should be performed
                    //check its source code at the base class (Sorting.java)
                    swap(array, j, j + 1);
                }
            }
        }
    }
}
