public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = findMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(rightHead);

        return merge(leftNode, rightNode);
    }


    private ListNode findMid(ListNode head){
        if (head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode (0);
        ListNode cur1 = null;
        ListNode cur2 = null;

        if (head1.val < head2.val){
            dummy.next = head1;
            cur1 = head1.next;
            cur2 = head2;
        } else {
            dummy.next = head2;
            cur1 = head1;
            cur2 = head2.next;
        }

        ListNode cur = dummy.next;
        while (cur1 != null && cur2 != null){
            if (cur1.val < cur2.val){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }

        if (cur1 != null){
            cur.next = cur1;
        }

        if (cur2 != null){
            cur.next = cur2;
        }

        return dummy.next;

    }
}
