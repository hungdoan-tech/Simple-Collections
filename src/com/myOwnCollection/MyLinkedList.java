package com.myOwnCollection;

public class MyLinkedList<T> implements MyIList<T>
{
	private MyGenericNode<T> head;
	private MyGenericNode<T> tail;
	
	public MyGenericNode<T> getHead() 
	{
		return head;
	}
	
	public void setHead(MyGenericNode<T> head) 
	{
		this.head = head;
	}
	
	public MyGenericNode<T> getTail() 
	{
		return tail;
	}
	
	public void setTail(MyGenericNode<T> tail) 
	{
		this.tail = tail;
	}
	
	@Override
	public boolean add(T obj) {
		MyGenericNode<T> temp = new MyGenericNode<T>(obj);
		if(this.head == null)
		{
			this.head = this.tail = temp;
			return true;
		}
		this.tail.setNextNode(temp);
		this.tail = temp;
		return true;
	}
	
	@Override
	public boolean remove(T obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean contains(T obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public MyIIterator<T> iterator() {	
		MyGenericNode<T> tempGenericNode = new MyGenericNode<T>(this.getHead());
		return tempGenericNode.iterator();
	}
	@Override
	public int search(T obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean set(int index, T object) {
		// TODO Auto-generated method stub
		return false;
	}	
}
