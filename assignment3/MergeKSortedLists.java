public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        if(lists == null || lists.length <= 1){
            return lists[0];
        }

        ListNode cur = null;
        for(int i = 0; i<lists.length; i++){
            ListNode newHead = mergeHelper(cur, lists[i]);
            cur = newHead;
        }


        return cur;
    }

    public ListNode mergeHelper(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null && cur2 != null){
            if(cur1.val<cur2.val){
                prev.next = cur1;
                cur1 = cur1.next;
            }else{
                prev.next = cur2;
                cur2 = cur2.next;
            }
            prev = prev.next;
        }

        if(cur1 == null){
            prev.next = cur2;
        }

        if(cur2 == null){
            prev.next = cur1;
        }
        return dummy.next;
    }

}
