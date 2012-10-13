public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        if(A.length==0) return 1;
        int max = 0;
        
        for(int i=0; i<A.length; i++){
            max = max > A[i] ? max : A[i];
        }
        
        int[] arr = new int[max];
        
        for(int i=0; i<A.length; i++){
            if(A[i]>0){
                arr[A[i]-1] = 1;
            }
        }
        
        for(int i=0; i<max; i++){
            if(arr[i] == 0)
                return i+1;
        }
        
        return max+1;
        
        
        
    }
}