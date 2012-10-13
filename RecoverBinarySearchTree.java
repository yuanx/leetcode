// Doing with constant space
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
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeNode n1 = null;
    	TreeNode n2 = null;
		int[] count = new int[1];
		count[0] = Integer.MIN_VALUE;		
		n1 = getFirst(root, count, n1);
		
		count[0] = Integer.MAX_VALUE;		
		n2 = getSecond(root, count ,n2);
		
		int temp = n1.val;
		n1.val = n2.val;
		n2.val = temp;
		
    }

	public TreeNode getFirst(TreeNode root,int[] count, TreeNode n1){
		if(root == null) return n1;
		n1 = getFirst(root.left,count,n1);
		if(root.val<count[0])
			n1 = root;
		count[0] = root.val;
		n1 = getFirst(root.right,count,n1);
		
		return n1;		
	}
	
	public TreeNode getSecond(TreeNode root,int[] count, TreeNode n2){
		if(root == null) return n2;
		n2 = getSecond(root.right,count,n2);
		if(root.val>count[0])
			n2 = root;
		count[0] = root.val;
		n2 = getSecond(root.left,count,n2);	
		
		return n2;	
	}	
}