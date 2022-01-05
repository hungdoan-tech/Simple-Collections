package com.hungdoan.collection.queue;

public interface Queue<T> {

    void enQueue(T element);

    T deQueue();

    T peek();
}
