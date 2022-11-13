package edu.northeastern.hw2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)
 */

public class Solution3 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right_side_view = new ArrayList<>();
        if (root == null) {
            return right_side_view;
        }
        right_side_view.add(root.val);
        Queue<TreeNode> each_level = new LinkedList<>();
        each_level.add(root);
        while (each_level.size() != 0) {
            List<Integer> each_level_values = new ArrayList<>();
            int each_level_size = each_level.size();
            for (int i = 0; i < each_level_size; i++) {
                TreeNode first_of_each_level = each_level.remove();
                if (first_of_each_level.left != null) {
                    each_level.add(first_of_each_level.left);
                    each_level_values.add(first_of_each_level.left.val);

                }
                if (first_of_each_level.right != null) {
                    each_level.add(first_of_each_level.right);
                    each_level_values.add(first_of_each_level.right.val);
                }
            }
            if (each_level_values.size() != 0) {
                int last_value = each_level_values.get(each_level_values.size() - 1);
                right_side_view.add(last_value);
            }
        }
        return right_side_view;
    }
}
