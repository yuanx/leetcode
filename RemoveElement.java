public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function    	
		if(A.length==0) return 0;
        
        if(A.length == 1){
			if(A[0] == elem)
				return 0;
			return 1;
		}
		
		int p = 0;
		int q = A.length-1;
		
		while(q>p){
			if(A[p] != elem){
				p++;
				continue;
			}
			if(A[q] == elem){
				q--;
				continue;
			}
			int temp = A[p];
			A[p] = A[q];
			A[q] = temp;			
		}
		
        if(A[p] == elem)
		    return p;
        else
            return p+1;
    }
}