import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BubSort {
    public static List<Integer> bubSort(Integer[] intArray) {

        List<Integer> intList = Arrays.asList(intArray);
        Collections.shuffle(intList);
        intList.toArray(intArray);
        System.out.println(intList);
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < intArray.length - 1; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    temp = intArray[i];
                    intArray[i] = intArray[i + 1];
                    intArray[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        return intList;

    }
}
