public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int re[] = new int[2];
		
		re[0] = searchFirst(A,target);
		re[1] = searchLast(A,target);
		
		return re;
    }

	public int searchFirst(int[] A, int target){
		if(A.length==0) return -1;
		if(A.length==1) return (A[0] == target ? 0:-1);
		
		int i=0;
		int j=A.length-1;
		
		while(j>i){
			int m = (i+j)/2;
			if(A[m]>target)
				j = m-1;
			else if(A[m]<target)
				i = m+1;
			else
				j = m;
		}
		
		if(i==j){
			if(A[i] == target)
				return i;
			else
				return -1;
		}
		
		return -1;					
	}
	
	public int searchLast(int[] A, int target){
		if(A.length==0) return -1;
		if(A.length==1) return (A[0] == target ? 0:-1);
		
		int i=0;
		int j=A.length-1;
		
		while(j>i){
			if(A[i] == target && j == i+1){
				if(A[j] == target)
					return j;
				else
					return i;
			}
			
			int m = (i+j)/2;
			if(A[m]>target)
				j = m-1;
			else if(A[m]<target)
				i = m+1;
			else
				i = m;
		}
		
		if(i==j){
			if(A[i] == target)
				return i;
			else
				return -1;
		}
		
		return -1;
		
	}
}