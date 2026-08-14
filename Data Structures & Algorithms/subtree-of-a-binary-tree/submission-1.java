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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
        return false;
        if(isSameTree(root, subRoot))
        return true;

    return isSubtree(root.left, subRoot)
        || isSubtree(root.right, subRoot);
    }
public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }
    public boolean dfs(TreeNode p,TreeNode q){
        if(p==null&&q==null)
            return true;
        if(p==null||q==null){
            if(p==null&&q!=null)
                return false;
            if(p!=null&&q==null)
                return false;           
        }
        if(p.val!=q.val)
            return false;
        boolean lv=dfs(p.left,q.left);
        boolean rv=dfs(p.right,q.right);
        if(lv==true&&rv==true)return true;
        else
            return false;
    }
}
