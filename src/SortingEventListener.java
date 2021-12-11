import java.util.ArrayList;

public interface SortingEventListener {
    void onStartSortingPass(int pass, ArrayList<Integer> data);
    void onEndSortingPass(int pass, ArrayList<Integer> data);

}
