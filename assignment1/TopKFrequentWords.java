import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (!hashMap.containsKey(words[i]) ){
                hashMap.put(words[i], 1);
            } else {
                hashMap.put(words[i], hashMap.get(words[i]) + 1);
            }
        }
        Queue<Pair> minHeap = new PriorityQueue<>(k, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if (p1.count - p2.count != 0) {
                    return p1.count - p2.count;
                } else {
                    return p2.word.compareTo(p1.word);
                }

            }
        });

        int i = k;
        for (String key : hashMap.keySet()) {
            if (i-- > 0) {
                minHeap.offer(new Pair(key, hashMap.get(key)));
                continue;
            }
            if (hashMap.get(key) > minHeap.peek().count) {
                minHeap.poll();
                minHeap.offer(new Pair(key, hashMap.get(key)));
            }else if (hashMap.get(key) == minHeap.peek().count && key.compareTo(minHeap.peek().word) < 0) {
                minHeap.poll();
                minHeap.offer(new Pair(key, hashMap.get(key)));
            }
        }

        List<String> res = new ArrayList<>();
        while (minHeap.size() > 0) {
            res.add(minHeap.poll().word);
        }
        Collections.reverse(res);
        return res;

    }

    public class Pair {
        String word;
        int count;

        public Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

}
