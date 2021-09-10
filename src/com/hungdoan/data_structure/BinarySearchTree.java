package com.hungdoan.data_structure;

import java.util.Objects;

/**
 * This is the simple implementation of Binary Search Tree data structure
 *
 * @param <T> which extends from Comparable interface to have the constraints which must have
 *            the comparable ability to perform operations
 */
public class BinarySearchTree<T extends Comparable> implements Tree<T> {

    private Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    private Node<T> createANewNode(T data) {
        return new Node<>(data);
    }

    /**
     * This method is used to create an abstraction for inserting a T value to the current BST
     *
     * @param value the value which we want to insert
     * @return T
     */
    @Override
    public T insert(T value) {
        Objects.nonNull(value);
        if (Objects.isNull(root)) {
            this.root = createANewNode(value);
            return value;
        }
        Node<T> requiredNode = performInsert(this.root, value);
        return requiredNode.getData();
    }

    /**
     * This method is used to insert a T value to the current BST by the recursive manner
     *
     * @param node  which must be the root node in the first time's input
     * @param value the value which we want to insert
     * @return Node<T>
     */
    private Node<T> performInsert(Node<T> node, T value) {
        if (Objects.isNull(node)) {
            node = createANewNode(value);
            return node;
        }
        int comparedResult = node.getData().compareTo(value);
        if (comparedResult == 0) {
            return node;
        }
        if (comparedResult > 0) {
            Node<T> futureLeftNode = performInsert(node.left, value);
            node.setLeft(futureLeftNode);
            return node;
        }
        Node<T> futureRightNode = performInsert(node.right, value);
        node.setRight(futureRightNode);
        return node;
    }

    /**
     * This method is used to create an abstraction for checking a T value is be contained in the current BST or not
     *
     * @param value the value which we want to seek
     * @return boolean
     */
    @Override
    public boolean contain(T value) {
        Objects.nonNull(value);
        Node<T> expectedNode = this.performContain(root, value);
        return !Objects.isNull(expectedNode);
    }

    /**
     * This method is used to check a T value is be contained in the current BST or not by the recursive manner
     *
     * @param node  which must be the root node in the first time's input
     * @param value the value which we want to seek
     * @return
     */
    private Node<T> performContain(Node<T> node, T value) {
        if (Objects.isNull(node)) {
            return null;
        }
        int comparedResult = node.getData().compareTo(value);
        if (comparedResult == 0) {
            return node;
        }
        if (comparedResult > 0) {
            return performContain(node.left, value);
        }
        return performContain(node.right, value);
    }

    /**
     * This method is used to create an abstraction for deleting the node which have T data value in the current BST
     *
     * @param value
     */
    @Override
    public void delete(T value) {
        this.performDelete(root, value);
    }

    /**
     * This method is used to delete the node which have T data value in the current BST by the recursive manner.
     *
     * @param node
     * @param value
     * @return
     */
    private Node<T> performDelete(Node<T> node, T value) {
        int comparedResult = node.getData().compareTo(value);
        if (comparedResult == 0) {
            return null;
        }
        if (comparedResult > 0) {
            Node<T> futureLeftNode = performDelete(node.left, value);
            node.setLeft(futureLeftNode);
            return node;
        }
        Node<T> futureRightNode = performDelete(node.right, value);
        node.setRight(futureRightNode);
        return node;
    }

    /**
     * This method is used to create an abstraction for BST traversal manners
     *
     * @param orderTraversalType
     */
    public void deepFirstTraversal(OrderTraversalType orderTraversalType) {
        switch (orderTraversalType) {
            case PRE_ORDER: {
                this.preOrderTraversal(this.root);
                break;
            }
            case IN_ORDER: {
                this.inOrderTraversal(this.root);
                break;
            }
            case POST_ORDER: {
                this.postOrderTraversal(this.root);
                break;
            }
            default: {
                break;
            }
        }
        System.out.println();
        return;
    }

    /**
     * Tree traversal in pre-order recursive fashion - the node root will be printed out firstly after that will be respectively all left nodes and all right nodes
     *
     * @param node which must be the root node in the first time's input
     */
    private void preOrderTraversal(Node<T> node) {
        if (Objects.isNull(node)) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /**
     * Tree traversal in in-order fashion - the node root will be printed out in the middle between all it's left nodes and all it's right nodes
     *
     * @param node which must be the root node in the first time's input
     */
    private void inOrderTraversal(Node<T> node) {
        if (Objects.isNull(node)) {
            return;
        }
        preOrderTraversal(node.left);
        System.out.print(node.data + " ");
        preOrderTraversal(node.right);
    }

    /**
     * Tree traversal in post-order recursive fashion - the node root will be printed out lately after respectively all left nodes and all right nodes
     *
     * @param node which must be the root node in the first time's input
     */
    private void postOrderTraversal(Node<T> node) {
        if (Objects.isNull(node)) {
            return;
        }
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * This is a simple Node class for constructing BST
     * This is stored as a nested class for enhancing the encapsulation purpose
     *
     * @param <E> which is similar to T in the outer class
     */
    private class Node<E extends Comparable> {

        private E data;

        private Node<E> left;

        private Node<E> right;

        public Node() {

        }

        public Node(E data) {
            Objects.nonNull(data);
            this.data = data;
            setLeft(null);
            setRight(null);
        }

        E getData() {
            return data;
        }

        void setData(E data) {
            this.data = data;
        }

        Node<E> getLeft() {
            return left;
        }

        void setLeft(Node<E> left) {
            this.left = left;
        }

        Node<E> getRight() {
            return right;
        }

        void setRight(Node<E> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left.getData() +
                    '}';
        }
    }
}
