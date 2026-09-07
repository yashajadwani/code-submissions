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
    public TreeNode findRightMost(TreeNode root) {
        while(root.right!=null)
            root=root.right;
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val==key) {
            if(root.left==null)
                return root.right;
            if(root.right==null)
                return root.left;
            TreeNode n = findRightMost(root.left);
            root.val=n.val;
            root.left=deleteNode(root.left, n.val);
        }
        if(root.val<key)
            root.right=deleteNode(root.right,key);
        if(root.val>key)
            root.left=deleteNode(root.left,key);
        return root;

    }
}