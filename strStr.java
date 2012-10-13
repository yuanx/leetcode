//brute force
public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lenh = haystack.length();
        int lenn = needle.length();
        if(lenn>lenh) return null;
        
        for(int i=0; i<=lenh-lenn; i++){
            int success = 1;
            for(int j=0; j<lenn; j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    success = 0;
                    break;
                }
            }
            if(success == 1)
                return haystack.substring(i);
            
        }
        
        return null;
        
    }
}

//KMP Algorithm
public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lenh = haystack.length();
        int lenn = needle.length();
        if(lenn>lenh) return null;
        if(lenn==0) return haystack;

    	int[] overlay = getOverlay(needle);
		int i=0;
		
		while(i<=lenh-lenn){
            int success = 1;
			for(int j=0; j<lenn; j++){
				if(needle.charAt(0) != haystack.charAt(i)){
					success = 0;
					i++;
					break;
				}
				else if(needle.charAt(j) != haystack.charAt(i+j)){
					success = 0;
					i = i+j-overlay[j-1];
					break;
				}
			}
			if(success == 1)
				return haystack.substring(i);
		}
		return null;
        
    }
	
	public int[] getOverlay(String needle){
		int[] overlay = new int[needle.length()];
		overlay[0] = 0;
		for(int i=1; i<needle.length(); i++){
			int index = overlay[i-1];
			while(index>0 && needle.charAt(index) != needle.charAt(i)){
				index = overlay[index-1];
			}
			if(needle.charAt(index) == needle.charAt(i)){
				overlay[i] = overlay[i-1]+1;
			}
			else
				overlay[i] = 0;
		}
		
		return overlay;
		
	}
}