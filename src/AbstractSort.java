import java.util.ArrayList;

public abstract class AbstractSort {

    protected AbstractSort(ArrayList data) {
        this.data = data;
    }

    protected ArrayList<Integer> data;
    protected SortingEventListener listener;

    public abstract void sort(int delay);

    public void setSortingListener(SortingEventListener sel) {
        this.listener = sel;
    }

    protected void fireSortingPassStart(int pass, ArrayList<Integer> data) {
        if (this.listener != null) {
            this.listener.onStartSortingPass(pass, data);
        }
    }

    protected void fireSortingPassEnd(int pass, ArrayList<Integer> data) {
        if (this.listener != null) {
            this.listener.onEndSortingPass(pass, data);
        }
    }

}
