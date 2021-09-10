package com.hungdoan.presentation;

import com.hungdoan.data_structure.BinarySearchTree;
import com.hungdoan.data_structure.OrderTraversalType;

public class BinarySearchTreePresentation {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        binaryTree.insert(2);
        binaryTree.insert(0);
        binaryTree.insert(4);
        binaryTree.insert(-1);
        binaryTree.insert(5);
        binaryTree.deepFirstTraversal(OrderTraversalType.PRE_ORDER);
        binaryTree.deepFirstTraversal(OrderTraversalType.IN_ORDER);
        binaryTree.deepFirstTraversal(OrderTraversalType.POST_ORDER);
    }
}
