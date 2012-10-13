public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int len = s.length();
		boolean hasdot = false;
		boolean hase = false;
		boolean hasnum = false;
		
		if(len==0) return false;
		
		// get the first non-space charater
		int start = 0;
		while(start<len){
			if(s.charAt(start)==' ')
				start++;
			else
				break;
		}
		
		// all spaces
		if(start==len) return false;
		
		// get last non-space character
		int end = len-1;
		while(end>start){
			if(s.charAt(end)==' ')
				end--;
			else
				break;
		}
		
		// deal with "+" and "-"
		if(s.charAt(start)=='+' || s.charAt(start)=='-')
			start++;
		else if(s.charAt(start)=='e')
			return false;
			
		// start validation
		for(int i=start; i<=end; i++){
			// deal with '.'
			if(s.charAt(i)=='.'){
				if(hasdot)
					return false;
				else
					hasdot = true;
			}
			else if(s.charAt(i)=='e'){
                if(!hasnum || hase || i==end ||(i==end-1 && (s.charAt(i+1)=='+' || s.charAt(i+1)=='-'))) //different invalid casse: e34, 34ee, 34e+
                    return false;
				else{
				 	if(s.charAt(i+1)=='-' || s.charAt(i+1)=='+')
						i++;
					hase = true;
                    hasdot = true; // after "e" we cannot have any "."
				}
			}
			else if(s.charAt(i)>='0' && s.charAt(i)<='9')
				hasnum = true;
			else
				return false;			
		}
		
		if(hasnum)
			return true;
		else
			return false;
        
    }
}