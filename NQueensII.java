public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function        
    	if(n<=0) return 0;
		int[] place = new int[n];
		int[] count = new int[1];
		
		placeQueens(count,place,n,0);
		return count[0];
		
		
    }

	public void placeQueens(int[] count, int[] place, int n, int level){
		if(level == n){
			count[0]++;
			return;
		}
		
		for(int i=0; i<n; i++){
			if(canplace(level,place,i)){
				place[level] = i;
				placeQueens(count,place,n,level+1);
			}
		}
	}
	
	public boolean canplace(int i, int[] place, int n){
		for(int j=0; j<i; j++){
			if(place[j]==n)
				return false;
			if(Math.abs(n-place[j]) == i-j)
				return false;
		}
		
		return true;
	}
}