package edu.northeastern.hw1;

/**
 * Insert into a Sorted Circular Linked List(https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/)
 */
public class Solution5 {
    public Node insert(Node head, int insertVal) {
        Node node_to_insert = new Node(insertVal);
        if (head == null) {
            node_to_insert.next = node_to_insert;
            return node_to_insert;
        }
        if (head.next == head) {
            node_to_insert.next = head;
            head.next = node_to_insert;
            return head;
        }
        Node pointer = head;
        boolean done = false;
        while (done == false) {
            while (pointer.val <= pointer.next.val) {
                if (insertVal >= pointer.val && insertVal <= pointer.next.val) {
                    node_to_insert.next = pointer.next;
                    pointer.next = node_to_insert;
                    done = true;
                    return head;
                }
                pointer = pointer.next;
                if (pointer == head) {
                    node_to_insert.next = pointer.next;
                    pointer.next = node_to_insert;
                    done = true;
                    return head;
                }
            }
            if (insertVal > pointer.val || insertVal < pointer.next.val) {
                node_to_insert.next = pointer.next;
                pointer.next = node_to_insert;
                done = true;
                return head;
            }
            pointer = pointer.next;

        }
        return head;
    }
}
