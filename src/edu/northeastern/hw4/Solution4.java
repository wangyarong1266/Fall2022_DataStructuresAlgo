package edu.northeastern.hw4;

/**
 * Recover Binary Search Tree (https://leetcode.com/problems/recover-binary-search-tree/)
 */
public class Solution4 {
    TreeNode previous = null;
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
        solve(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void solve(TreeNode root){
        if(root == null){
            return;
        }
        solve(root.left);
        if(previous != null && root.val < previous.val){
            if(first == null){
                first = previous;
            }
            second = root;
        }
        previous = root;
        solve(root.right);
    }
}
