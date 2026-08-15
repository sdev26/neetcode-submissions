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
    public int maxPathSum(TreeNode root) {
        height(root);
        return max;
    }
    public int height(TreeNode root){
        if(root==null)
            return 0;
        int leftH=Math.max(0,height(root.left));
        int rightH=Math.max(0,height(root.right));
        max=Math.max(max,root.val+leftH+rightH);
        return root.val+Math.max(leftH,rightH);
    }
}
