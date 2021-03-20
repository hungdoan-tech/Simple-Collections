package com.hungdoan.collection;

public interface Collection<T> extends Iterable<T> {
	public boolean insert(T inValue);
	public boolean contain(T inValue);
	public boolean isEmpty();
	public void clear();
	public int size();
}
