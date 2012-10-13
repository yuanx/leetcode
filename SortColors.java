//Solve this by famous dutch flag algorithm
public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		int f=0;
		int l=A.length-1;
		int i=0;
		
		while(i<=l){
			if(A[i]==1)
				i++;
			else if(A[i]==0){
				A[i]=A[f];
				A[f]=0;
				f++;
				i++;
			}
			else{
				A[i]=A[l];
				A[l]=2;
				l--;
			}
		}
        
    }
}