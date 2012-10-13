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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ListNode large = new ListNode(-1);
		ListNode small = new ListNode(-1);
		
		ListNode p = large;
		ListNode q = small;
		
		while(head!= null){
			if(head.val>=x){
				large.next = new ListNode(head.val);
				large = large.next;
			}
			else{
				small.next = new ListNode(head.val);
				small = small.next;
			}
            head =head.next;
		}
		
		small.next = p.next;
		return q.next;
        
    }
}