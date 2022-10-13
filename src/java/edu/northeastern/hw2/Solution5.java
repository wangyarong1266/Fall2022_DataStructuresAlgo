package java.edu.northeastern.hw2;

import java.util.*;

/**
 * Binary Tree Vertical Order Traversal (https://leetcode.com/problems/binary-tree-vertical-order-traversal/)
 */

public class Solution5 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> vertical_order_traversal = new ArrayList<>();
        if (root == null) {
            return vertical_order_traversal;
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> weight = new HashMap<TreeNode, Integer>();
        queue.offer(root);
        weight.put(root, 0);
        int min = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int w = weight.get(node);
            if (!map.containsKey(w)) {
                map.put(w, new ArrayList<>());
            }
            map.get(w).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                weight.put(node.left, w - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                weight.put(node.right, w + 1);
            }
            min = Math.min(min, w);
        }
        while (map.containsKey(min)) {
            vertical_order_traversal.add(map.get(min++));
        }
        return vertical_order_traversal;
    }
}
