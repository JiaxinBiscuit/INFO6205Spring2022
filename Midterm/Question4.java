import java.util.Arrays;
import java.util.LinkedList;

public class Question4 {
    public int[][] mergeIntervals(int[][] intervals){
        if(intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        LinkedList<int[]> res = new LinkedList();
        for(int[] interval : intervals){
            if(res.isEmpty() || interval[0] > res.getLast()[1]){
                res.add(interval);
            }else{
                res.getLast()[1] = Math.max(res.getLast()[1] ,interval[1]);
            }
        }

        return res.toArray(new int[res.size()][]);

    }
}
