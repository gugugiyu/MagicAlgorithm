package src.Searching;

import src.Utils.Print;

import java.util.ArrayList;
import java.util.Random;

/**
 * Single class to handle display of generic guiding flow
 */
public class Displayer {
    public void ArraySearchingFlow(Searchable searchable, ArrayList<Integer> list){
        Random random = new Random();
        Print<Integer> printer = new Print<>();

        //Print currentArray
        printer.print(list);

        //Get a random element from the list
        int randomElement = list.get(random.nextInt(0, list.size()));

        System.out.println("\nLet's look for " + randomElement);

        int i = searchable.search(list, randomElement);

        if (i >= 0){
            System.out.println("Found " + randomElement + " at " + "index " + i );
        }else{
            System.out.println("Couldn't find " + randomElement);
        }

        //Get a number that doesn't exist from the list
        int BIG_NUM = Integer.MAX_VALUE;

        System.out.println("\nLet's look for " + BIG_NUM);

        i = searchable.search(list, BIG_NUM);

        if (i >= 0){
            System.out.println("Found " + BIG_NUM + " at " + "index " + i );
        }else{
            System.out.println("Couldn't find " + BIG_NUM);
        }
    }
}
