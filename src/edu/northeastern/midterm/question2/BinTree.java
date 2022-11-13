package edu.northeastern.midterm.question2;


public class BinTree<T> {
    public Node<T> root;

    public BinTree() {
    }

    /**
     * The time complexity is O(N) N is the number of nodes in the tree.
     */
    public void populateParent() {
        populateParent(root);
    }

    private void populateParent(Node<T> node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            node.left.parent = node;
            populateParent(node.left);
        }

        if (node.right != null) {
            node.right.parent = node;
            populateParent(node.right);
        }
    }
}
