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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		ListNode fh = new ListNode(Integer.MIN_VALUE);
		fh.next = l2;
		ListNode l11 = l1;
		ListNode l12 = l11.next;
		ListNode l21 = fh;
		ListNode l22 = l21.next;
		
		while(l12 != null && l22 != null){
			if(l11.val>l22.val){
				l21 = l22;
				l22 = l22.next;
			}
			else{
				l21.next = l11;
				l11.next = l22;
				
				l11 = l12;
				l12 = l11.next;
				
				l21 = l21.next;
			}
		}
		
		if(l12 == null){
			while(l22!=null && l22.val<l11.val){
				l21 = l22;
				l22 = l22.next;
			}
			l21.next = l11;
			l11.next = l22;
		}
		else if(l22 == null){
			l21.next = l11;
		}
		
		return fh.next;
		
        
    }
}