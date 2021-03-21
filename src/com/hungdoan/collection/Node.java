package com.hungdoan.collection;

public class Node<T> {
	private T value;
	
	private Node<T> next;
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return this.next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node() {
		
	}
	
	public Node(T value) {
		this.value = value;
	}
}
