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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || head.next == null) return head;

    	ListNode p = head;
		ListNode q = head.next;
		
		while(q!= null){
			if(p.val != q.val){
				p = p.next;
			}			
			q = q.next;
			p.next = q;
		}
        
        return head;
    }
}