package com.learnJava.myOwnCollection.genericLinkedList;

public class GenericLinkedList<T> {
	private GenericNode<T> headNode;
	private GenericNode<T> tailNode;
	
	public GenericNode<T> getHeadNode() {
		return headNode;
	}
	
	public void setHeadNode(GenericNode<T> headNode) {
		this.headNode = headNode;
	}
	
	public GenericNode<T> getTailNode() {
		return tailNode;
	}
	
	public void setTailNode(GenericNode<T> tailNode) {
		this.tailNode = tailNode;
	}
	
	public GenericLinkedList()
	{
		this.headNode = null;
		this.tailNode = null;
	}
	
	public boolean isEmptyList()
	{
		if(this.headNode == null)
		{
			return true;
		}
		return false;
	}
		
	public void InsertFirst(T data)
	{
		GenericNode<T> newNode = new GenericNode<T>(data);
		if(this.isEmptyList())
		{
			this.headNode = newNode;
			this.tailNode = this.headNode;
		}
		else 
		{
			newNode.setNextNode(this.headNode);
			this.headNode.setPreviousNode(newNode);
			this.headNode = newNode;
		}
	}
	
	public void InsertLast(T data)
	{
		GenericNode<T> newNode = new GenericNode<T>(data);
		if(this.isEmptyList())
		{
			this.headNode = newNode;
			this.tailNode = this.headNode;
		}
		else 
		{			
			this.tailNode.setNextNode(newNode);
			newNode.setPreviousNode(this.tailNode);
			this.tailNode = newNode;
		}
	}
	
	public void InsertAfterP(T data, GenericNode<T> pNode)
	{
		GenericNode<T> newNode = new GenericNode<T>(data);
		if(!this.isEmptyList())
		{		
			newNode.setNextNode(pNode.getNextNode());
			newNode.setPreviousNode(pNode);
			pNode.setNextNode(newNode);
		}
	}
	
	public void RemoveFirst()
	{						
		if(!this.isEmptyList())
		{
			if(this.headNode == this.tailNode)
			{
				this.headNode = null;
				this.tailNode = this.headNode;
			}
			else 
			{				
				this.headNode = this.headNode.getNextNode();
				this.headNode.setPreviousNode(null);
			}			
		}
	}
	
	public void RemoveLast()
	{						
		if(!this.isEmptyList())
		{
			if(this.headNode == this.tailNode)
			{
				this.headNode = null;
				this.tailNode = this.headNode;
			}
			else 
			{
				GenericNode<T> currentNode = this.tailNode.getPreviousNode();
				currentNode.setNextNode(null);
				this.tailNode = currentNode;
			}			
		}
	}
	
	public void RemoveAfterP(GenericNode<T> pNode)
	{
		if(!this.isEmptyList())
		{
			if(this.headNode == this.tailNode)
			{
				this.headNode = null;
				this.tailNode = this.headNode;
			}
			else 
			{
				if(pNode != this.tailNode)
				{
					pNode.setNextNode(pNode.getNextNode().getNextNode());
					if(pNode.getNextNode() == null)
					{
						this.tailNode = pNode;
					}
				}
				else 
				{
					System.out.println("P is the tail of this linked list so we don't have any node after to delete");
				}
			}
		}
	}
	
	public GenericNode<T> FindANode(T data)
	{
		boolean flag = false;
		GenericNode<T> currentNode = this.headNode;
		while(currentNode != null)
		{
			if(currentNode.getData() == data)
			{
				flag = true;
				break;
			}
			currentNode = currentNode.getNextNode();
		}
		if(flag)
		{
			return currentNode;
		}
		System.out.println("We can not find any node whose data equals this data you have provived us");
		return null;
	}
	
	public void PrintOut()
	{		
		GenericNode<T> currentNode = this.headNode;
		while(currentNode != null)
		{
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNextNode();
		}			
		System.out.println("\n");
	}
}
