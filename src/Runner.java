import javax.swing.*;
import java.util.ArrayList;

public class Runner {

    /**
     * A sorting algorithm display user interface
     * @author Lorenzo Boschi
     * @version 1.0.0
     */
    public static void main(String[] args) {


//        File book = new File("/Users/lboschi25/Dropbox/BoschiLorenzo/Projects/SortingAlgProject/Untitled.rtf");
//
//
//        ArrayList<String> sortedBook = BookSort.bookSort(book);
//        for (int i = 0; i < sortedBook.size(); i++) {
//            System.out.println(sortedBook.get(i));
//        }

        AbstractSort sorter;
        JavaPaintUI UI = new JavaPaintUI();
        UI.setVisible(true);
        boolean cont = true;

        while (cont) {


            String[] choices = {"Bubble", "Selection", "Insertion"};
            String instructions = "What sort method would you like to use?";
            String title = "Sort Chose";
            String choice = Utility.multiStringChoices(instructions, title, choices);


            int numOfItems = Integer.parseInt(JOptionPane.showInputDialog("How many items would you like to"
                    + " sort?(1 - 720)"));

            //if you go past 720 then it does not display
            if (numOfItems > 720)
                numOfItems = 720;

            ArrayList<Integer> arrayIntList = Utility.shuffledIntArray(numOfItems);
            System.out.println(arrayIntList);

            int sortSpeed = Integer.parseInt(JOptionPane.showInputDialog("How fast do you want it to sort(1 (fastest)"
                    + "- 10 (slowest)"));


            if (choice.equalsIgnoreCase("bubble")) {
                sorter = new BubSortAlg(arrayIntList);
                sorter.setSortingListener(UI);
                sorter.sort(sortSpeed * 10);

            } else if (choice.equalsIgnoreCase("Selection")) {
                sorter = new SelectionSortAlg(arrayIntList);
                sorter.setSortingListener(UI);
                sorter.sort(sortSpeed * 10);
            }else if(choice.equalsIgnoreCase(("Insertion"))){
                sorter = new InsertionSort(arrayIntList);
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



        }

        UI.setVisible(false);
        System.exit(0);

    }


}


