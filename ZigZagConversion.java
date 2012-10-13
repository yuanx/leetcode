public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(s.length()<=nRows || nRows==1) return s;
		int flag = 1;
		int count =0;
		String[] sbs = new String[nRows];
        for(int i=0; i<sbs.length; i++)
            sbs[i] = "";
		
		for(int i=0; i<s.length(); i++){
			if(count==0)
				flag = 1;
			else if(count == nRows-1)
				flag = -1;
			sbs[count]+=s.charAt(i);
			count += flag;
		}
		String res = "";
		for(String sb : sbs){
			res += sb;
		}
        return res;
    }
}