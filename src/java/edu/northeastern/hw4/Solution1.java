package java.edu.northeastern.hw4;

/**
 * Convert Sorted List to Binary Search Tree (https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)
 */
public class Solution1 {
    private ListNode findMiddleElement(ListNode head) {
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if (prevPtr != null) {
            prevPtr.next = null;
        }
        return slowPtr;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = this.findMiddleElement(head);
        TreeNode node = new TreeNode(mid.val);
        if (head == mid) {
            return node;
        }
        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);
        return node;
    }
}
