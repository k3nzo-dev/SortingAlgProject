import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {


        File book = new File("/Users/lboschi25/Dropbox/BoschiLorenzo/Projects/SortingAlgProject/src/allOfHarryPotter1.txt");

        AbstractSort sorter;
        JavaPaintUI UI = new JavaPaintUI();
        UI.setVisible(true);
        boolean cont = true;

        while (cont) {


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

            int numOfItems = Integer.parseInt(JOptionPane.showInputDialog("How many items would you like to sort?(1 - 720)"));
            if (numOfItems > 720)
                numOfItems = 720;

            ArrayList<Integer> arrayIntList = Utility.ShuffledIntArray(numOfItems);

            int sortSpeed = Integer.parseInt(JOptionPane.showInputDialog("How fast do you want it to sort(1-10)"));


            if (choice.equalsIgnoreCase("bubble")) {
                sorter = new BubSortAlg(arrayIntList);
                sorter.setSortingListener(UI);
                sorter.sort(sortSpeed * 10);

            } else if (choice.equalsIgnoreCase("Selection")) {
                sorter = new SelectionSortAlg(arrayIntList);
                sorter.setSortingListener(UI);
                sorter.sort(sortSpeed * 10);
            }

            String[] options = {"Yes", "No"};
            String contChoice = (String) JOptionPane.showInputDialog(
                    null,
                    "Would you like to continue", //text in window
                    "Continue", //titlebar
                    JOptionPane.PLAIN_MESSAGE, //the icon type
                    null,
                    options, //array of options
                    options[0]); //the default
            if (contChoice == "No") {
                cont = false;
            }


            //ArrayList<String> sortedBook = BookSort.bookSort(book);
        }
        UI.setVisible(false);
        System.exit(0);

    }


}


