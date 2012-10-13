public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int maxnow = 0;
        int maxall = A[0];
        
        for(int i=0; i<A.length; i++){
            maxnow = Math.max(0, maxnow+A[i]);
            if(maxnow>0)
                maxall = Math.max(maxall, maxnow);
            else
                maxall = Math.max(maxall,A[i]);
        }
        
        return maxall;
        
    }
}