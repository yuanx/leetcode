import java.util.Hashtable;
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        Hashtable<String,Integer> hash = new Hashtable<String,Integer>();        
        return gnumDecodings(s,hash);
    }
    
    public int gnumDecodings(String s, Hashtable<String,Integer> hash) {        
        int len = s.length();       
        if(len == 0 || s.charAt(0) == '0') return 0;        
        if(len == 1) return 1;

        if(hash.containsKey(s))
            return hash.get(s);
        
        int i = Integer.parseInt(s.substring(0,2));
        int temp;
                
        if(i>26)            
            temp = gnumDecodings(s.substring(1),hash);
        else if(len == 2)
            temp = 1+gnumDecodings(s.substring(1),hash);            
        else
            temp = gnumDecodings(s.substring(1),hash) + gnumDecodings(s.substring(2),hash);
        
        hash.put(s, temp);
        return temp;
        
    }
}