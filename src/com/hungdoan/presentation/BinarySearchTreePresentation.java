package com.hungdoan.presentation;

import com.hungdoan.data_structure.BinarySearchTree;

public class BinarySearchTreePresentation {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        binaryTree.insert(5);
        binaryTree.insert(2);
        binaryTree.insert(7);
        binaryTree.insert(-1);
        binaryTree.insert(0);
        System.out.println(binaryTree.contain(-1));
        binaryTree.delete(-1);
        System.out.println(binaryTree.contain(-1));
        System.out.println("Hung Doan");
    }
}
