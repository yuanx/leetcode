public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n<=1) return 1;
        if(n==2) return 2;
        int res = 0;
        for(int i=1; i<=n; i++)
            res += numTrees(i-1)*numTrees(n-i);
        
        return res;
        
    }
}