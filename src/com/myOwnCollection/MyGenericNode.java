package com.myOwnCollection;

public class MyGenericNode<T> implements MyIIterator<T>
{
	private T data;
	private MyGenericNode<T> iteratedNode;
	private MyGenericNode<T> nextNode;
	private MyGenericNode<T> previousNode;
	
	public T getData() 
	{
		return data;
	}
	
	public void setData(T data) 
	{
		this.data = data;
	}
	
	public MyGenericNode<T> getIteratedNode() 
	{
		return iteratedNode;
	}

	public void setCurrentNode(MyGenericNode<T> iteratedNode) 
	{
		this.iteratedNode = iteratedNode;
	}
	
	public MyGenericNode<T> getNextNode() 
	{
		return nextNode;
	}
	
	public void setNextNode(MyGenericNode<T> nextNode) 
	{
		this.nextNode = nextNode;
	}
	
	public MyGenericNode<T> getPreviousNode()
	{
		return previousNode;
	}
	
	public void setPreviousNode(MyGenericNode<T> previousNode) 
	{
		this.previousNode = previousNode;
	}
	
	public MyGenericNode(T obj)
	{
		this.data = obj;		
		this.nextNode = null;
		this.previousNode =null;
	}
	
	public MyGenericNode(MyGenericNode<T> obj)
	{
		this.iteratedNode = obj;
	}
	
	@Override
	public MyIIterator<T> iterator() {	
		return this;
	}
	
	@Override
	public boolean hasNext() {		
		return (this.iteratedNode != null) ? true : false;
	}

	@Override
	public T next() {
		T temp = this.iteratedNode.data;
		this.iteratedNode = this.nextNode;
		return temp;
	}
	
	@Override
	public void remove() {
		// I think it's useless, maybe i considers to remove it later
	}
}
