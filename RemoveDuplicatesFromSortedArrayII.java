public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(A.length == 0) return 0;
		if(A.length == 1) return 1;
		
		int p = 0;
		int q = 1;
		int count = 0;
		
		while(q<A.length){
			if(A[p]==A[q]){
				count++;
				if(count<2)	A[++p] = A[q];
			}
			else{
                A[++p] = A[q];
                count = 0;
			}
			q++;				
		}
		
		return p+1;
        
    }
}