public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		if(rows == 1 && cols == 1) 
			return (matrix[0][0] == target ? true : false);
        int i = 0;
		int p = rows*cols-1;
		
		while(p>=i){
			int m = (p+i)/2;
			int x = m/cols;
			int y = m%cols;
			
			if(matrix[x][y] == target)
				return true;
			else if(matrix[x][y] > target)
				p = m-1;
			else
				i = m+1;
		}
		
		return false;
    }
}