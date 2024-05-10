package src.Searching.SentinelSearch;

import src.Searching.Displayer;
import src.Searching.LinearSearch.LinearSearch;
import src.Utils.ArrayGenerator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        Displayer displayer = new Displayer();
        SentinelSearch searchInstance = new SentinelSearch();

        //Generate a new list
        ArrayList<Integer> list = arrayGenerator.randomIntArrayGenerator(12, 50);

        displayer.ArraySearchingFlow(searchInstance, list);
    }
}