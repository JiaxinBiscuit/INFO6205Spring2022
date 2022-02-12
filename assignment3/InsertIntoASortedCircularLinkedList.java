public class InsertIntoASortedCircularLinkedList {

        public ListNode insert(ListNode head, int insertVal) {
            ListNode insertNode = new ListNode(insertVal);
            if(head == null){
                insertNode.next = insertNode;
                return insertNode;
            }

            if(head.next == head){
                head.next = insertNode;
                insertNode.next = head;
                return head;
            }


            ListNode prev = head;
            ListNode cur = prev.next;
            ListNode temp = prev;
            while(prev.val <= cur.val){
                prev = cur;
                cur = cur.next;
                if(prev == temp){
                    break;
                }
            }
            ListNode startNode = cur;

            while(insertVal > cur.val){
                prev = cur;
                cur = cur.next;
                if(cur == startNode){
                    break;
                }
            }

            prev.next = insertNode;
            insertNode.next = cur;
            return head;

        }
}
