public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int msize = matrix.length;
        
        if(msize==1) return;
        int i=0;
        int j=msize-1;
        
        while(i<j){
            rotateOutside(matrix, i, j);
        	i++;
        	j--;
        }
        
    }
    
    public void rotateOutside(int[][] matrix, int i, int j){
    	for(int k=0; k<j-i; k++){
    		swap(matrix, i, i+k, j-k, i);
    		swap(matrix, j-k, i, j, j-k);
    		swap(matrix, j, j-k, i+k, j);
    	}
    }
    
    public void swap(int[][] matrix, int i, int j, int k, int l){
    	int temp = matrix[i][j];
    	matrix[i][j] = matrix[k][l];
    	matrix[k][l] = temp;
    }
}