package com.hungdoan.collection;

public interface Iterator<T> {
    boolean hasNext();

    T next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
