import java.util.LinkedList;

public class Question2 {
    public ListNode sumTwoList(ListNode head1, ListNode head2){
        if(head1 == null && head2 == null){
            return null;
        }
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }

        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode dummy = new ListNode(0);
        ListNode cur = null;
        int carry = 0;

        while(cur1 != null || cur2 != null){
            int val1 = cur1 == null? 0:cur1.val;
            int val2 = cur2 == null? 0:cur1.val;
            int sum = val1 + val2 + carry;
            int curVal = sum % 10;
            carry = sum / 10;
            cur = new ListNode(curVal);
            dummy.next = cur;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        if(carry != 0){
            cur.next = new ListNode(carry);
        }

        return dummy.next;

    }
}
