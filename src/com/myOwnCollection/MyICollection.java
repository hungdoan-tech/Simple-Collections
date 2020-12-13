package com.myOwnCollection;

public interface MyICollection<T> extends MyIIterable<T> {
	boolean add(T obj);
	boolean remove(T obj);
	boolean contains(T obj);
	boolean isEmpty();
	void clear();	
	int size();
}
