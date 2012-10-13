public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        for(int i = digits.length-1; i>=0; i--){
            if(digits[i] != 9){
                digits[i]++;
                return digits;
            }
            else{
                digits[i] = 0;
            }
        }
        
        int[] re = new int[digits.length+1];
        re[0] = 1;
        
        return re;
    }
}