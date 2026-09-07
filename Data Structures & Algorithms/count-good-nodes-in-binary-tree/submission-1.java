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
    public int goodNodes(TreeNode root) {
         if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        int lc=0,rc=0;
        lc=countNodes(root.left,root.val,0);
        rc=countNodes(root.right,root.val,0);
        return 1+lc+rc;
    }
    public int countNodes(TreeNode root,int max,int count){
        if(root==null)
            return count;
        if(root.val>=max)
            count++;
        max=Math.max(max,root.val);
        count=countNodes(root.left,max,count);
        count=countNodes(root.right,max,count);
        return count;
    }
}
