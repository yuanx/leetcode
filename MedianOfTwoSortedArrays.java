// Use binary search to pass the test
// reference: http://ideone.com/FtqjM
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lenA = A.length;
        int lenB = B.length;
        if(lenA == 0 && lenB == 0)
            return 0;
        else if(lenA==0){
            if(lenB%2 == 1)
                return B[lenB/2];
            else
                return (B[lenB/2]+B[lenB/2-1])/2.0;
        }
        else if(lenB == 0){
            if(lenA%2 == 1)
                return A[lenA/2];
            else
                return (A[lenA/2]+A[lenA/2-1])/2.0;            
        }
        else if(lenA < lenB)
            return medianSortedArrays(A,B,0,0,lenA-1,lenB-1);
        else
            return medianSortedArrays(B,A,0,0,lenB-1,lenA-1);
    			        
    }

	public double medianOffour(int a, int b, int c, int d){
		int min = Math.min(d, Math.min(c, Math.min(b,a)));
		int max = Math.max(d, Math.max(c, Math.max(b,a)));
		return (a+b+c+d-max-min)/2.0;
	}
	
	public double medianOfthree(int a, int b, int c){
		int min = Math.min(c, Math.min(b,a));
		int max = Math.max(c, Math.max(b,a));
		return (a+b+c-min-max);
	}
	
	public double medianSortedArrays(int A[], int B[], int startA, int startB, int endA, int endB){
		int n = endA-startA+1;
		int m = endB-startB+1;
		
		int idxA = (endA+startA+1)/2;
		int idxB = (endB+startB+1)/2;
		
		if(n==1){
			if(m==1){
				return (A[startA]+B[startB])/2.0;
			}
			if(m%2 == 1){
				return (B[(endB+startB)/2]+medianOfthree(A[startA], B[(endB+startB)/2-1], B[(endB+startB)/2+1]))/2;				
			}
			else
				return medianOfthree(A[startA], B[(endB+startB+1)/2-1], B[(endB+startB+1)/2]);			
		}
		
		if(n==2){
			if(m == 2){
				return medianOffour(A[startA],A[endA],B[startB],B[endB]);
			}
			if(m%2==1){
				return medianOfthree(B[(endB+startB)/2], Math.min(A[startA],B[(endB+startB)/2+1]), Math.max(A[endA],B[(endB+startB)/2-1]));
			}
			else
				return medianOffour(B[(endB+startB+1)/2], B[(endB+startB+1)/2-1],Math.min(A[startA],B[(endB+startB+1)/2+1]), Math.max(A[endA],B[(endB+startB+1)/2-2]));
		}
		
		int minRemoved;
		if(A[idxA] <= B[idxB]){
			if(n%2==0) idxA--;
			minRemoved = Math.min(idxA-startA, m-idxB+startB-1);
			return medianSortedArrays(A,B,startA+minRemoved,startB,endA,endB-minRemoved);
		}
		else{
			if(m%2 == 0) idxB--;
			minRemoved = Math.min(n-idxA+startA-1, idxB-startB);
			return medianSortedArrays(A,B,startA, startB+minRemoved, endA-minRemoved, endB);
		}
		
	}
}