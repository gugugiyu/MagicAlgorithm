package src.Sorting;

import src.Utils.Print;

import java.util.ArrayList;
import java.util.Random;

public class SortDisplayer {
    public void arraySortingFlow(Sortable sortable ,ArrayList<Integer> list){
        long tempTimer = 0; //Temp variable to track execution
        long ascExecutionTime = 0;
        long desExecutionTime = 0;

        Random random = new Random();
        Print<Integer> printer = new Print<>();

        //Print currentArray
        System.out.println("Current list: ");
        printer.print(list);

        System.out.println("\nLet's sort the list in ascending order first:");

        //Timer
        tempTimer = System.nanoTime();
        //Sort the list (ascending order)
        sortable.sort(list, true);
        ascExecutionTime = System.nanoTime() - tempTimer;

        System.out.println("After sort: ");
        printer.print(list);

        System.out.println("\nAnd now let's try descending order: ");

        tempTimer = System.nanoTime();
        //Sort the list (descending order)
        sortable.sort(list, false);
        desExecutionTime = System.nanoTime() - tempTimer;

        System.out.println("After sort: ");
        printer.print(list);

        System.out.println("\nPerformance stat:");
        System.out.println("-- Sorting in ascending order: " + ascExecutionTime / 1_000_000.0 + "ms");
        System.out.println("-- Sorting in descending order: " + desExecutionTime / 1_000_000.0 + "ms");
        System.out.println("-- Average: " + ((ascExecutionTime + desExecutionTime) / 2) / 1_000_000.0 + "ms");
    }
}
