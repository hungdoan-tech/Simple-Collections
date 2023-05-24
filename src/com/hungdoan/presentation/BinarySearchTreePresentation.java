package com.hungdoan.presentation;

import com.hungdoan.collection.BinarySearchTree;
import com.hungdoan.collection.OrderTraversalType;

public class BinarySearchTreePresentation {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        int[] arr = {10, -1, 20, 13, 25, -15, 5, 1, 7, -25, -10};
        for (int element : arr) {
            binaryTree.insert(element);
        }
        binaryTree.deepFirstTraversal(OrderTraversalType.IN_ORDER);
        binaryTree.print();
        binaryTree.remove(-1);
        binaryTree.insert(3);
        binaryTree.print();
        binaryTree.deepFirstTraversal(OrderTraversalType.IN_ORDER);
    }
}
