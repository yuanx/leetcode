//Slow version, could not pass judge large
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();

    	if(l1+l2!=l3) return false;

		if(l1==0) return s2.equals(s3) ? true : false;
		if(l2==0) return s1.equals(s3) ? true : false;
		
		if(s1.charAt(0)==s2.charAt(0) && s1.charAt(0) == s3.charAt(0)){
			return isInterleave(s1.substring(1), s2, s3.substring(1)) || isInterleave(s1,s2.substring(1),s3.substring(1));
		} 
		else if(s1.charAt(0) == s3.charAt(0))
			return isInterleave(s1.substring(1), s2, s3.substring(1));
		else if(s2.charAt(0) == s3.charAt(0))
			return isInterleave(s1, s2.substring(1), s3.substring(1));
		else
			return false;
        
    }
}

//substring is expensive, try to avoid using substring UPDATE: STILL FAIL THE JUDGE LARGE
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();		
		if(l1+l2!=l3) return false;
		
		return ifInterleave(s1,s2,s3,l1,l2,0,0,0);        
    }

	public boolean ifInterleave(String s1, String s2, String s3, int l1, int l2, int c1, int c2, int c3){
		if(c1 == l1) return s2.substring(c2).equals(s3.substring(c3)) ? true : false;
		if(c2 == l2) return s1.substring(c1).equals(s3.substring(c3)) ? true : false;
		
		if(s1.charAt(c1) == s2.charAt(c2) && s1.charAt(c1) == s3.charAt(c3)){
			return ifInterleave(s1,s2,s3,l1,l2,c1+1,c2,c3+1) || ifInterleave(s1,s2,s3,l1,l2,c1,c2+1,c3+1);
		}
		else if(s1.charAt(c1) == s3.charAt(c3)){
			return ifInterleave(s1,s2,s3,l1,l2,c1+1,c2,c3+1);
		}
		else if(s2.charAt(c2) == s3.charAt(c3)){
			return ifInterleave(s1,s2,s3,l1,l2,c1,c2+1,c3+1);
		}
		else 
			return false;
	}
}

// DP solution, PASS both small and large judge 
public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		// Start typing your Java solution below
        // DO NOT write main() function
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();		
		if(l1+l2!=l3) return false;
		int[][] dptable = new int[l2+1][l1+1];
		dptable[0][0] = 1;
		
		for(int i=1; i<=l1; i++){
			if(dptable[0][i-1]==1 && s3.charAt(l3-i) == s1.charAt(l1-i))
				dptable[0][i] = 1;
			else
				dptable[0][i] = 0;
		}
		
		for(int i=1; i<=l2; i++){
			if(dptable[i-1][0] == 1 && s3.charAt(l3-i)==s2.charAt(l2-i))
				dptable[i][0] = 1;
			else
				dptable[i][0] = 0;
		}
		
		for(int i=1; i<=l2; i++)
			for(int j=1; j<=l1; j++){
				if(dptable[i-1][j] ==0 && dptable[i][j-1]==0)
					dptable[i][j] = 0;
				else if(dptable[i-1][j]==1){
					if(s3.charAt(l3-i-j)==s2.charAt(l2-i)){
						dptable[i][j] = 1;
						continue;
					}
				}
				else if(dptable[i][j-1]==1){
					if(s3.charAt(l3-i-j)==s1.charAt(l1-j)){
						dptable[i][j] = 1;
						continue;
					}
				}
				else
					dptable[i][j] =0 ;
			}
		
		return dptable[l2][l1]==1 ? true : false;
	}
}


