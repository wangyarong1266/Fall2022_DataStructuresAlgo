package java.edu.northeastern.hw4;

/**
 * Convert Binary Search Tree to Sorted Doubly Linked List (https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/)
 */
public class Solution2 {
    Node first = null;
    Node last = null;
    public void helper(Node node) {
        if (node != null) {
            helper(node.left);
            if (last != null) {
                last.right = node;
                node.left = last;
            }
            else {
                first = node;
            }
            last = node;
            helper(node.right);
        }
    }
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        helper(root);
        last.right = first;
        first.left = last;
        return first;
    }
}
