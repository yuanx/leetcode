public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Integer> re = new ArrayList<Integer>();
    	int m = matrix.length-1;
        if(m==-1) return re;
		int n = matrix[0].length-1;               
		int i =0;
		while(m>=i && n>=i){
			spiral(matrix, i, i, m, n, re);
			m--;
			n--;
			i++;
		}			
		
		return re;        
    }

	public void spiral(int[][] matrix, int i, int j, int m, int n, ArrayList<Integer> re){
		if(i==m){
			for(int p=j; p<=n; p++)
				re.add(matrix[i][p]);
			return;
		}
		
		if(j==n){
			for(int p=i; p<=m; p++)
				re.add(matrix[p][j]);
			return;
		}
		
		for(int p=j; p<n; p++)
			re.add(matrix[i][p]);
		
		for(int p=i; p<m; p++)
			re.add(matrix[p][n]);
		
		for(int p=n; p>j; p--)
			re.add(matrix[m][p]);
		
		for(int p=m; p>i; p--)
			re.add(matrix[p][i]);
	}
}