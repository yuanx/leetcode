public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = 0;
        if(s.length()==0) return 0;
        int len = s.length()-1;
        
        while(len>=0 && s.charAt(len) == ' ')
            len--;
            
        if(len<0) return 0;
        
        
        for(int i=len; i>=0; i--){
            if(s.charAt(i) != ' ')
                count++;
            else
                break;
        }
        
        return count;
        
    }
}