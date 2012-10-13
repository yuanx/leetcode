public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(A.length == 0) return -1;
		if(A.length == 1) return (A[0] == target ? 0:-1);
		
		int i = 0;
		int j = A.length-1;
		
		while(j>=i){
			int m = (i+j)/2;
			if(A[m] == target)
				return m;
			else if(A[m] > target){
				if(A[m] < A[j])
					j = m-1;
				else{
					if(target>A[j])
						j = m-1;
					else
						i = m+1;
				}				
			}
			else{
				if(A[m] < A[j]){
					if(target>A[j])
						j = m-1;
					else
						i = m+1;
				}
				else{
						i = m+1;
				}
			}
		}
		return -1;
        
    }
}