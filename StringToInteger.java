public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
		long result = 0;
		if(str.length() == 0) return 0;
		
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		int flag = 1;
		
		int current = 0;
		
		while(current<str.length()){
			if(str.charAt(current) == ' ')
				current++;
			else
				break;
		}
		
		if(current==str.length()) return 0;
		
		if(str.charAt(current) == '-'){
			flag = -1;
			current++;
		}
        else if(str.charAt(current) == '+')
            current++;
		
		while(current<str.length()){
			if(str.charAt(current)>='0' && str.charAt(current)<='9'){
				result = result*10 + (str.charAt(current)-'0');
                current++;
			}
			else
				break;
		}
		
		result *= flag;
		
		if(result>max)
			return max;
		
		if(result<min)
			return min;
		
		return (int)result;
		
		
		
        
    }
}