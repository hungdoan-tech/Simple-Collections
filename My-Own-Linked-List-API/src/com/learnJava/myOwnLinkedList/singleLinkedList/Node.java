package com.learnJava.myOwnLinkedList.singleLinkedList;

public class Node {
	private int data;
	private Node nextNode;
	private Node previousNode;
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public Node getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	public Node getPreviousNode() {
		return previousNode;
	}
	
	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}
	
	public Node(int data) {
		this.data = data;
		this.nextNode = null;
		this.previousNode = null;
	}
}
