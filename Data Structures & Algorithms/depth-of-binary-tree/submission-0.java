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
    int max=Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        return height(root);
    }
    public int height(TreeNode root){
        if(root==null)
            return 0;
        int rightH=height(root.right);
        int leftH=height(root.left);
        return 1+Math.max(rightH,leftH);
    }
}
