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
class BSTIterator {

    Stack<TreeNode> s ;

    TreeNode curr = null;

    public BSTIterator(TreeNode root) {

        s = new Stack<>();

        while (root != null) {

            s.push(root);
            root = root.left;

        }

    }

    public int next() {
        curr = s.pop();
        int val = curr.val;
        curr = curr.right;
        while (curr != null) {
            s.push(curr);
            curr = curr.left;
        }

        return val;

    }

    public boolean hasNext() {

        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */