package java.edu.northeastern.hw2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Maximum Depth of Binary Tree (https://leetcode.com/problems/maximum-depth-of-binary-tree/)
 */

public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> each_level = new LinkedList<>();
        each_level.add(root);
        int number_of_levels = 0;
        while (each_level.size() != 0) {
            int each_level_size = each_level.size();
            for (int i = 0; i < each_level_size; i++) {
                TreeNode first_of_each_level = each_level.remove();
                if (first_of_each_level.left != null) {
                    each_level.add(first_of_each_level.left);
                }
                if (first_of_each_level.right != null) {
                    each_level.add(first_of_each_level.right);
                }
            }
            number_of_levels++;
        }
        return number_of_levels;
    }
}
