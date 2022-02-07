import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return null;
        }

        if(nums.length <= k){
            return nums;
        }

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int n : nums){
            if(hashmap.containsKey(n)){
                hashmap.put(n, hashmap.get(n)+1);
            } else{
                hashmap.put(n, 1);
            }
        }

        Queue<Pair> minHeap = new PriorityQueue<>(k,new Comparator<Pair>(){
            //override
            public int compare(Pair p1, Pair p2){
                return (p1.count - p2.count);
            }
        });

        int index = k;

        for(Integer n: hashmap.keySet()){
            Pair p = new Pair(n, hashmap.get(n));
            if(index>0){
                minHeap.offer(p);
                index--;
            }else{
                if(hashmap.get(n)> minHeap.peek().count){
                    minHeap.poll();
                    minHeap.offer(p);
                }
            }
        }

        int[] res = new int[k];
        for(int i = 0; i<k; i++){
            res[i] = minHeap.poll().value;
        }

        return res;
    }

}


class Pair{
    int value;
    int count;

    public Pair(int v, int c){
        value = v;
        count = c;
    }

}
