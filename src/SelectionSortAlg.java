import java.util.ArrayList;

public class SelectionSortAlg
        extends AbstractSort {
    public SelectionSortAlg(ArrayList<Integer> data) {
        super(data);
    }

    public void sort(int delay) {

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
                }

            }

            //swaps values
            int temp = this.data.get(i);
            this.data.set(i, min);
            this.data.set(minIndex, temp);

            //trigger the draw
            this.fireSortingPassEnd(pass, this.data);
            Utility.sleepIt(delay);

            //increases the pass number and ends pass
            pass++;
        }

    }

}
	

