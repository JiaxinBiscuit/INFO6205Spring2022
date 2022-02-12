public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }

        if(head.next == null){
            return true;
        }


        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode newRight = reverse(right);

        ListNode cur1 = head;
        ListNode cur2 = newRight;
        while(cur1 != null && cur2 != null){
            if(cur1.val == cur2.val){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }else{
                return false;
            }
        }


        return true;

    }

    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        return mid;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;

    }

}
