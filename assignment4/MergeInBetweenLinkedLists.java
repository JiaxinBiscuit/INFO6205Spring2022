public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list1 == null || a < 0 || b < 0 ){
            return null;
        }

        if(list2 == null){return list1;}
        ListNode subHead = list1;
        ListNode subTail = list1;
        for(int i = 0 ;i < a-1 ; i++){
            subHead = subHead.next;
        }

        for(int i = 0 ;i < b+1 ; i++){
            subTail = subTail.next;
        }

        ListNode tail = list2;
        while(tail.next != null){
            tail = tail.next;
        }

        subHead.next=list2;
        tail.next = subTail;

        return list1;

    }
}
