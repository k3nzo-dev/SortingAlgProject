import java.util.ArrayList;

public class BubSort
        extends AbstractSort {
    public BubSort(ArrayList<Integer> data) {
        super(data);
    }

    public int sort(int delay) {

        boolean sorted = false;
        int temp;
        int pass = 0;
        while (!sorted) {
            //start pass

            //triggers the first draw
            this.fireSortingPassStart(pass, this.data);

            sorted = true;

            for (int i = 0; i < this.data.size() - 1; i++) {


                    if (this.data.get(i) > this.data.get(i + 1)) {

                        //swaps values
                        temp = this.data.get(i);
                        this.data.set(i, this.data.get(i + 1));
                        this.data.set(i + 1, temp);

                        sorted = false;
                        //increases the pass number
                        pass++;
                    }


            }

            //triggers the draw
            this.fireSortingPassEnd(pass, this.data);
            Utility.sleepIt(delay);

        }
       return pass;
    }
}

