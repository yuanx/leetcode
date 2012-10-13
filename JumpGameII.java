public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length<=1) return 0;
        
        int last = A.length-1;
        int count = 0;
        while(last>0){
            for(int i=0; i<last; i++){
                if(A[i]+i>=last){
                    count++;
                    last = i;
                }
            }
        }
        
        return count;
    }
}