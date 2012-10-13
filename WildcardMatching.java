//dp: could not pass the large test. TLE
public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	String pr="";
		boolean cstar = false;
		int count = 0;
		for(int i=0; i<p.length(); i++){
			if(p.charAt(i)!='*'){
				pr+= p.charAt(i);
				cstar=false;
			}
			else{
				if(!cstar){
					cstar=true;
					pr+=p.charAt(i);
				}
			}
			
		}
		
    	int lens = s.length();
		int lenp = pr.length();
		
		if(lenp==0)
			return lens==0;
		else if (lens== 0)
            return pr.equals("*");
        
		int[][] path = new int[lenp+1][lens+1];
		path[0][0] =1;
		
		for(int i=1; i<lenp+1; i++){
			if(pr.charAt(i-1)=='*')
				path[i][0] =1;
			else
				break;
		}
		
		for(int i=1; i<lenp+1; i++)
			for(int j=1; j<lens+1; j++){
				if(pr.charAt(i-1)=='*'){
					if(path[i-1][j]==1 || path[i][j-1]==1 || path[i-1][j-1]==1)
						path[i][j]=1;
				}
				else if(pr.charAt(i-1)=='?'){
					if(path[i-1][j-1]==1)
						path[i][j]=1;
				}
				else{
					if(pr.charAt(i-1)==s.charAt(j-1) && path[i-1][j-1]==1)
						path[i][j]=1;
				}				
			}
		
		if(path[lenp][lens]==0)
			return false;
		else
			return true;
    }
}





//recursion: Could not pass the large test. TLE
public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
 
        int i = 0, j = 0;
 
        //the following is a recursive one, it timed out on large input
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (s.length() == 0) {
            return p.equals("") || allStar(p);
        }
 
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
            return isMatch(s.substring(1), p.substring(1));
        }
 
        if (p.charAt(0) == '*') {
            return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
        }
 
        return false;
    }
 
    public boolean allStar (String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                return false;
            }
        }
 
        return true;
    }
}