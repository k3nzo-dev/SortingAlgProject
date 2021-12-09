import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Runner {

    public static void main(String[] args) {

        Integer[] arrayInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                25};
        File book = new File("/Users/lboschi25/Desktop/SortingAlgProject/src/allOfHarryPotter1.rtf");

        JavaPaintUI.uiStart();
        System.out.println(BubSort.bubSort(arrayInt));
        System.out.println("");
        System.out.println(SelectionSort.selectionSort(arrayInt));
        System.out.println("");
        ArrayList<String> sortedBook = BookSort.bookSort(book);
        System.out.println(sortedBook.size());


    }


}

