package src.Utils;

import java.util.ArrayList;
import java.util.Random;

public class ArrayGenerator {

    public ArrayList<Integer> randomIntArrayGenerator(int nElem, int min, int max){
        ArrayList<Integer> returnList = new ArrayList<>();
        Random random = new Random();

        //Populate the list
        for (int i = 0; i < nElem; i++)
            returnList.add(random.nextInt(min, max));

        return returnList;
    }

    public ArrayList<Integer> randomIntArrayGenerator(int nElem, int max){
        return randomIntArrayGenerator(nElem, 0, max);
    }


    public ArrayList<Float> randomFloatArrayGenerator(int nElem){
        ArrayList<Float> returnList = new ArrayList<>();
        Random random = new Random();

        //Populate the list
        for (int i = 0; i < nElem; i++)
            returnList.add(random.nextFloat());

        return returnList;
    }

    public ArrayList<String> randomStringArrayGenerator(int nElem){
        String stringList = "abcdefghijklmnopqrstuvwxyz123456789";
        int stringListLen = stringList.length();

        ArrayList<String> returnList = new ArrayList<>();
        Random random = new Random();

        //Populate the list
        for (int i = 0; i < nElem; i++){
            //Construct a random string
            int randomStringLength = random.nextInt(5, 15);
            StringBuilder newString = new StringBuilder();

            for (int j = 0; j < randomStringLength; j++){
                newString.append(stringList.charAt(random.nextInt(stringListLen)));
            }

            returnList.add(newString.toString());
        }

        return returnList;
    }
}
