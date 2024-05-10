package src.Searching.BinarySearch;

import src.Searching.Displayer;
import src.Searching.LinearSearch.LinearSearch;
import src.Utils.ArrayGenerator;
import src.Utils.Print;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        Displayer displayer = new Displayer();
        BinarySearch searchInstance = new BinarySearch();

        //Generate a new list
        ArrayList<Integer> list = arrayGenerator.randomIntArrayGenerator(12, 50);

        //Since binary search only works upon sorted array
        Collections.sort(list);

        displayer.ArraySearchingFlow(searchInstance, list);
    }
}