public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(num.length==3) return num[0]+num[1]+num[2];
        
        int j = num.length-1;
        int p;
        int min = Integer.MAX_VALUE;
        int result=0;
        
        for(int k=num.length-1; k>1; k--){
            for(int i=0; i<num.length-k; i++){
                p = i+1;
                j = i+k;
                while(p<j){
                    int temp = num[i]+num[p]+num[j];
                    if(Math.abs(temp-target)<min){
                        min = Math.abs(temp-target);
                        result = temp;
                    }
                    p++;
                }
            }
        }
        
        return result;
        
    }
}