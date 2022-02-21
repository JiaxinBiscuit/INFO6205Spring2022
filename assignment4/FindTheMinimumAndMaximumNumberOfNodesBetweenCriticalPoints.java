public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = head.next.next;

        int firstNode = -1;
        int curNode = 0;
        int prevNode = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (next != null) {
            curNode++;
            if ((prev.val < cur.val && next.val < cur.val) || (prev.val > cur.val && next.val > cur.val)) {
                if (firstNode < 0) {
                    firstNode = curNode;
                } else {
                    max = curNode - firstNode;
                }
                if (prevNode < 0) {
                    prevNode = firstNode;
                } else {
                    min = Math.min(min, curNode - prevNode);
                    prevNode = curNode;
                }
            }
            prev = cur;
            cur = next;
            next = next.next;
        }

        if (min == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{min, max};


    }
}