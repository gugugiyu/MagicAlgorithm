package src.Sorting.MergeSort;

import src.Sorting.SortDisplayer;
import src.Utils.ArrayGenerator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        MergeSort mergeSort = new MergeSort();
        SortDisplayer sortDisplayer = new SortDisplayer();

        //Generate a new list
        ArrayList<String> list = arrayGenerator.randomStringArrayGenerator(500, 6);

        sortDisplayer.arraySortingFlow(mergeSort, list);
    }
}
