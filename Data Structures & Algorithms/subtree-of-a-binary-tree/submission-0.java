/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return (p.val == q.val && left && right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(isSameTree(root,subRoot))
            return true;
        if(root==null)
            return false;
        boolean left=isSubtree(root.left,subRoot);
        if(left==true)
            return true;
        return isSubtree(root.right,subRoot);
    }
}
