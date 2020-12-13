package com.myOwnCollection;

public interface MyIList<T> extends MyICollection<T> {
	int search(T obj);
	T get(int index);
	boolean set(int index, T object);
}
