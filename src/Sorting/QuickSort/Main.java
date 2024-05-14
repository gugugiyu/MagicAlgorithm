package src.Sorting.QuickSort;

import src.Sorting.SortDisplayer;
import src.Utils.ArrayGenerator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        QuickSort quickSort = new QuickSort();
        SortDisplayer sortDisplayer = new SortDisplayer();

        //Generate a new list
        ArrayList<Integer> list = arrayGenerator.randomIntArrayGenerator(12 ,50);

        sortDisplayer.arraySortingFlow(quickSort, list);
    }
}
