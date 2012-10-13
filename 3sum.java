import java.util.ArrayList;
import java.util.Hashtable;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        int i,j,p;
        int i_value = Integer.MAX_VALUE;
        int j_value, p_value;
        int sum;
        
        for(i=0; i<num.length-2; i++){
            
            if(num[i] == i_value)
                continue;
            
            i_value = num[i];
            p = i+1;
            j = num.length-1;
            
            while(p<j){
                sum = num[i]+num[p]+num[j];
                j_value = num[j];
                p_value = num[p];
                
                if(sum>0){
                    while(--j>p && num[j] == j_value);
                }
                else if(sum == 0){
                    temp.clear();
                    temp.add(num[i]);
                    temp.add(num[p]);
                    temp.add(num[j]);
                    re.add((ArrayList<Integer>)temp.clone());
                    while(++p<j && num[p] == p_value);
                }
                else{
                    while(++p<j && num[p] == p_value);
                }
                
            }
        }
        
        return re;
    }
}