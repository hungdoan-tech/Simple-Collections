package com.learnJava.myOwnCollection.genericLinkedList;

import com.myOwnCollection.MyIIterator;

// Create a wrapper for T type with Generic Class
public class GenericNode<T> implements MyIIterator<T> {
	private T data;
	private GenericNode<T> nextNode;
	private GenericNode<T> previousNode;
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public GenericNode<T> getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(GenericNode<T> nextNode) {
		this.nextNode = nextNode;
	}
	
	public GenericNode<T> getPreviousNode() {
		return previousNode;
	}
	
	public void setPreviousNode(GenericNode<T> previousNode) {
		this.previousNode = previousNode;
	}
	
	public GenericNode(T data) {
		this.data = data;
		this.nextNode = null;
		this.previousNode = null;
	}
}
