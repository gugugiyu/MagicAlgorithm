package src.Sorting.BubbleSort;

import src.Sorting.SortDisplayer;
import src.Utils.ArrayGenerator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        BubbleSort bubbleSort = new BubbleSort();
        SortDisplayer sortDisplayer = new SortDisplayer();

        //Generate a new list
        ArrayList<Integer> list = arrayGenerator.randomIntArrayGenerator(12, 50);

        sortDisplayer.arraySortingFlow(bubbleSort, list);
    }
}
