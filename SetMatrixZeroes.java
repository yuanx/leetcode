public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int zero_frow = 0;
		int zero_fcol = 0;
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		for(int i=0; i<cols; i++){
			if(matrix[0][i] == 0){
				zero_frow = 1;
				break;
			}
		}
		
		for(int i=0; i<rows; i++){
			if(matrix[i][0] == 0){
				zero_fcol = 1;
				break;
			}
		}
		
		for(int i=1; i<rows; i++)
			for(int j=1; j<cols; j++){
				if(matrix[i][j] == 0){
					matrix[i][0] =0;
					matrix[0][j] =0;
				}
					
			}
		
		for(int j=1; j<cols; j++){
			if(matrix[0][j] == 0){
				for(int i=1; i<rows; i++)
					matrix[i][j] = 0;
			}
		}
		
		for(int i=1; i<rows; i++){
			if(matrix[i][0] ==0){
				for(int j=1; j<cols; j++)
					matrix[i][j] = 0;
			}
		}
		
		if(zero_frow == 1){
			for(int i=0; i<cols; i++)
				matrix[0][i] = 0;
		}
		
		if(zero_fcol == 1){
			for(int i=0; i<rows; i++)
				matrix[i][0] = 0;
		}
		
        
    }
}