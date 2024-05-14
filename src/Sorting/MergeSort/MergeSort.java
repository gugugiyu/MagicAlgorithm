package src.Sorting.MergeSort;

import src.Sorting.Sortable;
import src.Sorting.Sorting;

import java.util.ArrayList;

public class MergeSort extends Sorting implements Sortable {
    @Override
    public <T extends Comparable<T>>
    void sort(ArrayList<T> array, boolean isAsc) {
        int left = 0;
        int right = array.size() - 1;

        sort__recursive_impl(array, isAsc, left, right);
    }

    public <T extends Comparable<T>>
    void sort__recursive_impl(ArrayList<T> array, boolean isAsc, int left, int right){
        if (left >= right){
            // Base case for recursion
            return;
        }

        int mid = (left + right) / 2;

        // We sort the first left half
        sort__recursive_impl(array, isAsc, left, mid);

        // And now the right half
        sort__recursive_impl(array, isAsc, mid + 1, right);

        //After we sort both size, we merge it back into one array
        merge(array, isAsc, left, mid, right);
    }

    public <T extends Comparable<T>>
    void merge(ArrayList<T> array, boolean isAsc, int left, int mid, int right){
        // The size of both auxiliary arrays to be merged
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // Init the auxiliary arrays
        ArrayList<T> leftArray = new ArrayList<>();
        ArrayList<T> rightArray = new ArrayList<>();

        // Fill in the elements for both array
        for (int i = 0; i < leftSize; i++)
            leftArray.add(i, array.get(left + i));

        for (int i = 0; i < rightSize; i++)
            rightArray.add(i, array.get(mid + i + 1));

        //Make counter for both arrays to merge them
        int leftCounter = 0;
        int rightCounter = 0;

        //And the current index to rewrite from the auxiliary arrays to the main array
        //It starts from "left" as that's where we start merging
            int mainCounter = left;

        while (leftCounter < leftSize && rightCounter < rightSize){
            if (comparator(isAsc, leftArray, leftCounter, rightArray, rightCounter)){
                array.set(mainCounter, leftArray.get(leftCounter));
                leftCounter++;
            }else{
                array.set(mainCounter, rightArray.get(rightCounter));
                rightCounter++;
            }

            mainCounter++;
        }

        //Extract out all the elements in the left array
        while (leftCounter < leftSize){
            array.set(mainCounter, leftArray.get(leftCounter));
            mainCounter++;
            leftCounter++;
        }

        //Extract out all the elements in the right array
        while (rightCounter < rightSize){
            array.set(mainCounter, rightArray.get(rightCounter));
            mainCounter++;
            rightCounter++;
        }
    }

    private <T extends Comparable<T>>
    boolean comparator(boolean isAsc, ArrayList<T> leftArray, int leftCounter, ArrayList<T> rightArray, int rightCounter){
        return isAsc
                ? leftArray.get(leftCounter).compareTo(rightArray.get(rightCounter)) <= 0
                : leftArray.get(leftCounter).compareTo(rightArray.get(rightCounter)) >= 0;
    }
}
