import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectionSort {
    public static List<Integer> selectionSort(Integer[] intArray) {
        List<Integer> intList = Arrays.asList(intArray);
        Collections.shuffle(intList);
        intList.toArray(intArray);
        System.out.println(intList);

        for (int i = 0; i < intArray.length; i++) {
            int min = intArray[i];
            int minId = i;
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[j] < min) {
                    min = intArray[j];
                    minId = j;
                }
            }
            int temp = intArray[i];
            intArray[i] = min;
            intArray[minId] = temp;
        }
        return intList;
    }

}
