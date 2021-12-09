import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utility {

    public static boolean answeredYes(String response) {
        response = response.toLowerCase();
        return response.equals("yes") || response.equals("y") || response.equals("yeah");
    }

    public static void sleepIt(int mls){
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            System.out.println("A runtime error has occurred");
        }
    }

    public static void popup(String title, String msg){
        JOptionPane.showMessageDialog(null, msg,
                title, JOptionPane.PLAIN_MESSAGE);
    }

    public static Integer[] ShuffledIntArray() {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                25};
        List<Integer> intList = Arrays.asList(intArray);
        Collections.shuffle(intList);
        intList.toArray(intArray);

        return intArray;
    }


}
