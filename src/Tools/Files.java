package Tools;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Contains methods to make and write files
 */
public class Files {

    /**
     * stores the old file then adds the new value to the file
     * @param choice the name of the file you want to add to
     * @param value the number to be writen
     */
    public void fileWrite(String choice, double value) {
        //makes an array list of the files lines
        File sortFile = new File("pastSorts/" + choice + ".txt");
        Scanner oldSortReader = null;
        try {
            oldSortReader = new Scanner(sortFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Double> oldSorts = new ArrayList<>();

        while (oldSortReader.hasNextLine()) {
            String sortValue = oldSortReader.nextLine();
            oldSorts.add(Double.parseDouble(sortValue));
        }


        String oldFile = "";
        //stores the past file in a string
        for (int i = 0; i < oldSorts.size(); i++)
            oldFile += oldSorts.get(i) + "\n";

        oldFile += value + "\n";


        try {
            FileWriter writer = new FileWriter("pastSorts/" + choice + ".txt");
            writer.write(oldFile);

            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Creates a file with the provided name
     * @param choice the name of the file to write
     */
    public static void fileCreate(String choice) {
        try {


            File myObj = new File("pastSorts/" + choice + ".txt");
            try {
                //tests to see if the file is existing if not then it creates one
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
