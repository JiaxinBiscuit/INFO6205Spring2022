public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right){
            return head;
        }

        ListNode cur = head;
        ListNode prev = null;

        while(left > 1){
            prev = cur;
            cur = cur.next;
            left --;
            right --;
        }
        ListNode prevHead = prev;
        ListNode preTail = cur;
        ListNode next = null;

        while(right > 0){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            right --;
        }

        if (prevHead == null){
            head = prev;
        } else {
            prevHead.next = prev;
        }

        preTail.next = cur;
        return head;



    }

}
