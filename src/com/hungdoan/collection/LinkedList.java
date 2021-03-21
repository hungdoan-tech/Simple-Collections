package com.hungdoan.collection;

public class LinkedList<T> implements List<T>{
	
	private Node<T> head;
	
	private Node<T> tail;
	
	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	private Node<T> createNewNode(T value) {
		Node<T> node = new Node<T>(value);			
		node.setNext(null);
		return node;
	}
	
	private boolean checkInputIndex(int index) {
		return (index < 0 || index > this.size()) ? false : true;
	}
	
	@Override
	public boolean insert(T inValue) {
		if(this.isEmpty()) {
			Node<T> node = this.createNewNode(inValue);
			this.head = node;	
			this.tail = node;			
			return true;
		}
		
		Node<T> node = this.createNewNode(inValue);		
		Node<T> oldTail = this.tail;
		oldTail.setNext(node);
		this.tail = node;
		
		return true;
	}

	@Override
	public boolean contain(T inValue) {
		Iterator<T> iterator = this.iterator();		
		while(iterator.hasNext()) {
			if(iterator.next() == inValue) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (this.tail == null && this.head == null) ? true : false; 		
	}

	@Override
	public void clear() {
		
	}

	@Override
	public int size() {
		Iterator<T> iterator = this.iterator();
		int count = 0;
		while(iterator.hasNext()) {
			iterator.next();
			count++;
		}
		return count;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new LinkedListIterator<T>(this.head, this.tail);
		return iterator;
	}
	
	@Override
	public T getAt(int index) {		
		if(!checkInputIndex(index)) return null;		
		Iterator<T> iterator = this.iterator();
		int count = 0;
		while(iterator.hasNext()) {
			if(count++ == index) {
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

	@Override
	public void reverse() {
		
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
		
		while(iterator.hasNext()) {
			stringBuilder.append(iterator.next());
			stringBuilder.append(",");
		}
		stringBuilder.deleteCharAt(stringBuilder.length()-1);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	@Override
	public int indexOf(T value) {
		Iterator<T> iterator = this.iterator();
		int count = 0;
		while(iterator.hasNext()) {
			if(iterator.next() == value) {
				return count;
			}				
			count++;
		}
		return -1;
	}
}
