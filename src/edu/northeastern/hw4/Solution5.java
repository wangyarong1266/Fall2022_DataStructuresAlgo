package edu.northeastern.hw4;

import java.util.Stack;

/**
 * Binary Search Tree Iterator (https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class Solution5 {
    Stack<TreeNode> stack;
    public void BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode node = root;
        updateStack(node);
    }
    public int next() {
        TreeNode toRemove = stack.pop();
        updateStack(toRemove.right);
        return toRemove.val;
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public void updateStack(TreeNode node){
        while(node != null){
            stack.add(node);
            node = node.left;
        }
    }
}
