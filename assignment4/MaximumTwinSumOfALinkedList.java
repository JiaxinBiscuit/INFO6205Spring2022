public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }

        if (head.next == null) {
            return head.val;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        fast = head;
        int sum = Integer.MIN_VALUE;
        while (slow != null) {
            sum = Math.max(slow.val + fast.val, sum);
            slow = slow.next;
            fast = fast.next;
        }
        return sum;
    }

    public ListNode reverse(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode cur = node;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
