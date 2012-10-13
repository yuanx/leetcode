public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(height.length == 1) return 0;
        
        int i = 0;
        int j = height.length-1;
        int localmax = 0;
        int max =0;
        int lasti,lastj;
        
        while(j>i){
            if(height[i]<height[j]){
                localmax = (j-i) * height[i];
                max = max > localmax ? max : localmax;
                lasti = height[i];
                while(++i<j && height[i]<=lasti);
            }
            else{
                localmax = (j-i) * height[j];
                max = max > localmax ? max : localmax;
                lastj = height[j];
                while(--j>i && height[j]<=lastj);
                
            }
        }
        
        return max;
        
    }
}