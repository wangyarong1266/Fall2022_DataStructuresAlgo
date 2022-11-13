package edu.northeastern.hw2;

import java.util.ArrayList;
import java.util.List;

/**
 * Find Leaves of Binary Tree (https://leetcode.com/problems/find-leaves-of-binary-tree/)
 */

public class Solution8 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leave_values_of_all_trees = new ArrayList<>();
        while (root.left != null || root.right != null) {
            List<Integer> leave_values_of_current_tree = new ArrayList<>();
            find_remove_leaves(root, leave_values_of_current_tree);
            leave_values_of_all_trees.add(leave_values_of_current_tree);
        }
        List<Integer> final_root = new ArrayList<>();
        final_root.add(root.val);
        leave_values_of_all_trees.add(final_root);
        return leave_values_of_all_trees;
    }
    private boolean find_remove_leaves(TreeNode treeNode, List<Integer> leave_values) {
        if (treeNode == null) {
            return false;
        }
        if (treeNode.left == null && treeNode.right == null) {
            leave_values.add(treeNode.val);
            return true;
        }
        boolean is_left_leave = find_remove_leaves(treeNode.left, leave_values);
        if (is_left_leave == true) {
            treeNode.left = null;
        }
        boolean is_right_leave = find_remove_leaves(treeNode.right, leave_values);
        if (is_right_leave == true) {
            treeNode.right = null;
        }
        return false;
    }
}
