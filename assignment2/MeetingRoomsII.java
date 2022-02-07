import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII {

        public int minMeetingRooms(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }

            Queue<Integer> minHeap =
                    new PriorityQueue<Integer>(
                            intervals.length, new Comparator<Integer>() {
                        public int compare(Integer a, Integer b) {
                            return a - b;
                        }
                    });

            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });

            minHeap.offer(intervals[0][1]);
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= minHeap.peek()) {
                    minHeap.poll();
                }
                minHeap.offer(intervals[i][1]);
            }

            return minHeap.size();
        }
    }

