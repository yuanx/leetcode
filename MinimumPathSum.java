public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int rows = grid.length;
		int cols = grid[0].length;
		int sum = 0;
		if(rows == 0) return 0;
		if(rows == 1){
			for(int i=0; i<cols; i++)
				sum += grid[0][i];
			return sum;
		}
		
		if(cols == 1){
			for(int i=0; i<rows;i++)
				sum += grid[i][0];
			return sum;
		}
		
		int[][] path = new int[rows][cols];
		path[0][0] = 0;
		for(int i=1; i<cols; i++){
			sum += grid[0][i-1];
			path[0][i] = sum;
		}
		sum = 0;
		
		for(int i=1; i<rows; i++){
			sum += grid[i-1][0];
			path[i][0] = sum;
		}
		
		for(int i=1; i<rows; i++)
			for(int j=1; j<cols; j++){
				int temp = Math.min(grid[i-1][j]+path[i-1][j], grid[i][j-1]+path[i][j-1]);
				path[i][j] = temp;
			}
		
		return path[rows-1][cols-1]+grid[rows-1][cols-1];
		
    }
}