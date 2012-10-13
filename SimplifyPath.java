import java.util.Stack;
public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	Stack<String> stack = new Stack<String>();
		
		int len = path.length();
		if(len==1) return "/";
		
		int i=0;
		int j=1;
		
		while(j<len){
			if(path.charAt(j) == '/'){
				if(j-i > 1){
					String temp = path.substring(i+1, j);
					if(temp.equals("..")){ 
						if(!stack.isEmpty())
							stack.pop();
					}
					else if(!temp.equals("."))
						stack.push(temp);
				}					
					i=j;
			}			
			j++;
		}
		
		if(i<len-1){
			String temp = path.substring(i+1);
			if(temp.equals("..")){
				if(!stack.isEmpty())
					stack.pop();
			}
			else if(!temp.equals("."))
				stack.push(temp);
		}
		
		if(stack.isEmpty())
			return "/";
		else{
			String s = "";
			while(!stack.isEmpty()){
				s = "/"+stack.pop()+s;
			}
			return s;
		}
		
        
    }
}