package com.hungdoan.collection;

public interface List<T> extends Collection<T> {
	T getAt(int index);
	boolean removeAt(int index);
	T max();
	void reverse();
	boolean insertAt(T value, int index);
}
