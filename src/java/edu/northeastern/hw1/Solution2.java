package java.edu.northeastern.hw1;

/**
 * Remove Linked List Elements (https://leetcode.com/problems/remove-linked-list-elements/)
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer.next != null) {
            if (pointer.next.val == val) {
                ListNode target_node = pointer.next;
                pointer.next = pointer.next.next;
                target_node.next = null;
            } else {
                pointer = pointer.next;
            }
        }
        return dummy.next;
    }
}
