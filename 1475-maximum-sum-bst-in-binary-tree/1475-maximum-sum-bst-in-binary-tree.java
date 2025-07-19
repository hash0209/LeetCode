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
    public int maxSumBST(TreeNode root) {
        int[] arr = new int[1];

        Node n = find(root, arr);

        return arr[0];
    }

    public Node find(TreeNode root, int[] maxSize) {

        if (root == null) {
            return new Node(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Node left = find(root.left, maxSize);
        Node right = find(root.right, maxSize);

        int total =0;

        if (root.val > left.largest && root.val < right.smallest) {
             total = root.val + left.sum + right.sum;

            if (total > left.sum && total > right.sum ) {
                maxSize[0] = Math.max(total, maxSize[0]);
            } else {

                int total2 = Math.max(left.sum , right.sum);
                maxSize[0] = Math.max(total2 , maxSize[0]);
            }

           // return new Node(total, Math.max(left.largest, root.val),
                //    Math.min(right.smallest, root.val));

            return new Node(total, Math.min(left.smallest, root.val),
                    Math.max(right.largest, root.val));
        }

        total = Math.max(left.sum , right.sum);
       // total = Math.max(total , root.val);

        return new Node(total, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }
}

class Node {
    int sum;
    int smallest;
    int largest;

    public Node(int sum, int smallest, int largest) {
        this.sum = sum;
        this.smallest = smallest;
        this.largest = largest;
    }

}