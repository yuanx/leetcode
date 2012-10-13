public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sign = 1;
		if(x<0){
			x *= -1;
			sign *= -1;
		}
		int res = 0;
		while(x>0){
			res = res*10 + x%10;
			x /= 10;
		}
		
		return res*sign;
    }
}