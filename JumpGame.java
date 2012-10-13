// recursive with cache, could not pass the large judge
import java.util.Hashtable;
public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function        
    if(A.length<=1) return true;
    int lastIndex = A.length-1;
    Hashtable<Integer[], Boolean> hash = new Hashtable<Integer[], Boolean>();  
    return canJump(A,0,lastIndex,hash);        
    }
    
    public boolean canJump(int[] A, int start, int last, Hashtable<Integer[], Boolean> hash){
        if(last==start) return true;
        
        Integer[] temp = {start,last};
        
        if(!hash.containsKey(temp)){
            hash.put(temp,false);
            for(int i=start; i<last; i++){
                if(i+A[i]>=last && canJump(A,start,i,hash)){
                    hash.put(temp,true);
                    break;
                }
            }
        }
        
        return hash.get(temp);
    }
}

// Easy way to solve PASS BOTH TEST
public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        if(A.length<=1) return true;
        int last = A.length -1;
        int ll;
        
        while(last>0){
            ll = last;
            for(int i=0; i<last; i++){
                if(i+A[i]>=last)
                    last = i;
            }
            
            if(ll == last)
                return false;
        }
        
        return true;
        
        
    }
}