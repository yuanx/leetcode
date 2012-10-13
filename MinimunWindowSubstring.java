public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] needs = new int[256];
        int[] has = new int[256];
        //String re = "";
        int shortest= S.length()+1;
        int start=0;
        int end=0;
        int p=0;
        int q=0;
        int had = 0;
        
        //get what we needs
        for(int i=0; i<T.length(); i++){
            needs[(int)T.charAt(i)]+=1;
        }
        
        while(q<S.length()){
            char current = S.charAt(q);
            has[(int)current]++;
			if(has[(int)current]<=needs[(int)current]){
				had++;
				while(had == T.length()){
					if(has[(int)S.charAt(p)]==needs[(int)S.charAt(p)]){
						int templen = q-p+1;
						if(shortest>templen){
							shortest = templen;
							start = p;
							end = q;
						}
						had--;
					}
					has[(int)S.charAt(p)] --;
					p++;
				}
			}
			q++;
        }
        if(shortest < S.length()+1)
        	return S.substring(start,end+1);
        else
        	return "";
        
    }
}