package java.edu.northeastern.hw1;

/**
 * Rotate List (https://leetcode.com/problems/rotate-list/)
 */
public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode pointer = head;
        int length = 1;
        while (pointer.next != null) {
            pointer = pointer.next;
            length++;
        }
        ListNode tail = pointer;
        pointer = head;
        int number_of_nodes_to_move = k % length;
        for (int i = 1; i < length - number_of_nodes_to_move; i++) {
            pointer = pointer.next;
        }
        tail.next = head;
        head = pointer.next;
        pointer.next = null;
        return head;
    }
}
