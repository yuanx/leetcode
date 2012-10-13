import java.util.*;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for(int i=0; i<numbers.length; i++){
        	if(hash.containsKey(numbers[i])){
        		res[0] = hash.get(numbers[i])+1;
        		res[1] = i+1;
        		return res;
        	}
        	else if(!hash.containsKey(target-numbers[i]))
        		hash.put(target-numbers[i], i);
        }
        
        return res;
    }
}