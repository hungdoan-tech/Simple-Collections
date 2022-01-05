package com.hungdoan.presentation;

import com.hungdoan.collection.queue.Queue;
import com.hungdoan.collection.queue.SimpleQueueImpl;

public class SimpleQueuePresentation {

    public static void main(String args[]) {
        Queue<Integer> q = new SimpleQueueImpl<>();

        for (int i = 1; i < 10; i++) {
            q.enQueue(i);
        }
        System.out.println(q);

        q.deQueue();

        System.out.println(q.peek());

        System.out.println(q);
    }
}
