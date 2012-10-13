import java.util.Hashtable;

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        ArrayList<String> result = new ArrayList<String>();  
        Hashtable<String,Integer> hash = new Hashtable<String,Integer>();
        
        for(int i=0; i<strs.length; i++){
            String sig = signature(strs[i]);
            
            if(hash.containsKey(sig))
                hash.put(sig, hash.get(sig)+1);
            else
                hash.put(sig,1);                        
        }
        
        for(int i=0; i<strs.length; i++){
            String sig = signature(strs[i]);
            
            if(hash.get(sig)>1)
                result.add(strs[i]);
        }
            
        return result;        
    }
    
    public String signature(String str){
        int[] chars = new int[26];
        
        for(int i=0; i<str.length(); i++){
            chars[str.charAt(i)-'a'] +=1;
        }
        
        String re = "";
        
        for(int i=0; i<26; i++){
            for(int j=0; j<chars[i]; j++){
                re += (char)(i+97);
            }
            
        }
        
        return re;
        
    }
    
}