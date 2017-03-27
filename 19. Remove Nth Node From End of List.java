/*19. Remove Nth Node From End of List*/
/*Given a linked list, 
remove the nth node from the end of list and return its head.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //set dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        //set fast/slow pointer
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        //move fast pointer to nth 
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        
        //locate the the fast/slow pointer to delete the node
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        //delete the nth node from the end
        slow.next = slow.next.next;
        return dummy.next;
    }
}