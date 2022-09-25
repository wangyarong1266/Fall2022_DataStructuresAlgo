package java.edu.northeastern.hw1;

/**
 * Swapping Nodes in a Linked List(https://leetcode.com/problems/swapping-nodes-in-a-linked-list/)
*/
public class Solution3 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pointer = head;
        int n = 1;
        while (pointer.next != null) {
            pointer = pointer.next;
            n++;
        }
        if (k - 1 == n - k) {
            return dummy.next;
        }
        pointer = dummy;
        ListNode left_pointer = pointer;
        ListNode right_pointer = pointer;
        for (int i = 0; i < n; i++) {
            if (i == k - 1) {
                left_pointer = pointer;

            }
            if (i == n - k) {
                right_pointer = pointer;
            }
            pointer = pointer.next;
        }
        if (k - 1 > n - k) {
            ListNode temporary_pointer = right_pointer;
            right_pointer = left_pointer;
            left_pointer = temporary_pointer;
        }
        ListNode left_target = left_pointer.next;
        ListNode right_target = right_pointer.next;
        ListNode right_target_next = right_target.next;
        left_pointer.next = right_target;
        if (left_target.next == right_target) {
            left_pointer.next = right_target;
            right_target.next = left_target;
            left_target.next = right_target_next;
            return dummy.next;
        }
        right_target.next = left_target.next;
        left_target.next = right_target_next;
        right_pointer.next = left_target;
        return dummy.next;
    }
}
