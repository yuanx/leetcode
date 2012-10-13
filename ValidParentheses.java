import java.util.*;
public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length()==0) return false;
    	if(s.length()%2==1) return false;
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<s.length();i++){
			if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
				stack.push(s.charAt(i));
			else{
				if(stack.empty())
					return false;
				else{
					char current = s.charAt(i);
					char temp = stack.peek();
					if((temp == '(' && current ==')') || (temp == '[' && current ==']') || (temp == '{' && current =='}'))
						stack.pop();
					else
						return false;
				}
			}
		}
		if(stack.empty())
			return true;
		else
			return false;
		
    }
}