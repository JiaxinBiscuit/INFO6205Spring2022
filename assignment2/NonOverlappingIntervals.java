import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[]b){
                return a[0]-b[0];
            }
        });


        int end = intervals[0][1];
        int prev = 0;
        int count = 0;

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[prev][1]){
                if(intervals[i][1] < intervals[prev][1]){
                    prev = i;
                }
                count++;
            }else{
                prev = i;
            }
        }

        return count;
    }
}
