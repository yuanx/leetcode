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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(head==null || head.next == null) return head;
        if(k == 1) return head;
		
		ListNode p = new ListNode(-1);
		p.next = head;
		head = p;
		ListNode q = p.next;
		ListNode r = q;
        ListNode s;
		
		while(r!= null){
			r = q;
			for(int i= 1; i<k; i++){
				if(r==null)
					break;
				else
					r =r.next;
			}
            if(r==null) break;
			s = r.next;
			reverse(q,r);
			p.next = r;
			q.next = s;
			
			p = q;
			q = s;
			
		}
		return head.next;
    }
	
	public void reverse(ListNode p, ListNode q){
		if(p.next != q)
			reverse(p.next, q);
		
		p.next.next = p;
		
	}
}