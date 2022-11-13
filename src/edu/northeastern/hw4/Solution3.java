package edu.northeastern.hw4;

/**
 * Validate Binary Search Tree (https://leetcode.com/problems/validate-binary-search-tree/)
 */
public class Solution3 {
    public boolean validate(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
}
