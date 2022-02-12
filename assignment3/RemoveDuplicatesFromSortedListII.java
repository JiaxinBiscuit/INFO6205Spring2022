public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next = cur.next;
        prev.next = cur;

        while(cur != null && cur.next != null){
            if(cur.val != next.val){
                prev = cur;
                cur = next;
                next = cur.next;
            }else{
                while(next != null && cur.val == next.val ){
                    next = next.next;
                }
                prev.next = next;
                cur = next;
                if(cur != null){
                    next = cur.next;
                }
            }
        }

        return dummy.next;

    }
}
