public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length==0 || A.length==1) return 0;
        int len = A.length;
        ArrayList<Integer> d1 = new ArrayList<Integer>();
        ArrayList<Integer> d2 = new ArrayList<Integer>();
        int res = 0;
        int largest = A[0];
        d1.add(0);
        for(int i=0; i<len; i++){
            if(A[i]>largest){
        		d1.add(i);
                largest = A[i];
            }
        }
        
        d2.add(len-1);
        largest = A[len-1];
        for(int i=len-1; i>-0; i--){
        	if(A[i]>largest){
        		d2.add(i);
                largest = A[i];
        	}
        }
        
        for(int i=0; i<d1.size()-1; i++){
        	res += getwater(A, d1.get(i), d1.get(i+1));
        }
        
        for(int i=d2.size()-1; i>0; i--){
        	res += getwater(A, d2.get(i), d2.get(i-1));
        }
        
        res += getwater(A,d1.get(d1.size()-1), d2.get(d2.size()-1));
        
        return res;
        
    }
    
    public int getwater(int[] A, int start, int end){
    	if(end-start<=1) return 0;
    	int standard = Math.min(A[start],A[end]);
    	int res = 0;
    	for(int i=start+1; i<end; i++){
    		res += (standard-A[i]);
    	}
    	
    	return res;
    }
}