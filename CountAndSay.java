public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(n==1) return "1";
        
        String re = "1";
        int c = 1;
        
        while(c<n){
            String temp = "";
            char current = re.charAt(0);
            int count = 0;
            for(int i=0 ;i<re.length();){
                if(re.charAt(i) == current){
                    count ++;
                    i++;
                }
                else{
                    temp += Integer.toString(count);
                    temp += current;
                    
                    current = re.charAt(i);
                    count = 0;
                }
            }
            
            temp += Integer.toString(count);
            temp += current;
            
            re = temp;
            c++;
        }
        
        return re;
        
    }
}