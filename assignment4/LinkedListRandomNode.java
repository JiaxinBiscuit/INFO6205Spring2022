import java.util.ArrayList;

public class LinkedListRandomNode {
    private ArrayList<Integer> range = new ArrayList<>();

    public LinkedListRandomNode(ListNode head) {
        while(head != null){
            this.range.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int randomValue = (int)(Math.random()*this.range.size());
        return this.range.get(randomValue);
    }
}
