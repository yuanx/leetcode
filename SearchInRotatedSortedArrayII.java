/*
	binary search (O(logN)) is no longer feasible because of the duplicated elements.
	for example:
	origin array: [0,1,1,1,1,1,1,1,1]
	it can be rotated to : [1,0,1,1,1,1,1,1,1]
	and also raotated to : [1,1,1,1,1,1,1,0,1]
	both of tham are valid input, and 0 can be on both left side and right side of the middle element.
	
	We may change the binary search to make it work, but eventually the time complexity is O(N), so we should use linear search directly.

*/
public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        for(int i=0; i<A.length; i++){
            if(A[i] == target)
                return true;
        }
        
        return false;
        
    }
}