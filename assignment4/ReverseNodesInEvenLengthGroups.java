public class ReverseNodesInEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }


        ListNode cur = head;
        ListNode next = head;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode newHead = null;
        ListNode temp = null;

        int count = 1;
        while( cur != null){
            int i = 0;
            while(i < count & next != null){
                temp = next;
                next = next.next;
                i++;
            }

            if(next == null){
                count = i;
            }

            temp.next = null;

            if(count % 2 == 0){
                newHead = reverseList(cur);
                prev.next = newHead;
                prev = cur;
            }else{
                newHead = cur;
                prev.next = newHead;
                prev = temp;
            }

            cur = next;
            count++;
        }

        return dummy.next;

    }


    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;

        while(cur != null ){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
