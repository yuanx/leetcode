public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<String> re = new ArrayList<String>();
		if(digits.length()==0){
			re.add("");
			return re;
		}
		char[][] pad = {
		    {'0'},
		    {'1'},
		    {'a','b','c'},
		    {'d','e','f'},
		    {'g','h','i'},
		    {'j','k','l'},
		    {'m','n','o'},
		    {'p','q','r','s'},
		    {'t','u','v'},
		    {'w','x','y','z'},
		  };
		
		getletters(digits, pad, re, "", 0);	
		return re;	        
    }

	public void getletters(String digits, char[][] pad, ArrayList<String> re, String str, int start){
		if(str.length() == digits.length()){
			re.add(str);
			return;
		}
		
		int temp = digits.charAt(start)-'0';
		for(int j=0; j<pad[temp].length; j++){
			getletters(digits, pad, re, str+pad[temp][j], start+1);
		}
	}
}