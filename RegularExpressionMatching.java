public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lenS = s.length();
    	int lenP = p.length();
		if(lenP == 0 && lenS == 0) 
			return true;
		else if(lenP == 0)
			return false;
		else if(lenS == 0){
			if(lenP%2==0){
                int t = 1;
                while(t<lenP){
                    if(p.charAt(t) != '*')
                        return false;
                    t+=2;
                }
    		    return true;    
			}
			
			else
				return false;
		}
		
		
		int scanS = 0;
		int scanP = 0;
		
		if(scanP+1<lenP && p.charAt(scanP+1)=='*'){
			while(scanS<lenS && (p.charAt(scanP) == s.charAt(scanS) || p.charAt(scanP) == '.')){
				if(isMatch(s.substring(scanS), p.substring(scanP+2)))
					return true;
				scanS++;
			}
			return isMatch(s.substring(scanS), p.substring(scanP+2));
		}
		else{
			return ((p.charAt(scanP) == s.charAt(scanS) || p.charAt(scanP) == '.') && isMatch(s.substring(scanS+1), p.substring(scanP+1)));
		}
			
		
		
    }
}