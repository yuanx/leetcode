public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int longest = 0;
        int locallong = 0;
        int[] hash = new int[26];
        int i=0;
        int j=0;
        
        while(i<s.length()){
            while(i<s.length() && hash[s.charAt(i)-'a'] == 0){
                hash[s.charAt(i)-'a']=1;
                i++;
                locallong++;
            }
            
            longest = longest>locallong ? longest :locallong;
            
            if(i<s.length()){
                while(s.charAt(i) != s.charAt(j)){
                    hash[s.charAt(j++)-'a']=0;
                    locallong--;
                }
                hash[s.charAt(j++)-'a']=0;
                locallong--;
            }
        }
        
        longest = longest>locallong ? longest : locallong;
        return longest;
        
        
    }
}