public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> li = new ArrayList<Integer>();
        getlist(candidates,target,li,re,0);
        
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
                getlist(candidates,target-candidates[i],li,reli,i);
                li.remove(li.size()-1);                
            }
        }
    }
}