public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
		ArrayList<Integer> cal = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
		
		int len = num.length;
		int[] used = new int[len];
		
		getpermute(num, used, len, cal, re);
        
		return re;
    }

	public void getpermute(int[] num, int[] used, int len, ArrayList<Integer> cal, ArrayList<ArrayList<Integer>> re){
		if(cal.size() == len){
			ArrayList<Integer> temp = new ArrayList<Integer>(cal);
			re.add(temp);
			return;
		}
		
		for(int i=0; i<len; i++){
			if(used[i] == 0){
				cal.add(num[i]);
				used[i]=1;
				getpermute(num,used,len,cal,re);
				used[i]=0;
				cal.remove(cal.size()-1);
			}
		}
	}
}