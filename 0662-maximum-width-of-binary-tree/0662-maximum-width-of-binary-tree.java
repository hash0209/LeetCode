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
    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<Pair<Integer, TreeNode>> q = new LinkedList<>();

        Pair<Integer, TreeNode> p= new Pair(1, root);
        q.add(p);

        int maxWidth = Integer.MIN_VALUE;

        while (!q.isEmpty()) {

            int first = 0;

            int last = 0;

            int minIndex = q.peek().first;

            int size = q.size();

            for (int i = 0; i < size; i++) {
                p = q.poll();

                int idx =p.first - minIndex;
                if (i == 0) {
                    first = idx;
                }
                if (i == size - 1) {
                    last = idx;
                }

                TreeNode n = p.second;

                if (n.left != null) {

                    q.add(new Pair(2 * idx, n.left));

                }
                if (n.right != null) {

                    q.add(new Pair((2 * idx) + 1, n.right));
                }

            }

           

            maxWidth = Math.max(maxWidth, last - first + 1);

        }

        return maxWidth;

    }
}

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}
