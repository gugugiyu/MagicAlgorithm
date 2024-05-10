package src.Searching.LinearSearch;

import src.Searching.Displayer;
import src.Utils.ArrayGenerator;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        Displayer displayer = new Displayer();
        LinearSearch searchInstance = new LinearSearch();

        //Generate a new list
        ArrayList<Integer> list = arrayGenerator.randomIntArrayGenerator(12, 50);

        displayer.ArraySearchingFlow(searchInstance, list);
    }
}