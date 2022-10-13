package java.edu.northeastern.hw2;

/**
 * Symmetric Tree (https://leetcode.com/problems/symmetric-tree/)
 */
public class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);
    }
    private boolean isSame(TreeNode treeNode_one, TreeNode treeNode_two) {
        if (treeNode_one == null && treeNode_two == null) {
            return true;
        }
        if (treeNode_one == null || treeNode_two == null) {
            return false;
        }
        if (treeNode_one.val == treeNode_two.val) {
            boolean left_right_same = isSame(treeNode_one.left, treeNode_two.right);
            boolean right_left_same = isSame(treeNode_one.right, treeNode_two.left);
            if (left_right_same == true && right_left_same == true) {
                return true;
            }
        }
        return false;
    }
}
