public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> re = new ArrayList<String[]>();

		if(n<=0) return re;
		int[][] place = new int[n][n];
		
		placeQueens(re,place,n,0);
		
		return re;
    }

	public void placeQueens(ArrayList<String[]> re, int[][] place, int n, int level){
		if(level == n){
			re.add(shape(place,n));
			return;
		}
		
		for(int i=0; i<n; i++){
			if(canplace(level,i,place,n)){
				place[level][i] = 1;
				placeQueens(re,place,n,level+1);
				place[level][i] = 0;
			}
		}
	}
	
	public boolean canplace(int i, int j, int[][] place, int n){
		for(int k=0; k<n; k++){
			if(k==i) continue;
			if(place[k][j]==1) return false;
			for(int m=0; m<n; m++){
				if(Math.abs(k-i)==Math.abs(m-j) && place[k][m] == 1)
				 	return false;
			}
		}
		
		return true;
	}
	
	public String[] shape(int[][] p, int n){
		String[] strs = new String[n];
		for(int i=0; i<n; i++){
			StringBuilder temp = new StringBuilder();
			for(int j=0; j<n; j++){
				if(p[i][j]==0)
					temp.append(".");
				else
					temp.append("Q");
			}
			strs[i]=temp.toString();
		}
		
		return strs;
	}
}