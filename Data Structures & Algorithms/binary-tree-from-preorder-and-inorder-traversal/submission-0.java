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
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return build(preorder,hm,0,inorder.length-1);
    }
    public TreeNode build(int[]preorder,HashMap<Integer,Integer>hm,int start,int end){
        if(start>end)
            return null;
        TreeNode curr=new TreeNode(preorder[index++]);
        int mid=hm.get(curr.val);
        curr.left=build(preorder,hm,start,mid-1);
        curr.right=build(preorder,hm,mid+1,end);
        return curr;
    }
}
