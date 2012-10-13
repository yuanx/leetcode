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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || head.next == null) return head;
        
        int count = 0;
        ListNode tt = head;
        while(tt != null){
            count ++;
            tt = tt.next;
        }
        
        while(n>count)
            n = n-count;
            
        if(n==count) return head;
        
        ListNode p = new ListNode(-1);
        p.next = head;
        head = p;
        p= p.next;
        ListNode q = p;
        
        for(int i=0; i<n; i++){
            q = q.next;
        }
        
        
        while(q.next != null){
        	q = q.next;
        	p = p.next;
        }
        
        q.next = head.next;
        head.next = p.next;
        p.next = null;
        
        return head.next;
        
    }
}