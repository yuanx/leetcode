public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(A.length==0) return 0;
		
		int i = 0;
		int j = A.length-1;
		
		while(j>i){
			int m = (i+j)/2;
			if(A[m]== target)
				return m;
			else if(A[m] > target)
				j = m-1;
			else
				i = m+1;
		}
		
		if(target <= A[i])
			return i;
		else
			return i+1;
        
    }
}