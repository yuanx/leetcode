public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(n==0) return;
		if(m==0){
			while(--n >=0) A[n]=B[n];
            return;
		}
        int p = m+n-1;
		int i = m-1;
		int j = n-1;
		
		while(p >= 0){
            if(j<0) break;
            if(i<0){
                while(j >=0) A[j] = B[j--];
                break;
            }
			A[p--] = A[i] > B[j] ? A[i--] : B[j--];
		}
		    
    }
}