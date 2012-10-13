public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(x==0) return 0;
		if(x==1) return 1;
		
		int i = 0;
		int j;
		
		if(x<46340*2)
			j= x;
		else
			j = 46340;
		
		while(j>i){
			int m = (i+j)/2;
			if(m*m == x)
				return m;
			else if((m*m)>x)
				j = m-1;
			else{
				if(((m+1)*(m+1))>x)
					return m;
				else
					i = m+1;
			}
		}
		
		if(i*i>x)
			return i-1;
		else
			return i;
		
        
    }
}

//Better version
public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 1)
            return 0;
        if (x == 1)
            return 1;
            
        int mid = x/2;
        
        while (mid * mid > x || mid > 46340) {
            mid = (mid + x/mid)/2;
        }
        return mid;
    }
}
