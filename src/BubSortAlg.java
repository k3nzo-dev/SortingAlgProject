import java.util.ArrayList;

public class BubSortAlg
        extends AbstractSort {
    public BubSortAlg(ArrayList<Integer> data) {
        super(data);
    }

    public void sort(int delay) {


        boolean sorted = false;
        int temp;
        int pass = 0;
        while (!sorted) {
            //start passing
            this.fireSortingPassStart(pass, this.data);

            sorted = true;
            for (int i = 0; i < this.data.size() - 1; i++) {
                //Sorting step

                if (this.data.get(i) > this.data.get(i + 1)) {
                    temp = this.data.get(i);
                    this.data.set(i, this.data.get(i + 1));
                    this.data.set(i + 1, temp);
                    sorted = false;
                }
            }
            this.fireSortingPassEnd(pass,this.data);
            System.out.println(this.data);
            Utility.sleepIt(delay);
            pass++;
            //end pass
        }
    }
}

