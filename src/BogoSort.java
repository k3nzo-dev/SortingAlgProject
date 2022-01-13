import Tools.Toolbox;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A class to perform a bogo sort
 * Please avoid using this sorting method
 */
public class BogoSort
        extends AbstractSort {
    public BogoSort(ArrayList<Integer> data) {
        super(data);
    }

    public int sort(int delay) {
        int pass = 0;
        while (!Toolbox.arrayListChecker(data)) {

            this.fireSortingPassStart(pass, data);

            Collections.shuffle(data);

            this.fireSortingPassEnd(pass, data);

            pass++;

        }
        return pass;

    }


}
