package edu.northeastern.hw2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Maximum Width of Binary Tree (https://leetcode.com/problems/maximum-width-of-binary-tree/)
 */

public class Solution6 {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> each_level = new LinkedList<>();
        each_level.add(root);
        int max_width = 1;
        while (each_level.size() != 0) {
            int each_level_size = each_level.size();
            List<Integer> each_level_values = new ArrayList<>();
            for (int i = 0; i < each_level_size; i++) {
                TreeNode first_of_each_level = each_level.remove();
                if (first_of_each_level.left == null) {
                    TreeNode new_treeNode = new TreeNode(101);
                    new_treeNode.left = null;
                    new_treeNode.right = null;
                    first_of_each_level.left = new_treeNode;
                }
                each_level.add(first_of_each_level.left);
                each_level_values.add(first_of_each_level.left.val);
                if (first_of_each_level.right == null) {
                    TreeNode new_treeNode = new TreeNode(101);
                    new_treeNode.left = null;
                    new_treeNode.right = null;
                    first_of_each_level.right = new_treeNode;
                }
                each_level.add(first_of_each_level.right);
                each_level_values.add(first_of_each_level.right.val);
            }
            int rightmost_index = each_level_values.size() - 1;
            int leftmost_index = 0;
            for (int j = each_level_values.size() - 1; j >= 0; j--) {
                if (j == 0 && each_level_values.get(j) == 101) {
                    return max_width;
                }
                if (each_level_values.get(j) != 101) {
                    rightmost_index = j;
                    break;
                }
            }
            for (int k = 0; k < each_level_values.size(); k++) {
                if (each_level_values.get(k) != 101) {
                    leftmost_index = k;
                    break;
                }
            }
            int width = rightmost_index - leftmost_index + 1;
            if (width > max_width) {
                max_width = width;
            }
        }
        return max_width;
    }
}