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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        return addNumbers(l1,l2,0);
        
    }
    
    public ListNode addNumbers(ListNode l1, ListNode l2, int carry){
        ListNode r;
        int temp,c;
        
        if(l1==null && l2==null){
            if(carry == 0)
                return null;
            else{
                r = new ListNode(1);
                return r;
            }
                
            
        }
            
        
        
        if(l1== null){
            temp = l2.val + carry;
            if(temp>9){
                temp -= 10;
                c = 1;
            }
            else
                c = 0;
                
            r = new ListNode(temp);
            r.next = addNumbers(null,l2.next,c);            
        }
        else if(l2 == null){
            temp = l1.val + carry;
            if(temp>9){
                temp -= 10;
                c = 1;
            }
            else
                c = 0;
                
            r = new ListNode(temp);
            r.next = addNumbers(l1.next,null,c);
        }
        else{
            temp = l1.val + l2.val + carry;
            if(temp>9){
                temp -= 10;
                c = 1;
            }
            else
                c = 0;
            
            r = new ListNode(temp);
            r.next = addNumbers(l1.next, l2.next, c);            
        }
        
        return r;
    }
}