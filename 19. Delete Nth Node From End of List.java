public ListNode removeNthFromEnd(ListNode head, int n) {
	if(head == null) {
		return null;
	}
  //dummy node
	ListNode dummy = new ListNode(-1);
	dummy.next = head;

	ListNode fast = dummy;
	ListNode slow =dummy;

	while(n > 0) {
		fast = fast.next;
		n--;
	}

	while(fast.next != null) {
		fast = fast.next;
		slow = slow.next;
	}

	slow.next = slow.next.next;
	return dummy.next;
}
