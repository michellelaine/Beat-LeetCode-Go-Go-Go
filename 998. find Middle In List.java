/* 写的都是什么鬼
public ListNode findMiddleInList(ListNode head) {
	if(head == null) {
		return null;
	}
    ListNode cur = head;
    int n = 0;

    //find the number of n by traverse all the node
	while(cur != null) {
		cur = cur.next;
		n++;
	}
    
    ListNode middle = head;
	for(int i = n; i > n / 2 && (cur != null); n--) {
 		middile = middle.next;
	}

	return middle;

}*/

public ListNode findMiddleInList(ListNode head) {
    if(head == null) {
    	return null;
	}

	ListNode slow = head;
	ListNode fast = head.next;

	while(fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;
	}
	return slow;
}
