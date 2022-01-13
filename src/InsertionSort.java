import Tools.Toolbox;

import java.util.ArrayList;

/**
 * A class to perform insertion sort
 */

public class InsertionSort extends
        AbstractSort {

    public InsertionSort(ArrayList<Integer> data) {
        super(data);
    }

    public int sort(int delay) {
        boolean sorted = false;
        int pass = 0;
        while (!sorted) {

            int len = this.data.size();

            this.fireSortingPassStart(delay, this.data);

            for (int i = 1; i < len; ++i) {

                int currentData = this.data.get(i);

                int j = i - 1;

                // Move elements that are greater than the currentData to one position ahead
                while (j >= 0 && this.data.get(j) > currentData) {
                    //swap
                    this.data.set(j + 1, this.data.get(j));
                    j = j - 1;
                    //increases the pass number
                    pass++;
                }
                //cont swap
                this.data.set(j + 1, currentData);


                //triggers the draw
                this.fireSortingPassEnd(pass, this.data);
                Toolbox.sleepIt(delay);


            }

            sorted = Toolbox.arrayListChecker(this.data);

        }

        return pass;

    }
}


