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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if(root==null)
            return"";
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null)
                sb.append("null,");
            else{
                sb.append(curr.val+",");
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String values[]=data.split(",");
        if(values.length==0||data.equals(""))
            return null;
        TreeNode root=new TreeNode(Integer.valueOf(values[0]));
        int i=1;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(i<values.length&&!values[i].equals("null")){
                curr.left=new TreeNode(Integer.valueOf(values[i]));
                q.add(curr.left);
            }i++;
            if(i<values.length&&!values[i].equals("null")){
                curr.right=new TreeNode(Integer.valueOf(values[i]));
                q.add(curr.right);
            }i++;
        }
        return root;
    }
}
