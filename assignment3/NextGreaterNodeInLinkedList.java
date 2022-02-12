public class NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNode head) {
        if(head == null){
            return new int[1];
        }

        ListNode cur = head;
        ListNode next = null;

        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        int[] res = new int[count];

        int i = 0;
        cur = head;
        next = cur.next;
        while(cur != null){
            if(next != null && cur.val < next.val){
                res[i] = next.val;
            }else{
                while(next != null && cur.val >= next.val){
                    next = next.next;
                }
                if(next == null){
                    res[i] = 0;
                } else{
                    res[i] = next.val;
                }
            }
            i++;
            cur = cur.next;
            if(cur != null){
                next = cur.next;
            }
        }

        return res;
    }
}
