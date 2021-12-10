import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {

        Integer[] arrayInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                25};
        File book = new File("/Users/lboschi25/Dropbox/BoschiLorenzo/Projects/SortingAlgProject/src/allOfHarryPotter1.txt");


        String[] choices = {"Bubble", "Selection"};
        String instructions = "What sort method would you like to use?";
        String title = "Sort Chose";
        String choice = (String) JOptionPane.showInputDialog(
                null,
                instructions, //text in window
                title, //titlebar
                JOptionPane.PLAIN_MESSAGE, //the icon type
                null,
                choices, //array of options
                choices[0]); //the default

        if (choice.equalsIgnoreCase("bubble")) {
            System.out.println(BubSort.bubSort(arrayInt));
        } else if (choice.equalsIgnoreCase("Selection")) {
            System.out.println(SelectionSort.selectionSort(arrayInt));
        }
        JavaPaintUI.uiStart();
        //ArrayList<String> sortedBook = BookSort.bookSort(book);


    }


}


