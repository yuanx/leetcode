//brute force solution. could not pass the larger judger.
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int len = strs.length;
        if(len==0) return "";
        if(len==1) return strs[0];        
        String temp = strs[0];
        String re = "";
        
        for(int i=0; i<temp.length(); i++){
            char ctemp = temp.charAt(i);
            for(int j=1; j<len; j++){
                if(strs[j].length()==i || strs[j].charAt(i) != ctemp)
                    return re;
            }
            re += ctemp;
        }
        
        return re;
        
    }
}


//compair pairly, passed both test
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function 
   		int len = strs.length;
        if(len==0) return "";
        if(len==1) return strs[0];
		String[] temp = strs;
		
		int end = len-1;
		while(end>0){
			end = pairCompare(temp,0,end);
		}
		
		return temp[0];
		
		
       
    }

	public int pairCompare(String[] strs, int start, int end){
		int i=start;
		int j=end;
		while(j>i){
			strs[i]= prefixOftwo(strs[i],strs[j]);
			i++;
			j--;
		}
		return j;

	}

	public String prefixOftwo(String s1, String s2){
		String re = "";
		int i =0;
		while(i<s1.length() && i<s2.length()){
			if(s1.charAt(i) == s2.charAt(i)){
				re += s1.charAt(i);
				i++;
			}
			else
				break;
		}
		return re;
	}
}
