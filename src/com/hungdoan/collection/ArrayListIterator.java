package com.hungdoan.collection;

public class ArrayListIterator<T> implements Iterator<T>{

	private ArrayList<T> arrayList;
	
	private int currentIndex; 
	
	public ArrayListIterator(ArrayList<T> arrayList) {
		this.arrayList = arrayList;
		this.currentIndex = 0;
	}
	
	@Override
	public boolean hasNext() {		
		return (this.currentIndex < this.arrayList.getCurrentIndex()) ? true : false;
	}

	@Override
	public T next() {		
		return (T) (this.arrayList.getAt(this.currentIndex++));
	}
}
