// use hashtable, worst case will still be O(n^3)
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> ilist = new ArrayList<Integer>();
		if(num.length<4) return res;
		
		Arrays.sort(num);
		Map<Integer, ArrayList<Integer>> hash = new HashMap<Integer, ArrayList<Integer>>();
        
        
		ArrayList<Integer> tlist = new ArrayList<Integer>();
		for(int i=0; i<num.length; i++)
			for(int j=i+1; j<num.length; j++){
				int tempint = target-num[i]-num[j];
                tlist.clear();				
                if(hash.containsKey(tempint))
					tlist = hash.get(tempint);
					
				tlist.add(i);
				tlist.add(j);
				hash.put(tempint,(ArrayList<Integer>)tlist.clone());				
			}
		
		int p,q;
		int p_value = Integer.MAX_VALUE;
		int q_value;
		
		for(p=0; p<num.length-3; p++){
			if(num[p]==p_value)
				continue;
			q = p+1;
			p_value = num[p];
			
			while(q<num.length-2){
                q_value = num[q];
				int s = num[p] + num[q];
				if(hash.containsKey(s)){
					ArrayList<Integer> t = hash.get(s);
                    int count =Integer.MAX_VALUE;
					for(int x=0; x<t.size()-1; x+=2){
						if(t.get(x)<=q || (x>count && num[t.get(x-2)]==num[t.get(x)] && num[t.get(x-1)]==num[t.get(x+1)])){
                            continue;
						}
						else{
							ilist.clear();
							ilist.add(num[p]);
							ilist.add(num[q]);
							ilist.add(num[t.get(x)]);
							ilist.add(num[t.get(x+1)]);
							res.add((ArrayList<Integer>)ilist.clone());
                            count = x;
						}
					}
				}
				while(++q<num.length-2 && num[q]==q_value);
			}
		}
        
        return res;
		
    }
}