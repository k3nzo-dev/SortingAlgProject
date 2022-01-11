import java.util.ArrayList;

public class SelectionSort
        extends AbstractSort {
    public SelectionSort(ArrayList<Integer> data) {
        super(data);
    }

    public int sort(int delay) {

        int pass = 0;
        for (int i = 0; i < this.data.size(); i++) {

            //triggers the first draw
            this.fireSortingPassStart(pass, this.data);

            int min = this.data.get(i);
            int minIndex = i;

            for (int j = i + 1; j < this.data.size(); j++) {

                if (this.data.get(j) < min) {
                    //stores for swap
                    min = this.data.get(j);
                    minIndex = j;
                    //increases the pass number
                    pass++;
                }

            }

            //swaps values
            int temp = this.data.get(i);
            this.data.set(i, min);
            this.data.set(minIndex, temp);

            //trigger the draw
            this.fireSortingPassEnd(pass, this.data);
            Utility.sleepIt(delay);


        }
        return pass;

    }

}
	

