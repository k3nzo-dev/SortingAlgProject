import java.util.ArrayList;

/**
 * The shell class for all sorts
 */
public abstract class AbstractSort {

    protected AbstractSort(ArrayList data) {
        this.data = data;
    }

    protected ArrayList<Integer> data;
    protected SortingEventListener listener;

    public abstract int sort(int delay);

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
