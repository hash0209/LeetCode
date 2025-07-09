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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> vMap = new TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>>();

        Node n = new Node(root, 0, 0);
        q.add(n);

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {

                Node curr = q.poll();
                TreeNode temp = curr.node;

                int vertical = curr.v;
                int level = curr.l;
                TreeMap<Integer, ArrayList<Integer>> lMap;

                if (vMap.containsKey(vertical)) {
                    lMap = vMap.get(vertical);
                    if (lMap.containsKey(level)) {
                        ArrayList<Integer> l = lMap.get(level);
                        l.add(temp.val);
                        //lMap.put(level, l);
                    } else {
                        ArrayList<Integer> nodeList = new ArrayList<>();
                        nodeList.add(temp.val);
                        lMap.put(level, nodeList);
                    }
                   // vMap.put(vertical, lMap);
                } else {
                    lMap = new TreeMap<>();
                    ArrayList<Integer> nodeList = new ArrayList<>();
                    nodeList.add(temp.val);
                    lMap.put(level, nodeList);

                    vMap.put(vertical, lMap);
                }

                if (temp.left != null) {
                    q.add(new Node(temp.left, vertical - 1, level + 1));
                }
                if (temp.right != null) {
                    q.add(new Node(temp.right, vertical + 1, level + 1));
                }

            }
        }

        for (TreeMap<Integer, ArrayList<Integer>> levels : vMap.values()) {
            List<Integer> col = new ArrayList<>();
            for (ArrayList<Integer> nodes : levels.values()) {
                Collections.sort(nodes); 
                col.addAll(nodes);
            }
            list.add(col);
        }

        return list;

    }
}

public class Node {
    TreeNode node;
    int v;
    int l;

    Node() {

    }

    Node(TreeNode node, int v, int l) {
        this.node = node;
        this.v = v;
        this.l = l;
    }
}