package com.hungdoan.collection;

public interface List<T> extends Collection<T> {
	public T getAt(int index);
	public boolean removeAt(int index);
}
