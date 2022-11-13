package edu.northeastern.hw2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Zigzag Level Order Traversal (https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)
 */

public class Solution4 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagLevels = new ArrayList<>();
        if (root == null) {
            return zigzagLevels;
        }
        List<Integer> first_level_value = new ArrayList<>();
        first_level_value.add(root.val);
        zigzagLevels.add(first_level_value);
        Queue<TreeNode> each_level = new LinkedList<>();
        each_level.add(root);
        int level = 1;
        while (each_level.size() != 0) {
            int each_level_size = each_level.size();
            List<Integer> each_level_values = new ArrayList<>();
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
            if (level % 2 == 1) {
                int start = 0;
                int end = each_level_values.size() - 1;
                for (int j = 0; j < each_level_values.size() / 2; j++) {
                    int temporary = each_level_values.get(start);
                    each_level_values.set(start, each_level_values.get(end));
                    each_level_values.set(end, temporary);
                    start++;
                    end--;
                }
            }
            if (each_level_values.size() > 0) {
                zigzagLevels.add(each_level_values);
            }
            level++;
        }
        return zigzagLevels;
    }

}
