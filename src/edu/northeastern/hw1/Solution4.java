package edu.northeastern.hw1;

/**
 * Split Linked List in Parts (https://leetcode.com/problems/split-linked-list-in-parts/)
 */
public class Solution4 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        if (head == null) {
            return result;
        }
        ListNode pointer = head;
        int length = 1;
        while (pointer.next != null) {
            pointer = pointer.next;
            length++;
        }
        int number_of_larger_parts = 0;
        int number_of_remaining_parts = 0;
        int length_of_larger_part = 0;
        int length_of_remaining_part = 0;
        if (length < k) {
            number_of_larger_parts = length;
            number_of_remaining_parts = k - length;
            length_of_larger_part = 1;
            length_of_remaining_part = 0;
        } else {
            number_of_larger_parts = length % k;
            number_of_remaining_parts = k - length % k;
            length_of_larger_part = length / k + 1;
            length_of_remaining_part = length / k;
        }
        ListNode new_head = head;
        ListNode tail = head;
        for (int i = 0; i < number_of_larger_parts; i++) {
            for (int j = 1; j < length_of_larger_part; j++) {
                tail = tail.next;
            }
            head = new_head;
            new_head = tail.next;
            tail.next = null;
            result[i] = head;
            tail = new_head;
        }
        if (length_of_remaining_part == 0) {
            return result;
        }
        for (int g = 0; g < number_of_remaining_parts; g++) {
            for (int h = 1; h < length_of_remaining_part; h++) {
                tail = tail.next;
            }
            head = new_head;
            new_head = tail.next;
            tail.next = null;
            result[number_of_larger_parts] = head;
            number_of_larger_parts++;
            tail = new_head;
        }
        return result;
    }
}
