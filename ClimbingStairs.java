// RECURSIVE SOLUTION
public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(n==0) return 0;
        
        int[] cache = new int[n];
        
        return getStairs(n, cache);
        
    }
    
    public int getStairs(int n, int[] cache){
        if(n==1) return 1;
        if(n==2) return 2;
        
        if(cache[n-1] >0)
            return cache[n-1];
        else{
            cache[n-1] = getStairs(n-1,cache) + getStairs(n-2,cache);
            return cache[n-1];
        }
    }
}

// DP SOLUTION
public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int i = 1;
        int j = 2;
        
        if(n==1) return 1;
        if(n==2) return 2;
        int p = 3;
        
        for(int k=3; k<=n; k++){
            p = i+j;
            i = j;
            j = p;
            
        }
        
        return p;
        
    }
}