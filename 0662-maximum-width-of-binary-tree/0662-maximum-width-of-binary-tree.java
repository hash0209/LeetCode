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

        Queue<Pair<Long, TreeNode>> q = new LinkedList<>();

        Pair<Long, TreeNode> p= new Pair(1L, root);
        q.add(p);

        int maxWidth = Integer.MIN_VALUE;

        while (!q.isEmpty()) {

            Long first = 1L;
            Long last = 1L;

            int size = q.size();

            for (int i = 0; i < size; i++) {
                p = q.poll();

                Long idx =p.first;
                if (i == 0) {
                    first = idx;
                }
                if (i == size - 1) {
                    last = idx;
                }

                TreeNode n = (TreeNode) p.second;

                if (n.left != null) {

                    q.add(new Pair(2L * idx, n.left));

                }
                if (n.right != null) {

                    q.add(new Pair((2L * idx) + 1L, n.right));
                }

            }

           

            maxWidth = Math.max(maxWidth, (int)(last - first) + 1);

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
