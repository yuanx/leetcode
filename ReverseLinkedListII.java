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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(m==n) return head;
        
        ListNode first = new ListNode(-1);
    	first.next = head;
		ListNode p = head;
		ListNode q, r;
		head = first;
		
		for(int i=1; i<m; i++){
			first = first.next;
			p = p.next;
		}
		
		if(p.next == null)
			return head.next;
		
		q = p.next;
		r = q.next;
		int count = 1;
		while(count<n-m){
			q.next = p;
			p = q;
			q = r;
			r = q.next;
			count++;
		}
		
		q.next = p;
		
		first.next.next = r;
        first.next = q;
		
		
		return head.next;
    }
}