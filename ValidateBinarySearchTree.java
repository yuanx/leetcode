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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        return isBST(root,max,min);
        
    }
    
    public boolean isBST(TreeNode root, int max, int min){
        if(root == null) return true;
        
        if(root.val>=max || root.val<=min) return false;
        
        return isBST(root.left, root.val, min) && isBST(root.right, max, root.val);
    }
}