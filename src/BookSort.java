import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BookSort {

    public static ArrayList<String> bookSort(File file) {
        Scanner input = null;
        ArrayList<String> allWords = new ArrayList<>();

        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (input.hasNext()) {
            String word = input.next();
            //word.replaceAll("[.,?!<>|}{'\\/'\"  ]", "");
            allWords.add(word);

        }
        Collections.sort(allWords);
        return allWords;

    }
}
