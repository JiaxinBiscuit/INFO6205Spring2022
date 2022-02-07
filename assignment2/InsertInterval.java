import java.util.LinkedList;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int index = 0;
        LinkedList<int[]> output = new LinkedList<int[]>();

        while(index < intervals.length && newStart > intervals[index][0]){
            output.add(intervals[index]);
            index++;
        }

        int[] interval = new int[2];
        if(output.isEmpty() || output.getLast()[1]< newStart){
            output.add(newInterval);
        } else{
            interval = output.removeLast();
            interval[1] = Math.max(interval[1],newEnd);
            output.add(interval);
        }

        while(index <= intervals.length-1){
            interval = intervals[index++];
            int start = interval[0];
            int end = interval[1];
            if(output.getLast()[1] < interval[0]){
                output.add(interval);
            }else{
                interval = output.removeLast();
                interval[1] = Math.max(end,interval[1]);
                output.add(interval);
            }
        }


        return output.toArray(new int[output.size()][2]);

    }

}
