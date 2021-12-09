import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BookSort {
    public static boolean checkStartEnd(String word, char test){
        return word.charAt(0) == test || word.charAt(word.length() - 1) == test;
    }

    public static ArrayList<String> bookSort(File file){
        Scanner input = null;
        ArrayList<String> allWords = new ArrayList<String>();

        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (input.hasNext()) {
            String word  = input.next();
            word.replaceAll("[.,?!<>|}{'\\/'\"  ]", "");
            allWords.add(word);

        }
        Collections.sort(allWords);
        return allWords;

    }
}
