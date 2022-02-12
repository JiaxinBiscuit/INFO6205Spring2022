public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        ListNode prev = null;

        for(int i=0; i < n ; i++){
            fast = fast.next;
        }

        while(fast !=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;

        return dummy.next;

    }
}
