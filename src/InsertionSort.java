import java.util.ArrayList;

public class InsertionSort extends
        AbstractSort {

    public InsertionSort(ArrayList<Integer> data) {
        super(data);
    }

    public void sort(int delay) {
        boolean sorted = false;

        while (!sorted) {
            int pass = 0;
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
                }
                //cont swap
                this.data.set(j + 1, currentData);


                //triggers the draw
                this.fireSortingPassEnd(pass, this.data);
                Utility.sleepIt(delay);

                //increases the pass number and ends pass

                pass++;
            }

            sorted = Utility.arrayListChecker(this.data);

        }
    }
}


