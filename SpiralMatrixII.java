public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int[][] matrix = new int[n][n];
		
		if(n==1){
			matrix[0][0]=1;
			return matrix;
		}
		
		int i=0;
		int j=n-1;
		int m = 1;
		
		while(j>=i){
			m = spiral(m, i, j, matrix);
			i++;
			j--;
		}
		return matrix;
    }

	public int spiral(int m, int i, int j, int[][] matrix){
		if(i==j){
			matrix[i][i]=m;
			m++;
			return m;
		}
		
		for(int p=i; p<j; p++){
			matrix[i][p]=m;
			m++;
		}
		
		for(int p=i; p<j; p++){
			matrix[p][j]=m;
			m++;
		}		
		
		for(int p=j; p>i; p--){
			matrix[j][p]=m;
			m++;
		}
		
		for(int p=j; p>i; p--){
			matrix[p][i]=m;
			m++;
		}
		
		return m;		
	}
}