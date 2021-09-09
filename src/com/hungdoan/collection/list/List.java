package com.hungdoan.collection.list;

import com.hungdoan.collection.Collection;

public interface List<T> extends Collection<T> {
	T getAt(int index);
	boolean removeAt(int index);
	void reverse();
	List<T> merge(List<T> otherList);
	boolean insertAt(T value, int index);
	int indexOf(T value);
}
