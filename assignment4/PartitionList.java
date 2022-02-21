public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode greaterHead = new ListNode(0);
        ListNode curGreater = greaterHead;
        ListNode lesserHead = new ListNode(0);
        ListNode curLesser = lesserHead;
        ListNode cur = head;

        while(cur != null){
            if(cur.val < x){
                curLesser.next = cur;
                curLesser = curLesser.next;
                cur = cur.next;
            } else {
                curGreater.next = cur;
                curGreater = curGreater.next;
                cur = cur.next;
            }
        }

        curGreater.next = null;
        curLesser.next = greaterHead.next;

        return lesserHead.next;

    }
}
