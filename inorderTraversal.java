/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Recursive Solution
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        ArrayList<Integer> re = new ArrayList<Integer>();
        
        if(root == null) return re;
        
        re = inorderTraversal(root.left);
        re.add(root.val);
        re.addAll(inorderTraversal(root.right));
        
        return re;
        
    }
}

// Iterative Solution
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        ArrayList<Integer> re = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        if(root == null) return re; 
        TreeNode current = root.left;
        stack.push(root);
        
        while(!stack.empty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.left;
            }
            else{
                current = stack.peek();
                re.add(current.val);
                stack.pop();
                current = current.right;
            }
        }
        
        return re;
    }
}