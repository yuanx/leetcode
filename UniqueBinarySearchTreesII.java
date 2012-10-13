/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(n==0){
            res.add(null);
            return res;            
        }
        
        for(int i=1; i<=n; i++){
			ArrayList<TreeNode> ls = createTree(1, i-1);
			ArrayList<TreeNode> rs = createTree(i+1, n);
			for(TreeNode l:ls)
				for(TreeNode r:rs){
                    TreeNode head = new TreeNode(i);
					head.left = l;
					head.right = r;
					res.add(head);
				}
        }
        return res;
    }
    
    public ArrayList<TreeNode> createTree(int start, int end){
    	ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
    	if(end<start){
    		TreeNode head = null;
    		trees.add(head);
    		return trees;
    	}
    	if(end==start){
    		TreeNode head = new TreeNode(start);
    		trees.add(head);
    		return trees;
    	}
    	for(int i=start; i<=end; i++){
    		ArrayList<TreeNode> lefts = createTree(start,i-1);
    		ArrayList<TreeNode> rights = createTree(i+1,end);
    		for(TreeNode l:lefts)
    			for(TreeNode r:rights){
    				TreeNode head = new TreeNode(i);
    				head.left = l;
    				head.right = r;
    				trees.add(head);
    			}
    	}
    	
    	return trees;
    }
}