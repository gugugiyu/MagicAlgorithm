package src.Sorting.QuickSort;

import src.Sorting.Sortable;
import src.Sorting.Sorting;

import java.util.ArrayList;

public class QuickSort extends Sorting implements Sortable {
    @Override
    public <T extends Comparable<T>>
    void sort(ArrayList<T> array, boolean isAsc) {
        int left = 0;
        int right = array.size() - 1;

        sort__recursive_imple(array, left, right, isAsc);
    }

    public <T extends Comparable<T>>
    void sort__recursive_imple(ArrayList<T> array, int left, int right, boolean isAsc){
        if (left >= right){
            //Our base case
            return;
        }

        int pivotIdx = partition(array, left, right, isAsc);
        sort__recursive_imple(array, left, pivotIdx - 1, isAsc);
        sort__recursive_imple(array, pivotIdx + 1, right, isAsc);
    }

    private <T extends Comparable<T>>
    int partition(ArrayList<T> array, int left, int right, boolean isAsc){
        // We consider the last element to be our pivot
        T pivot = array.get(right);

        // And initialize a counter that counts the total number of elements that is smaller than the pivot
        int smallerThanPivotCounter = left;

        for (int j = left; j < right; j++){
            if (comparator(isAsc, array, j, pivot)){
                swap(array, smallerThanPivotCounter, j);
                smallerThanPivotCounter++;
            }
        }

        // Then swap the pivot into its position where all of its element is smaller than itself
        // Which is in this case the offset + value of the variable "smallerThanPivotCounter"
        swap(array, smallerThanPivotCounter, right);

        return (smallerThanPivotCounter);
    }

    private <T extends Comparable<T>>
    boolean comparator(boolean isAsc, ArrayList<T> array, int j, T pivot){
        return isAsc
                ? array.get(j).compareTo(pivot) < 0
                : array.get(j).compareTo(pivot) > 0;
    }
}
