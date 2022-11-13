package edu.northeastern.midterm.question3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Node<Integer> root = getBST();
        printValuesInsideRange(root, 5, 8);
    }

    /**
     * The time complexity is O(N). The N is the number of nodes in the tree.
     */
    public static void printValuesInsideRange(Node<Integer> root, int start, int end) {
        List<Integer> nums = new ArrayList<>();
        inOrderTraversal(root, nums);

        for (int i : nums) {
            if (start <= i && i <= end) {
                System.out.print(i + " ");
            }
        }
    }

    private static void inOrderTraversal(Node<Integer> root, List<Integer> nums) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left, nums);
        nums.add(root.data);
        inOrderTraversal(root.right, nums);
    }

    // Given range between 5 and 8 it will print 6, 7, 8
    private static Node<Integer> getBST() {
        Node<Integer> root = new Node<>(8);
        root.parent = root;

        root.left = new Node<>(3);
        root.right = new Node<>(10);
        root.left.parent = root;
        root.right.parent = root;


        root.left.left = new Node<>(1);
        root.left.right = new Node<>(6);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;

        root.right.right = new Node<>(14);
        root.right.right.parent = root.right;

        root.left.right.left = new Node<>(4);
        root.left.right.right = new Node<>(17);
        root.left.right.left.parent = root.left.right;
        root.left.right.right.parent = root.left.right;


        root.right.right.left = new Node<>(13);
        root.right.right.left.parent = root.right.right;


        return root;
    }

}
