package src.Sorting;

import java.util.ArrayList;

public class Sorting {
    protected <T extends Comparable<T>> boolean compareFunction(T a, T b, boolean isAsc){
        if (isAsc){
            return a.compareTo(b) > 0;
        }else{
            return a.compareTo(b) < 0;
        }
    }

    protected  <T extends Comparable<T>> void swap(ArrayList<T> array, int i, int j){
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
