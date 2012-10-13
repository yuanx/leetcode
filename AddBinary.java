public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int al = a.length()-1;
        int bl = b.length()-1;
        int carry = 0;
        int temp;
        
        String sum = "";
        
        while(al>=0 || bl>=0){
            if(al>=0 && bl>=0)
                temp = (a.charAt(al)-'0') + (b.charAt(bl)-'0') + carry;
            else if(al>=0)
                temp = (a.charAt(al)-'0') + carry;
            else
                temp = (b.charAt(bl)-'0') + carry;
            
            if(temp>=2){
                carry = 1;
                temp = temp-2;
            }
            else{
                carry = 0;
            }
            sum = Integer.toString(temp)+sum;
            al--;
            bl--;
        }
        
        if(carry==1)
            return "1"+sum;
        else
            return sum;
        
    }
}