/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node>hm;
    public Node cloneGraph(Node node) {
        hm=new HashMap<>();
        if(node==null)
            return null;
        return dfs(node);
    }
    public Node dfs(Node node){
        if(hm.containsKey(node))
            return hm.get(node);
        Node clone=new Node(node.val);
        hm.put(node,clone);
        for(Node n:node.neighbors){
            clone.neighbors.add(dfs(n));
        }
        return clone;
    }
}