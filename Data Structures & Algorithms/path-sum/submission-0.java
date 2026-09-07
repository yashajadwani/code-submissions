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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return find(root, 0, targetSum);
    }
    public boolean find(TreeNode root, int ps, int target) {
        if(root == null)
            return false;
        if(root.left == null && root.right==null && ps+root.val==target)
            return true;
        boolean left = find(root.left, root.val+ps, target);
        boolean right = find(root.right, root.val+ps, target);
        return left||right;
    }
}