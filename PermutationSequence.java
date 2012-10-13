// Recursively find the kth large number, slow, could not pass the large test.
public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
		int[] count = new int[1]; //use this to count;
		int[] used = new int[n];
		int[] re = new int[n];
		int[] cal = new int[n];
		
		getkthPermutation(count, used, k, re, cal, 0);	
		StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<re.length; i++){
            sb.append(Integer.toString(re[i]));
        }
        
        return sb.toString();
    }

	public void getkthPermutation(int[] count, int[] used, int k, int[] re, int[] cal, int level){
		if(count[0]==k)
			return;
		
		if(cal.length == level){
			count[0]++;
			if(count[0] == k)
				for(int i=0; i<cal.length; i++)
					re[i]=cal[i];
			return;
		}
		
		for(int i=0; i<cal.length; i++){
			if(used[i] == 0){
				cal[level] = i+1;
				used[i]=1;
				getkthPermutation(count, used, k, re, cal, level+1);
				used[i]=0;
			}
		}
	}
}

// Directly form the kth large number, faster, pass both test
public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int dividend = k-1;		
		int[] dividors = new int[n-1];
		
		String t = "123456789";
		
		for(int i=0; i<n-1; i++){
			dividors[i]= factorial(n-1-i);
		}		
		StringBuilder sb = new StringBuilder();		
		int j=0;
		while(j<n-1){
			int result = dividend/dividors[j];
			int remainder = dividend%dividors[j];
			
			sb.append(t.charAt(result));
			t = t.substring(0,result) + t.substring(result+1);
			dividend = remainder;
			
			j++;
		}
		
		sb.append(t.charAt(dividend));
		
		return sb.toString();       
    }
    
    public int factorial(int n){
        int sum = 1;
        while(n>0)
            sum*=(n--);
        return sum;
    }
}