public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0) return false;
		if(x>=0 && x<10) return true;
		
		int div = 1;
		while(x/div>=10){
			div *= 10;
		}
		
		while(x!=0){
			int h = x/div;
			int l = x%10;
			if(h!=l) return false;
			x = (x%div)/10;
			div /= 100;
		}
		
		return true;
    }
}