public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }

        if(l1 == null){return l2;}
        if(l2 == null){return l1;}

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;

        while(cur1 != null || cur2 != null){
            int l1Value = (cur1 == null)? 0:cur1.val;
            int l2Value = (cur2 == null)? 0:cur2.val;
            int sum = l1Value + l2Value + carry;
            carry = sum / 10;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            if(cur1 != null){
                cur1 = cur1.next;
            }
            if(cur2 != null){
                cur2 = cur2.next;
            }
        }

        if(carry > 0){
            prev.next = new ListNode(carry);
        }


        return dummy.next;

    }
}
