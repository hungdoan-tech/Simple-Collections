package com.myOwnCollection;

import java.util.Objects;

public interface MyIIterator extends MyIIterable {
	//check that is the iteration has the next or not
	boolean hasNext();
	
	// Return current data and update pointer 
	Objects next();
	
	// Remove the next element in the iteration
	// This method can be called only once per call
	// to next()
	void remove();
}
