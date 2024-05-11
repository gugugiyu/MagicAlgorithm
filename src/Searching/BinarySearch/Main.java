package src.Searching.BinarySearch;

import src.Searching.SearchDisplayer;
import src.Utils.ArrayGenerator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        SearchDisplayer searchDisplayer = new SearchDisplayer();
        BinarySearch searchInstance = new BinarySearch();

        //Generate a new list
        ArrayList<Integer> list = arrayGenerator.randomIntArrayGenerator(12, 50);

        //Since binary search only works upon sorted array
        Collections.sort(list);

        searchDisplayer.ArraySearchingFlow(searchInstance, list);
    }
}