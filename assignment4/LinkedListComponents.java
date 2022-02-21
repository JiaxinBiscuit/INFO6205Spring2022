import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
    public int numComponents(ListNode head, int[] nums) {

        Set<Integer> numSet = new HashSet();
        for (int i = 0; i < nums.length; i ++) {
            numSet.add(nums[i]);
        }
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            if (numSet.contains(curr.val)) {
                while (curr.next != null && numSet.contains(curr.next.val)) {
                    curr = curr.next;
                }
                count ++;
            }
            curr = curr.next;
        }
        return count;

    }
}
