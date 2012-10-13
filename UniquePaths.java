//simple DP solution, O(n^2) time and space
public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(m==0 || n==0) return 0;
        if(m==1 || n==1) return 1;
        
        int[][] path = new int[m][n];
        path[0][0]=0;
        
        for(int i=1; i<m; i++)
            path[i][0] = 1;
        
        for(int i=1; i<n; i++)
        	path[0][i] = 1;
        
        for(int i=1; i<m; i++)
        	for(int j=1; j<n; j++){
        		path[i][j] = path[i-1][j]+path[i][j-1];
        	}
        return path[m-1][n-1];
    }
}