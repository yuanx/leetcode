import java.util.*;
public class Solution {
    
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<String, Integer> hash = new HashMap<String, Integer>();
    	for(String s : L){
			if(hash.containsKey(s))
				hash.put(s, hash.get(s)+1);
			else
				hash.put(s, 1);
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		int m = L.length;
		int wordlen = L[0].length();
		
		for(int i=0; i<= S.length()-m*wordlen; i++){
			String temp = S.substring(i, i+m*wordlen);
			if(isString(temp, L, hash))
				res.add(i);
		}
		
		return res;        
    }
	
	public boolean isString(String t, String[] L, Map<String, Integer> hash){
		Map<String, Integer> temphash = new HashMap<String, Integer>();
		int len = L[0].length();
		int i=0;
		while(i<t.length()){
			String temp = t.substring(i, i+len);
			if(!hash.containsKey(temp))
				return false;
			else{
				if(!temphash.containsKey(temp))
					temphash.put(temp, 1);
				else{
    			    int n = temphash.get(temp);
                    if(n+1>hash.get(temp))
                        return false;
                    else
                        temphash.put(temp, n+1);
				}
			}
			i+=len;
		}
		return true;
		
	}
}