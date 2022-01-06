import java.util.ArrayList;
import java.util.Collections;

public class BogoSort
        extends AbstractSort {
    public BogoSort(ArrayList<Integer> data) {
        super(data);
    }

    public int sort(int delay) {
        int pass = 0;
        while (!Utility.arrayListChecker(data)) {

            this.fireSortingPassStart(pass, data);

            Collections.shuffle(data);

            this.fireSortingPassEnd(pass, data);
            Utility.sleepIt(delay);
            pass++;

        }
        return pass;

    }


}
