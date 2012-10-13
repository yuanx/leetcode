public class Solution {
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	char[][] fakeboard = new char[9][9];
		deepcopy(board, fakeboard);
		fillSudoku(fakeboard, 0, board);
    }

	public void fillSudoku(char[][] board, int c, char[][] realboard){
		if(c==81){
			deepcopy(board, realboard);
			return;
		}
		
		int x = c/9;
		int y = c%9;
		if(board[x][y] != '.')
			fillSudoku(board,c+1,realboard);
		else{
			for(int i=1; i<10; i++)
				if(canfill(board, x, y, i)){
					board[x][y]=(char)('0'+i);
					fillSudoku(board,c+1,realboard);
					board[x][y]='.';
				}
		}
	}
	
	public boolean canfill(char[][] board, int x, int y, int t){
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
	
	public void deepcopy (char[][] arr1, char[][] arr2){
		for(int i=0; i<arr1.length; i++)
			for(int j=0; j<arr1[0].length; j++)
				arr2[i][j] = arr1[i][j];
	}

}