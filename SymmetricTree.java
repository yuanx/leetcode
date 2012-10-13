/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(root== null) return true;
		
		return ifSymmetric(root.left, root.right);        
    }

	public boolean ifSymmetric(TreeNode tree1, TreeNode tree2){
		if(tree1==null && tree2==null)
			return true;
		else if(tree1 == null || tree2 == null)
			return false;
		
		if(tree1.val != tree2.val)
			return false;
		else
			return (ifSymmetric(tree1.left, tree2.right) && ifSymmetric(tree1.right, tree2.left));
	}
}

