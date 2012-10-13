public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(m==0 || n==0) return 0;
        if(m==1){
        	for(int i=0; i<n; i++)
        		if(obstacleGrid[0][i]==1)
        			return 0;
        	return 1;
        }
        if(n==1){
        	for(int i=0; i<m; i++)
        		if(obstacleGrid[i][0]==1)
        			return 0;
        	return 1;
        }
        int[][] path = new int[m][n];
        for(int i=0; i<m; i++){
        	if(obstacleGrid[i][0]==0)
        		path[i][0]=1;
        	else{
        		path[i][0]=0;
        		break;
        	}
        }
        
        for(int i=0; i<n; i++){
        	if(obstacleGrid[0][i]==0)
        		path[0][i]=1;
        	else{
        		path[0][i]=0;
        		break;
        	}
        }
        
        for(int i=1; i<m; i++)
        	for(int j=1; j<n; j++){
        		if(obstacleGrid[i][j]==1)
        			path[i][j]=0;
        		else
        			path[i][j] = path[i-1][j] + path[i][j-1];
        	}
        return path[m-1][n-1];
    }
}