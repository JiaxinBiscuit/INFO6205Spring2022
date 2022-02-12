public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
            if(head == null || head.next == null){
        return head;
    }

    ListNode dummyOdd = new ListNode(0);
    ListNode dummyEven = new ListNode(0);
    ListNode cur = head;
    ListNode curOdd = dummyOdd;
    ListNode curEven = dummyEven;

        while(cur != null && cur.next != null){
        curOdd.next = cur;
        cur = cur.next;
        curOdd = curOdd.next;
        curEven.next = cur;
        cur = cur.next;
        curEven = curEven.next;
    }

        if(cur != null){
        curOdd.next = cur;
        curOdd = curOdd.next;
    }

    curEven.next = null;
    curOdd.next = dummyEven.next;

        return dummyOdd.next;
    }
}
