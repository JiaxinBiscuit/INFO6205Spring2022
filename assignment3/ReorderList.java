public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }

        ListNode mid = findMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode newRightHead = reverseList(rightHead);
        merge(head,newRightHead);

    }

    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private void merge(ListNode head1, ListNode head2){
        ListNode cur = head1;
        ListNode cur1 = head1.next;
        ListNode cur2 = head2;

        while(cur1 !=null && cur2 != null){
            cur.next = cur2;
            cur2 = cur2.next;
            cur = cur.next;
            cur.next = cur1;
            cur1 = cur1.next;
            cur = cur.next;
        }

        if(cur2 != null){
            cur.next = cur2;
        }


    }
}
