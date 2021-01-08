package com.myOwnCollection;

public class LinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	
	public Node<T> getHead() {
		return head;
	}

	public Node<T> getTail() {
		return tail;
	}
	
	public void addFirst(T tData) {
		if(this.checkEmpty()) {
			
			Node<T> tempNode = new Node<T>(tData);
			this.head = tempNode;
			this.tail = this.head;			
			
		} else {
			
			Node<T> tempNode = new Node<T>(tData);
			tempNode.setNextNode(this.head);
			this.head = tempNode;
			
		}
	}
	
	public void addLast(T tData) {
		if(this.checkEmpty()) {
			
			Node<T> tempNode = new Node<T>(tData);
			this.head = tempNode;
			this.tail = this.head;			
			
		} else {
			
			Node<T> tempNode = new Node<T>(tData);
			this.tail.setNextNode(tempNode);
			this.tail = tempNode;			
		}
	}
	
	public boolean remove(T tData) {
		if(!this.checkEmpty()) {
						
			if(this.head.getData() == tData) {
				this.removeFirst();
			}
			else if(this.tail.getData() == this.tail) {
				this.removeLast();
			}
			else {
				
				boolean flag = false;
				Node<T> nextToDeletedNode = null;
				Node<T> loopVar = this.head;
				while(loopVar.getNextNode() != null) {
					
					if(loopVar.getNextNode().getData() == tData) {				
						flag =  true;
						break;
					}
					loopVar = loopVar.getNextNode();
				}
				if(flag == true) {
					nextToDeletedNode =  loopVar;
					Node<T> deletedNode = nextToDeletedNode.getNextNode();
					nextToDeletedNode.setNextNode(deletedNode.getNextNode());
					deletedNode = null;
				}
				else {
					
					return false;
				}				
			}
			return true;
		}
		return false; 
	}
	
	public void removeFirst() {
		if(!this.checkEmpty()) {
			Node<T> tempNode = this.head;
			this.head =  this.head.getNextNode();
			tempNode = null;
		} 
	}
	
	public void removeLast() {
		if(!this.checkEmpty()) {
			
			Node<T> nextToTail = null;
			Node<T> loopVar = this.head;
			while(loopVar.getNextNode() != this.tail) {
				nextToTail = loopVar; 
				loopVar = loopVar.getNextNode();
			}
						
			Node<T> previousTail = this.tail;
			this.tail =  nextToTail;
			previousTail = null;
		} 
	}
	
	public boolean checkEmpty() {		
		return (this.head == null && this.tail == null) ? true : false;
	}
	
	public boolean contain(T tData) {
		if(!this.checkEmpty()) {
			
			boolean flag = false;			
			Node<T> loopVar = this.head;
			while(loopVar != null) {
				
				if(loopVar.getData() == tData) {				
					flag =  true;
					break;
				}
				loopVar = loopVar.getNextNode();
			}
			return flag;
		}		
		return false;
	}
	
	public int indexOf(T tData) {		
		return 0;
	}
	
	public void print() {
		if(!this.checkEmpty()) {
			
			StringBuilder output = new StringBuilder("");			
			Node<T> loopVar = this.head;
			while(loopVar != null) {
				output.append(" "+ loopVar.getData());
				loopVar = loopVar.getNextNode();
			}			
			System.out.println(output.toString());
		}		
	}
}
