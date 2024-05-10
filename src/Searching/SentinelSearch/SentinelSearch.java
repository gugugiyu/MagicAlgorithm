package src.Searching.SentinelSearch;

import src.Searching.Searchable;

import java.util.ArrayList;
import java.util.Objects;

public class SentinelSearch implements Searchable {
    @Override
    public int search(ArrayList<Integer> array, Integer value) {
        int arrayLength = array.size();

        int memoLastElem = array.getLast();

        //The iterator
        int i = 0;

        while (i < arrayLength && !Objects.equals(array.get(i), value))
            i++;

        if (i < arrayLength - 1){
            //Means that the value existed within the array
            return i;
        }else{
            //Check the last elem just in case the last one matches and place it back
            array.set(arrayLength - 1, memoLastElem);

            if (memoLastElem == value){
                return arrayLength - 1;
            }

            return -1;
        }
    }
}
