package src.Searching.SentinelSearch;

import src.Searching.SearchDisplayer;
import src.Utils.ArrayGenerator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        SearchDisplayer searchDisplayer = new SearchDisplayer();
        SentinelSearch searchInstance = new SentinelSearch();

        //Generate a new list
        ArrayList<Integer> list = arrayGenerator.randomIntArrayGenerator(12, 50);

        searchDisplayer.ArraySearchingFlow(searchInstance, list);
    }
}