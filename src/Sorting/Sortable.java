package src.Sorting;

import java.util.ArrayList;

public interface Sortable {
     <T extends Comparable<T>> void sort(ArrayList<T> array, boolean isAsc);
}
