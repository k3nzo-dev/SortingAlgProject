import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Utility {

    public static boolean answeredYes(String response) {
        response = response.toLowerCase();
        return response.equals("yes") || response.equals("y") || response.equals("yeah");
    }

    public static void sleepIt(int mls) {
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            System.out.println("A runtime error has occurred");
        }
    }

    public static void popup(String title, String msg) {
        JOptionPane.showMessageDialog(null, msg,
                title, JOptionPane.PLAIN_MESSAGE);
    }

    public static ArrayList<Integer> ShuffledIntArray(int max) {
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            intList.add(i);
        }
        Collections.shuffle(intList);

        return intList;
    }


}
