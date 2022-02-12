import javax.xml.soap.Node;

public class CopyListWithRandomPointer {
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}



    class Solution {
        public Node copyRandomList(Node head) {
            if(head == null){
                return null;
            }

            Node dummy = new Node(0);
            Node cur1 = head;
            Node cur2 = new Node(cur1.val);
            dummy.next = cur2;

            while(cur1.next != null){
                cur2.next = new Node(cur1.next.val);
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

            if(cur1.next == null){
                cur2.next = null;
            }

            cur1 = head;
            cur2 = dummy.next;

            while(cur2 != null){
                if(cur1.random == null){
                    cur2.random = null;
                }else{
                    int index = findNode(head,cur1);
                    Node temp = dummy.next;
                    for(int i=0; i<index; i++){
                        temp = temp.next;
                    }
                    Node randomNode = temp;
                    cur2.random = randomNode;
                }
                cur2 = cur2.next;
                cur1 = cur1.next;
            }

            return dummy.next;
        }



        public int findNode(Node head, Node target){
            Node cur = head;
            int index = 0;
            while(cur != null){
                if(cur == target.random){
                    return index;
                }

                index++;
                cur = cur.next;
            }

            return -1;
        }


    }
}
