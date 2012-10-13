public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<String> re = new ArrayList<String>();
		if(n==0) return re;
		String str = "";
		getParenthesis(n,n,str,re);
		return re;        
    }

	public void getParenthesis(int left, int right, String str, ArrayList<String> re){
		if(left == 0 && right == 0){
			re.add(str);
			return;
		}
		
		if(left == 0)
			getParenthesis(0,right-1,str+")",re);		
		else if(left>0){
			getParenthesis(left-1,right,str+"(",re);			
			if(right>left){
				getParenthesis(left,right-1,str+")",re);
			}			
		}		
	}
}