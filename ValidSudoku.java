public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	for(int i=0; i<9; i++)
			for(int j=0; j<9; j++){
				if(board[i][j] == '.')
					continue;
				else{
					char temp = board[i][j];
					board[i][j] = 'C';
					if(!isvalid(board, i, j, temp-'0')){
						board[i][j]=temp;
						return false;
					}
					else
						board[i][j]=temp;
				}
			}
            
            return true;
		
        
    }

	public boolean isvalid(char[][] board, int x, int y, int t){
		char temp = (char)('0'+t);
		for(int i=0; i<9; i++){
			if(board[x][i] == temp || board[i][y] == temp)
				return false;
		}
		
		int bx = x/3;
		int by = y/3;
		for(int p=bx*3; p<bx*3+3; p++)
			for(int q=by*3; q<by*3+3; q++){
				if(board[p][q]== temp)
					return false;
			}

		return true;	
	}
}