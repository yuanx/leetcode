public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		if(A.length == 0) return 0;
		if(A.length == 1) return 1;
		if(A.length == 2) return (A[0] == A[1] ? 1 : 2);
		
		int p=0;
		int q=1;
		
		while(q<A.length && p<A.length){
			if(A[q] == A[p])
				q++;
			else{
				A[++p] = A[q];
			}
		}
		
		return p+1;
        
    }
}