package edu.northeastern.midterm.question1;

import java.util.LinkedList;
import java.util.Queue;

public class BinTree<T> {
    public Node<T> root;

    public BinTree() {
    }

    /**
     * The time complexity is O(N) N is the number of nodes in the tree.
     */
    public void populateNextLeft() {
        if (root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int curSize = queue.size();
            Node<T> prev = null;

            for (int i = 0; i < curSize; i++) {
                Node<T> cur = queue.poll();

                cur.nextLeft = prev;
                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }

                prev = cur;
            }
        }
    }
}
