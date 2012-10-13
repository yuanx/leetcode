public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> li = new ArrayList<Integer>();
        getlist(num,target,li,re,0);
        
        return re;
        
    } 
    
    public void getlist(int[] candidates, int target, ArrayList<Integer> li,ArrayList<ArrayList<Integer>> reli,int start){
        if(target == 0){
            ArrayList<Integer> t = new ArrayList<Integer>(li);
            if(!reli.contains(t))
                reli.add(t);
            return;
        }
        
        for(int i=start; i<candidates.length; i++){
            
            if(target-candidates[i]>=0){
                li.add(candidates[i]);
                getlist(candidates,target-candidates[i],li,reli,i+1);
                li.remove(li.size()-1);                
            }
        }        
        
    }
}