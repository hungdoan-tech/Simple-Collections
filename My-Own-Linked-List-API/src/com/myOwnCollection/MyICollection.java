package com.myOwnCollection;

import java.util.Objects;

public interface MyICollection extends MyIIterable {
	boolean add(Objects obj);
	boolean remove(Objects obj);
	boolean contains(Objects obj);
	boolean isEmpty();
	void clear();	
	int size();
}
