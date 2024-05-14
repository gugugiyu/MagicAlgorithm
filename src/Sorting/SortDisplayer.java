package src.Sorting;

import src.Utils.Print;

import java.util.ArrayList;

public class SortDisplayer {
    public <T extends Comparable<T>>
    void arraySortingFlow(Sortable sortable , ArrayList<T> list){
        long tempTimer = 0; //Temp variable to track execution
        long ascExecutionTime;
        long desExecutionTime;

        //Make a clone list for sort checking
        ArrayList<T> cloneList = (ArrayList<T>) list.clone();

        Print<T> printer = new Print<>();

        //Print currentArray
        System.out.println("Current list: ");
        printer.print(cloneList);

        System.out.println("\nLet's sort the list in ascending order first:");

        //Timer
        tempTimer = System.nanoTime();
        //Sort the list (ascending order)
        sortable.sort(list, true);
        ascExecutionTime = System.nanoTime() - tempTimer;

        System.out.println("After sort: ");
        printer.print(list);

        //Check if valid sort or not
        if(arrayCheck(cloneList, list, true))
            System.out.println("Array check log: valid sort");

        System.out.println("\nAnd now let's try descending order: ");

        tempTimer = System.nanoTime();
        //Sort the list (descending order)
        sortable.sort(list, false);
        desExecutionTime = System.nanoTime() - tempTimer;

        System.out.println("After sort: ");
        printer.print(list);
        if(arrayCheck(cloneList, list, false))
            System.out.println("Array check log: valid sort");

        System.out.println("\nPerformance stat:");
        System.out.println("-- Sorting in ascending order: " + ascExecutionTime / 1_000_000.0 + "ms");
        System.out.println("-- Sorting in descending order: " + desExecutionTime / 1_000_000.0 + "ms");
        System.out.println("-- Average: " + ((ascExecutionTime + desExecutionTime) / 2) / 1_000_000.0 + "ms");
    }

    /**
     * Checks if the 'after' ArrayList is a valid result of sorting the 'before' ArrayList.
     *
     * @param before The ArrayList before sorting.
     * @param after  The ArrayList after sorting.
     * @param isAsc  A boolean indicating whether the sorting order is ascending (true) or descending (false).
     * @return True if the 'after' ArrayList is a valid result of sorting the 'before' ArrayList,
     *         otherwise false.
     */
    public <T extends Comparable<T>>
    boolean arrayCheck(ArrayList<T> before, ArrayList<T> after, boolean isAsc) {
        // Check if all the elements preserved
        if (!before.containsAll(after))
            return false;

        // Check if the 'after' ArrayList is fully sorted
        int afterLength = after.size();
        for (int i = 0; i < afterLength - 1; i++) {
            if (comparator(isAsc, after.get(i), after.get(i + 1)))
                return false;
        }

        return true;
    }

    private <T extends Comparable<T>>
    boolean comparator(boolean isAsc, T a, T b) {
        return isAsc ? a.compareTo(b) > 0 : a.compareTo(b) < 0;
    }
}
