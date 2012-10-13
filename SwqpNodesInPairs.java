/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(head == null || head.next == null) return head;
		
		ListNode p = new ListNode(-1);
		p.next = head;
		head = p;
		ListNode q = p.next;
		ListNode r = q.next;
		ListNode s = r.next;
		
		while(s!=null && s.next!=null){
			r.next = q;
			p.next = r;
			q.next = s;
			
			p = q;
			q = p.next;
			r = q.next;
			s = r.next;
		}
		
		r.next = q;
		p.next = r;
		q.next = s;
		
		return head.next;
        
    }
}