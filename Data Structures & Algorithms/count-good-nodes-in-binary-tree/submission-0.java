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
    int count=0;
    public int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        int lc=0,rc=0;
        if(root.left!=null)lc=countNode(root.left,root.val,0);
        if(root.right!=null) rc=countNode(root.right,root.val,0);
        return 1+lc+rc;
    }
    public int countNode(TreeNode root,int max,int count){
        if(root==null)
            return count;
        if(root.val>=max)
            count++;
        max=Math.max(max,root.val);
        count=countNode(root.left,max,count);
        count=countNode(root.right,max,count);
        return count;
    }
}
