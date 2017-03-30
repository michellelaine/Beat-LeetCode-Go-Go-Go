public ListNode insertInSortedList(ListNode head, ListNode node) {
	//head node > node || head == none
	if(head == null || head.val > val) {
		node.next = head;
		return node;
	}

	//insert inside of the list
	ListNode cur = head;
	while(cur.next != null) {
		if(val <= cur.val){
			ListNode temp = cur.next;
			cur.next = node;
			node = temp;
		}
		cur = cur.next;
	}
    //node > list
    cur.next = node;
    return head;
}
