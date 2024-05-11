package src.Sorting;

import java.util.ArrayList;

public class Sorting {
    protected boolean compareFunction(int a, int b, boolean isAsc){
        if (isAsc){
            return a > b;
        }else{
            return a < b;
        }
    }

    protected void swap(ArrayList<Integer> array, int i, int j){
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
