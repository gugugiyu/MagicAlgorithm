package src.Utils;

import java.util.ArrayList;

public class Print<T> {
    public void print(ArrayList<T> list){
        System.out.print("[");

        int listLength = list.size();

        for (int i = 0; i < listLength; i++){
            System.out.print(list.get(i));

            if (i < listLength - 1)
                System.out.print(", ");
        }

        System.out.println("]");
    }
}
