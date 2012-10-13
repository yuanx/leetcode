import java.util.Comparator;
import java.util.PriorityQueue;
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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int len = lists.size();
		if(len == 0) return null;
		if(len == 1) return lists.get(0);
		
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(len, LISTNODE_COMPARE);
		//fake a head
		ListNode h = new ListNode(-1);
		ListNode head = h;
		
		//enqueue the first node of each nodelist
		for(int i=0; i<len; i++){
			if(lists.get(i)!= null)
				queue.add(lists.get(i));			
		}

		
		while(!queue.isEmpty()){
			ListNode temp = queue.poll();
			h.next = temp;
			h = temp;
			if(temp.next != null)
				queue.add(temp.next);						
		}
		
		return head.next;
        
    }
	
	static final Comparator<ListNode> LISTNODE_COMPARE = new Comparator<ListNode>(){
		public int compare(ListNode i, ListNode j){
			return i.val-j.val;
		}
	};
}