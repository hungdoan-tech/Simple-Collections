package com.hungdoan.collection.list;

import com.hungdoan.collection.Iterator;

public class LinkedList<T> implements List<T> {

	private Node<T> head;

	private Node<T> tail;

	public LinkedList() {
		this.head = null;
		this.tail = null;
	}

	private Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	private Node<T> getTail() {
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
		this.tail.setNext(null);
	}

	private Node<T> createNewNode(T value) {
		Node<T> node = new Node<>(value);
		node.setNext(null);
		return node;
	}

	private boolean checkInputIndex(int index) {
		return (index < 0 || index > this.size());
	}

	@Override
	public boolean insert(T inValue) {
		if (this.isEmpty()) {
			Node<T> node = this.createNewNode(inValue);
			this.head = node;
			this.tail = node;
		} else {
			Node<T> node = this.createNewNode(inValue);
			Node<T> oldTail = this.tail;
			oldTail.setNext(node);
			this.tail = node;
		}
		return true;
	}

	@Override
	public boolean contain(T inValue) {
		Iterator<T> iterator = this.iterator();
		while (iterator.hasNext()) {
			if (iterator.next() == inValue) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (this.tail == null && this.head == null);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
	}

	@Override
	public int size() {
		Iterator<T> iterator = this.iterator();
		int count = 0;
		while (iterator.hasNext()) {
			iterator.next();
			count++;
		}
		return count;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator<>(this.head, this.tail);
	}

	@Override
	public T getAt(int index) {
		if (!checkInputIndex(index)) {
			return null;
		}
		Iterator<T> iterator = this.iterator();
		int count = 0;
		while (iterator.hasNext()) {
			if (count++ == index) {
				return iterator.next();
			}
			iterator.next();
		}
		return null;
	}

	@Override
	public boolean removeAt(int index) {
		return false;
	}

	/**
	 * This method is used to reverse the current linked list
	 * It absolutely hides the actually private complex function which perform this reversal
	 */
	@Override
	public void reverse() {
		this.performReverseByRecursion(this.getHead());
	}

	/**
	 * This method is used to reverse the current linked list using recursion manner
	 * @param currentNode - this parameter is must be the head node of the current linked list at the
	 * consumer calling context
	 * @return Node<T> stands for the new head node of the reversed linked list
	 */
	private Node<T> performReverseByRecursion(Node<T> currentNode) {
		if (currentNode == null || currentNode.getNext() == null) {
			this.setHead(currentNode);
			return currentNode;
		}
		Node<T> nextNode = performReverseByRecursion(currentNode.getNext());
		nextNode.setNext(currentNode);
		this.setTail(currentNode);
		return currentNode;
	}


	/**
	 * This method is used to reverse the current linked list but because it's using iteration - make code more complex
	 * than recursion - so I have decided to disable it and used recursion manner instead
	 */
	@Deprecated
	private void performReverseByIteration() {
		if (this.isEmpty()) {
			throw new UnsupportedOperationException();
		}
		Node<T> headNode = this.getHead();
		Node<T> previousNode = null;
		Node<T> currentNode = headNode;
		while (currentNode != null) {
			Node<T> nextNode = currentNode.getNext();
			currentNode.setNext(previousNode);
			previousNode = currentNode;
			currentNode = nextNode;
			if (currentNode == this.getTail()) {
				this.setHead(currentNode);
			}
		}
		this.setTail(headNode);
	}

	@Override
	public List<T> merge(List<T> otherList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertAt(T value, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		Iterator<T> iterator = this.iterator();
		StringBuilder stringBuilder = new StringBuilder("[");

		while (iterator.hasNext()) {
			stringBuilder.append(iterator.next());
			stringBuilder.append(",");
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	@Override
	public int indexOf(T value) {
		Iterator<T> iterator = this.iterator();
		int count = 0;
		while (iterator.hasNext()) {
			if (iterator.next() == value) {
				return count;
			}
			count++;
		}
		return -1;
	}
}
