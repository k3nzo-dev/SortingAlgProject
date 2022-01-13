import Tools.*;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Runner {

    /**
     * A sorting algorithm that displays a user interface
     *
     * @author Lorenzo Boschi
     */
    public static void main(String[] args) {


        AbstractSort sorter;
        JavaPaintUI UI = new JavaPaintUI();
        UI.setVisible(true);
        boolean cont = true;
        double changesPerItem = 0;
        Files f = new Files();

        while (cont) {

            try {
                int pass;

                String[] choices = {"Bubble", "Selection", "Insertion", "Bogo"};
                String instructions = "What sort method would you like to use?";
                String title = "Sort Chose";
                String choice = Toolbox.multiStringChoices(instructions, title, choices);


                int numOfItems = Integer.parseInt(JOptionPane.showInputDialog("How many items"
                        + "would you like to sort?(2 - 720)"));

                //if you go past 720 then it does not display
                if (numOfItems > 720)
                    numOfItems = 720;

                ArrayList<Integer> arrayIntList = Toolbox.shuffledIntList(numOfItems);

                int sortSpeed = Integer.parseInt(JOptionPane.showInputDialog("How fast "
                        + "do you want it to sort(1 (fastest)- 10 (slowest)"));


                if (choice.equalsIgnoreCase("Bubble")) {

                    //if there is no saved file it creates one
                    Files.fileCreate(choice);
                    //starts the sort
                    sorter = new BubSort(arrayIntList);
                    sorter.setSortingListener(UI);
                    pass = sorter.sort(sortSpeed * 10);

                    changesPerItem = Toolbox.doubleCutoff((pass * 1.0) / numOfItems);
                    //updates the file
                    f.fileWrite(choice, changesPerItem);

                } else if (choice.equalsIgnoreCase("Selection")) {

                    //if there is no saved file it creates one
                    Files.fileCreate(choice);
                    //starts the sort
                    sorter = new SelectionSort(arrayIntList);
                    sorter.setSortingListener(UI);
                    pass = sorter.sort(sortSpeed * 10);

                    changesPerItem = Toolbox.doubleCutoff((pass * 1.0) / numOfItems);
                    //updates the file
                    f.fileWrite(choice, changesPerItem);

                } else if (choice.equalsIgnoreCase(("Insertion"))) {

                    //if there is no saved file it creates one
                    Files.fileCreate(choice);
                    //starts the sort
                    sorter = new InsertionSort(arrayIntList);
                    sorter.setSortingListener(UI);
                    pass = sorter.sort(sortSpeed * 10);

                    changesPerItem = Toolbox.doubleCutoff((pass * 1.0) / numOfItems);
                    //updates the file
                    f.fileWrite(choice, changesPerItem);

                } else if (choice.equalsIgnoreCase(("Bogo"))) {

                    //warns people
                    if (!Toolbox.answeredYes(Toolbox.yesOrNoPopUp("Are you sure you want to do this"))){
                        return;
                    }

                    //if there is no saved file it creates one
                    Files.fileCreate(choice);
                    //starts the sort
                    sorter = new BogoSort(arrayIntList);
                    sorter.setSortingListener(UI);
                    pass = sorter.sort(sortSpeed * 10);

                    changesPerItem = Toolbox.doubleCutoff((pass * 1.0) / numOfItems);
                    //updates the file
                    f.fileWrite(choice, changesPerItem);

                }


                double sortDif = Toolbox.doubleCutoff(sortDif(changesPerItem, avgOfPastSorts(choice)));


                if (sortDif >= 0) {
                    Toolbox.popup("Efficiency",
                            "Your number of  changes per item is " +
                                    changesPerItem +
                                    ". \nThat is " +
                                    sortDif +
                                    " better then past " +
                                    choice.toLowerCase() +
                                    " sorts");
                } else if (sortDif <= 0) {
                    //makes the negative positive
                    sortDif += sortDif * 2;

                    Toolbox.popup("Efficiency",
                            "Your number of  changes per item is " +
                                    changesPerItem +
                                    ". \nThat is " +
                                    sortDif +
                                    " worse then past " +
                                    choice.toLowerCase() +
                                    " sorts");
                }


                String contChoice = Toolbox.yesOrNoPopUp("Would you like to continue");


                if (Toolbox.answeredYes(contChoice)) {
                    cont = false;
                }


            } catch (Exception e) {
                Toolbox.popup("Error", "There was an unexpected error");
            }
        }

        UI.setVisible(false);
        System.exit(0);

    }

    private static double avgOfPastSorts(String sortType) throws FileNotFoundException {
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

    private static double sortDif(double perItemEfficiency, double oldAvg) {
        return perItemEfficiency - oldAvg;
    }
}


