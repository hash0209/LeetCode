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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<>();
        if(root == null){
            return l;
        }

        Map<Integer,Integer> map = new TreeMap<>();

        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(root , 0));


        while(!q.isEmpty()){
            int size = q.size();

            for(int i =0; i < size ; i++){
                Node node = q.poll();
                TreeNode n = node.treenode;
                int level = node.level;
                map.put(level,n.val);

                if(n.left!=null){
                    q.add(new Node(n.left , level+1));
                }
                if(n.right!=null){
                    q.add(new Node(n.right , level+1));
                }
            }
        }


        for(Integer x : map.values()){
            l.add(x);
        }

        return l;
    }
}

class Node{
    TreeNode treenode;
    int level ; 


    public Node(TreeNode treenode , int level){
        this.treenode=treenode;
        this.level=level;
    }
}