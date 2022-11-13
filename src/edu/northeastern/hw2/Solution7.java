package edu.northeastern.hw2;

/**
 * Lowest Common Ancestor of a Binary Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
 */

public class Solution7 {
    TreeNode lowest_common_ancestor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        is_in_same_subtree(root, p, q);
        return lowest_common_ancestor;
    }
    private boolean is_in_same_subtree(TreeNode treeNode, TreeNode treeNode_one, TreeNode treeNode_two) {
        if (treeNode == null) {
            return false;
        }
        boolean is_in_left_subtree = is_in_same_subtree(treeNode.left, treeNode_one, treeNode_two);
        boolean is_in_right_subtree = is_in_same_subtree(treeNode.right, treeNode_one, treeNode_two);
        boolean is_root = false;
        if (treeNode.val == treeNode_one.val || treeNode.val == treeNode_two.val) {
            is_root = true;
        }
        if (is_root == false && is_in_left_subtree == false && is_in_right_subtree == false) {
            return false;
        }
        if (is_root == true && is_in_left_subtree == true) {
            this.lowest_common_ancestor = treeNode;
        }
        if (is_root == true && is_in_right_subtree == true) {
            this.lowest_common_ancestor = treeNode;
        }
        if (is_in_left_subtree == true && is_in_right_subtree == true) {
            this.lowest_common_ancestor = treeNode;
        }
        return true;
    }
}
