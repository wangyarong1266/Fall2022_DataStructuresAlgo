package edu.northeastern.midterm.question2;

public class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node<T> parent;

    public Node(T data) {
        this.data = data;
    }
}
