package edu.northeastern.midterm.question4;

public class LinkList {

    public Node head;

    public int length = 0;

    public LinkList() {
        head = null;
    }

    /**
     * The time complexity is O(N). N is the number of nodes in the linked list.
     */
    public void insert(Integer data) {
        // Insert in sorted manner

        Node dummy = new Node(-1);
        dummy.next = head;

        Node prev = dummy;
        Node cur = head;

        while (cur != null) {
            if (cur.data > data) {
                break;
            }

            prev = cur;
            cur = cur.next;
        }

        prev.next = new Node(data);
        prev.next.next = cur;

        head = dummy.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node p = head;

        while (p != null) {
            sb.append(p.data).append(' ');
            p = p.next;
        }

        return sb.toString();
    }
}
