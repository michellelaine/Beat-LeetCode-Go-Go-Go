//Merge Sort
//Time: O(nlogn), space: O(1)????should be O(n)
/*
148. Sort List
Sort a linked list in O(n log n) time using constant space complexity.
*/

/*
defination for the singly linkedlist
public class ListNode {
	ListNode next;
	int val;
	ListNode(int x){
		val = x;
		next = null;
	}
}
*/

public ListNode sortList(ListNode head){
	if(head == null || head.next == null) {
		return head;
	}

	//current layer
	ListNode mid = getMid(head);
	ListNode newHead = mid.next;
	mid.next = null;
	//sort left part and right part
	head = sortList(head);
	newHead = sortList(newHead);
	head = merge(head, newHead);

	return head;
 }

 private ListNode getMid(ListNode head) {
 	ListNode slow = head;
 	ListNode fast = head.next;
 	while(fast != null && fast.next != null) {
 		slow = slow.next;
 		fast = fast.next.next;
 	}
 	return slow;
 }

 private ListNode merge(ListNode head1, ListNode head2){
 	ListNode dummy = new ListNode(0);
 	ListNode head = dummy;

 	while(head1 != null && head2 != null) {
 		if(head1.val < head2.val){
 			head.next = head1;
 			head1 = head1.next;
 		}else {
 			head.next = head2;
 			head2 = head2.next;
 		}
 		head = head.next;
 	}

 	if(head1 == null){
 		head.next = head2;
 	}
 	if(head2 == null){
 		head.next = head1;
 	}

 	return dummy.next;
 }





