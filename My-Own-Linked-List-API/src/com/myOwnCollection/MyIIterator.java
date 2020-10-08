package com.myOwnCollection;

public interface MyIIterator<T> extends MyIIterable<T> {
	//check that is the iteration has the next or not
	boolean hasNext();
	
	//Return the next  element in the iteration
	T next();
	
	// Remove the next element in the iteration
	// This method can be called only once per call
	// to next()
	void remove();
}
