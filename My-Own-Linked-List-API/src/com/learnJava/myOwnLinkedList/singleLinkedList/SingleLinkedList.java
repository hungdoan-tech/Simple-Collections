package com.learnJava.myOwnLinkedList.singleLinkedList;

import com.learnJava.myOwnLinkedList.doubleLinkedList.Node;

public class SingleLinkedList {
	private Node headNode;
	private Node tailNode;
	
	public Node getHeadNode() {
		return headNode;
	}
	
	public void setHeadNode(Node headNode) {
		this.headNode = headNode;
	}
	
	public Node getTailNode() {
		return tailNode;
	}
	
	public void setTailNode(Node tailNode) {
		this.tailNode = tailNode;
	}
	
	public SingleLinkedList()
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
		
	public void InsertFirst(int data)
	{
		Node newNode = new Node(data);
		if(this.isEmptyList())
		{
			this.headNode = newNode;
			this.tailNode = this.headNode;
		}
		else 
		{
			newNode.setNextNode(this.headNode);
			this.headNode = newNode;
		}
	}
	
	public void InsertLast(int data)
	{
		Node newNode = new Node(data);
		if(this.isEmptyList())
		{
			this.headNode = newNode;
			this.tailNode = this.headNode;
		}
		else 
		{			
			this.tailNode.setNextNode(newNode);
			this.tailNode = newNode;
		}
	}
	
	public void InsertAfterP(int data, Node pNode)
	{
		Node newNode = new Node(data);
		if(!this.isEmptyList())
		{		
			newNode.setNextNode(pNode.getNextNode());
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
				Node currentNode = this.headNode;
				while(currentNode.getNextNode() != this.tailNode)
				{
					currentNode = currentNode.getNextNode();
				}			
				currentNode.setNextNode(null);
				this.tailNode = currentNode;
			}			
		}
	}
	
	public void RemoveAfterP(Node pNode)
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
	
	public Node FindANode(int data)
	{
		boolean flag = false;
		Node currentNode = this.headNode;
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
		Node currentNode = this.headNode;
		while(currentNode != null)
		{
			System.out.print(currentNode.getData()+" ");
			currentNode = currentNode.getNextNode();
		}			
		System.out.println("\n");
	}
}
