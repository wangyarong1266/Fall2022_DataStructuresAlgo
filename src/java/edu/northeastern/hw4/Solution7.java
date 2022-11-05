package java.edu.northeastern.hw4;

/**
 * Inorder Successor in BST ****(https://leetcode.com/problems/inorder-successor-in-bst/)
 */
public class Solution7 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while(root!=null) {
            if(root.val > p.val) {
                res = root;
                root = root.left;
            }
            else root = root.right;
        }
        return res;
    }
}
