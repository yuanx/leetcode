// Use two stacks (tried the way of scaning twice, not work out)
public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		Stack<Character> p = new Stack<Character>();
		Stack<Integer> index = new Stack<Integer>();
		
		if(s.length()<=1) return 0;
		int longest = 0;
		
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='('){
				p.push('(');
				index.push(i);
			}
			else{
				if(!p.isEmpty() && p.peek()=='('){
					p.pop();
					index.pop();
					longest = Math.max(longest, (p.isEmpty() ? i+1 : i-index.peek()));
				}
				else{
					p.push(')');
					index.push(i);
				}
			}
		}
		
		return longest;

    }
}