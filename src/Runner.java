import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    /**
     * A sorting algorithm display user interface
     *
     * @author Lorenzo Boschi
     * @version 1.0.0
     */
    public static void main(String[] args) throws FileNotFoundException {


        AbstractSort sorter;
        JavaPaintUI UI = new JavaPaintUI();
        UI.setVisible(true);
        boolean cont = true;
        double passesPerItem = 0;
        FileUse f = new FileUse();

        while (cont) {

            try {
                int pass = 0;

                String[] choices = {"Bubble", "Selection", "Insertion", "Bogo"};
                String instructions = "What sort method would you like to use?";
                String title = "Sort Chose";
                String choice = Utility.multiStringChoices(instructions, title, choices);


                int numOfItems = Integer.parseInt(JOptionPane.showInputDialog("How many items"
                        + "would you like to sort?(2 - 720)"));

                //if you go past 720 then it does not display
                if (numOfItems > 720)
                    numOfItems = 720;

                ArrayList<Integer> arrayIntList = Utility.shuffledIntList(numOfItems);

                int sortSpeed = Integer.parseInt(JOptionPane.showInputDialog("How fast "
                        + "do you want it to sort(1 (fastest)- 10 (slowest)"));


                if (choice.equalsIgnoreCase("Bubble")) {

                    //if there is no saved file it creates one
                    f.fileWrite(choice);
                    //starts the sort
                    sorter = new BubSort(arrayIntList);
                    sorter.setSortingListener(UI);
                    pass = sorter.sort(sortSpeed * 10);

                    passesPerItem = (pass * 1.0) / numOfItems;
                    //updates the file
                    f.fileAdd(choice, passesPerItem);

                } else if (choice.equalsIgnoreCase("Selection")) {

                    //if there is no saved file it creates one
                    f.fileWrite(choice);
                    //starts the sort
                    sorter = new SelectionSort(arrayIntList);
                    sorter.setSortingListener(UI);
                    pass = sorter.sort(sortSpeed * 10);

                    passesPerItem = (pass * 1.0) / numOfItems;
                    //updates the file
                    f.fileAdd(choice, passesPerItem);

                } else if (choice.equalsIgnoreCase(("Insertion"))) {

                    //if there is no saved file it creates one
                    f.fileWrite(choice);
                    //starts the sort
                    sorter = new InsertionSort(arrayIntList);
                    sorter.setSortingListener(UI);
                    pass = sorter.sort(sortSpeed * 10);

                    passesPerItem = (pass * 1.0) / numOfItems;
                    //updates the file
                    f.fileAdd(choice, passesPerItem);

                } else if (choice.equalsIgnoreCase(("Bogo"))) {

                    //if there is no saved file it creates one
                    f.fileWrite(choice);
                    //starts the sort
                    sorter = new BogoSort(arrayIntList);
                    sorter.setSortingListener(UI);
                    pass = sorter.sort(sortSpeed * 10);

                    passesPerItem = (pass * 1.0) / numOfItems;
                    //updates the file
                    f.fileAdd(choice, passesPerItem);

                }


                double sortDif = sortDif(passesPerItem, avgOfPastSorts(choice));

                if (sortDif >= 0) {
                    Utility.popup("Efficiency",
                            "Your number of  passes per item is " +
                                    passesPerItem +
                                    ". \nThat is " +
                                    sortDif +
                                    " lower then past " +
                                    choice.toLowerCase() +
                                    " sorts");
                } else if (sortDif <= 0) {
                    //makes the negative positive
                    passesPerItem += passesPerItem * 2;

                    Utility.popup("Efficiency",
                            "Your number of  passes per item is " +
                                    passesPerItem +
                                    ". \nThat is " +
                                    sortDif +
                                    " lower then past " +
                                    choice.toLowerCase() +
                                    " sorts");
                }


                String[] options = {"Yes", "No"};
                String contChoice = (String) JOptionPane.showInputDialog(
                        null,
                        "Would you like to continue", //text in window
                        "Continue", //title bar
                        JOptionPane.QUESTION_MESSAGE, //the icon type
                        null,
                        options, //array of options
                        options[0]); //the default


                if (contChoice == "No") {
                    cont = false;
                }


            } catch (Exception e) {
                Utility.popup("Error", "There was an unexpected error");
            }
        }

        UI.setVisible(false);
        System.exit(0);

    }

    public static double avgOfPastSorts(String sortType) throws FileNotFoundException {
        double total = 0;
        File sortFile = new File("pastSorts/" + sortType + ".txt");
        Scanner oldSortReader = new Scanner(sortFile);
        ArrayList<Double> oldSorts = new ArrayList<>();

        //parses the whole file
        while (oldSortReader.hasNextLine()) {
            String sortValue = oldSortReader.nextLine();
            oldSorts.add(Double.parseDouble(sortValue));
        }

        for (int i = 0; i < oldSorts.size(); i++) {
            total += oldSorts.get(i);
        }

        return (total * 1.0) / oldSorts.size();

    }

    public static double sortDif(double perItemEfficiency, double oldAvg) {
        return perItemEfficiency - oldAvg;

    }
}


