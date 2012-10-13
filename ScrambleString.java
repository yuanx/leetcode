// Recursive solve the issue, exponential time, could not pass the larger judge
public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int len = s1.length();
        if(len != s2.length()) return false;

		if(len == 1)
			return (s1.charAt(0) == s2.charAt(0) ? true : false);
		
		for(int i=1; i<len; i++){
			if((isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))) || (isScramble(s1.substring(len-i), s2.substring(0,i)) && isScramble(s1.substring(0,len-i), s2.substring(i))))
				return true;
		}
		
		return false;

    }
}

// Recursive solve with cache, pass both test
import java.util.Hashtable;
public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Hashtable<String, Boolean> hash = new Hashtable<String, Boolean>();		
		return ifScramble(s1,s2, hash);

    }

	public boolean ifScramble(String s1, String s2, Hashtable<String, Boolean> hash){
		String temp;
		if(s1.compareTo(s2)>0)
			temp = s1+s2;
		else
			temp = s2+s1;

		boolean re = false;
		if(hash.containsKey(temp))
			return hash.get(temp);
		else{
			int len = s1.length();
	        if(len != s2.length()){ 
				hash.put(temp, false);
				return false;				
			}
			
			if(len == 1){
				re = (s1.charAt(0) == s2.charAt(0) ? true : false);
				hash.put(temp, re);
				return re;
			}
			
			if(s1.equals(s2)){
				hash.put(temp, true);
				return true;
			}

			for(int i=1; i<len; i++){
				if((ifScramble(s1.substring(0,i), s2.substring(0,i), hash) && ifScramble(s1.substring(i), s2.substring(i), hash)) || (ifScramble(s1.substring(len-i), s2.substring(0,i), hash) && ifScramble(s1.substring(0,len-i), s2.substring(i), hash)))
					{
						hash.put(temp, true);
						return true;
					}
			}

			hash.put(temp, false);
			
			return false;						
		}
		
	}
}