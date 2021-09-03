package com.hungdoan.collection.list;

import com.hungdoan.collection.Iterator;

public class LinkedListIterator<T> implements Iterator<T> {
	
	private Node<T> iterator;
	private Node<T> tail;
	
	public LinkedListIterator(Node<T> head, Node<T> tail) {
		this.iterator = head;
		this.tail = tail;
	}
	
	@Override
	public boolean hasNext() {	 
		if (iterator != null) {
			if(iterator.getNext() != null) {
				return true; 		
			}
			else {
				return (iterator == tail);
			}
		}		
		return false;
	}

	@Override
	public T next() {
		T value = iterator.getValue();
		iterator = iterator.getNext();
		return value;
	}
}
