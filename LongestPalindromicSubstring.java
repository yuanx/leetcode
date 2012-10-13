//DP
public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
		if(len==1) return s;
		
		int longest = 0;
		int start = 0;
		
		for(int i=0; i<len; i++){
			int t = lengthWithCurrent(s,i);
			if(t>longest){
				longest = t;
				start = i-longest+1;
			}
		}
		
		return s.substring(start,start+longest);
    }

	public int lengthWithCurrent(String s, int end){
		int re = 1;
		for(int i=0; i<end; i++){
			if(s.charAt(i)==s.charAt(end) && isPalindrom(s,i,end)){
				return end-i+1;
			}				
		}
		return re;
	}
	
	public boolean isPalindrom(String s, int start, int end){
		while(end-- > start++)
			if(s.charAt(start) != s.charAt(end)) return false;
		
		return true;
				
	}
}