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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)  
            return root;
        TreeNode curr=root;

        TreeNode temp=curr.left;
        curr.left=curr.right;
        curr.right=temp;
        invertTree(curr.left);
        invertTree(curr.right);
        return root;
    }
}
