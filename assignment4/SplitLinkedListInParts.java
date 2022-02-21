public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        if(head == null ){
            return new ListNode[k];
        }

        int count = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            count++;
        }

        int size = count / k;
        int extra = count % k;
        ListNode[] res = new ListNode[k];
        cur = head;

        for(int i = 0; i < k; i++){
            ListNode subHead = cur;
            for(int j = 0; j < size + (extra > 0? 1:0)-1;j++){
                if(cur != null){
                    cur = cur.next;
                }
            } if(cur != null){
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            res[i] = subHead;
            extra--;
        }

        return res;


    }
}
