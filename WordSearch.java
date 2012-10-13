public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = board.length;
    	int n = board[0].length;
		
		if(word.length()>m*n) return false;
			
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++){
				if(board[i][j]==word.charAt(0)){
					int[][] used = new int[m][n];
					used[i][j]=1;
					if(findString(board,i,j,used,word.substring(1)))
						return true;
				}
			}
		return false;
    }

	public boolean findString(char[][] board, int i, int j, int[][] used, String word){
		if(word.length()==0)
			return true;
			
		char temp = word.charAt(0);
		for(int p=-1; p<2; p++)
			for(int q=-1;q<2;q++){
				if((i+p>=0 && i+p<board.length) && (j+q>=0 && j+q<board[0].length) && ((Math.abs(p))^(Math.abs(q)))!=0){
					if(board[i+p][j+q] == temp && used[i+p][j+q]==0){
						used[i+p][j+q]=1;
						if(findString(board, i+p, j+q, used, word.substring(1)))
							return true;
						used[i+p][j+q]=0;
					}
				}					
		}
		return false;
	}
}