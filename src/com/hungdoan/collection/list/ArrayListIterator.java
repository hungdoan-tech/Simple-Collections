package com.hungdoan.collection.list;

import com.hungdoan.collection.Iterator;
import com.hungdoan.collection.list.ArrayList;

public class ArrayListIterator<T> implements Iterator<T> {

	private ArrayList<T> arrayList;
	
	private int currentIndex; 
	
	public ArrayListIterator(ArrayList<T> arrayList) {
		this.arrayList = arrayList;
		this.currentIndex = 0;
	}
	
	@Override
	public boolean hasNext() {		
		return (this.currentIndex < this.arrayList.getCurrentIndex());
	}

	@Override
	public T next() {		
		return (T) (this.arrayList.getAt(this.currentIndex++));
	}
}
