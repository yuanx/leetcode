public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<Integer> col = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        getlist(n,k,col,re,0);
        return re;
    }
    
    public void getlist(int n, int k, ArrayList<Integer> col, ArrayList<ArrayList<Integer>> re, int start){
        if(col.size()==k){
            ArrayList<Integer> t = new ArrayList<Integer>(col);
            re.add(t);
            return;
        }
        
        for(int i=start; i<n; i++){
            col.add(i+1);
            getlist(n,k,col,re,i+1);
            col.remove(col.size()-1);
        }
        
    }
}