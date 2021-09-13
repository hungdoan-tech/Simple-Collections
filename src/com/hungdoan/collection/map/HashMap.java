package com.hungdoan.collection.map;

import com.hungdoan.collection.Iterator;
import com.hungdoan.collection.list.LinkedList;

import java.util.Arrays;
import java.util.Objects;

/**
 * Separate Chaining Fashion HashMap
 */
public class HashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 16;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int size = 0;

    private int capacity;

    private float loadFactor;

    private int threshold;

    private LinkedList<Entry<K, V>>[] bucket;

    public HashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int capacity, float loadFactor) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity value is negative and not valid");
        }
        if (loadFactor <= 0 || Double.isNaN(loadFactor) || Double.isInfinite(loadFactor)) {
            throw new IllegalArgumentException("Load factor value is not valid");
        }
        this.loadFactor = loadFactor;
        this.capacity = Integer.max(DEFAULT_CAPACITY, capacity);
        this.threshold = (int) (this.capacity * this.loadFactor);
        this.bucket = new LinkedList[this.capacity];
    }

    private int hashcodeToIndex(int hashcode) {
        int index = hashcode % this.capacity;
        return 0;
    }

    @Override
    public Iterator<K> iterator() {

        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean containsKey(K key) {
        int index = this.hashcodeToIndex(key.hashCode());
        LinkedList<Entry<K, V>> entryLinkedList = this.bucket[index];
        if (Objects.isNull(entryLinkedList)) {
            return false;
        }
        Iterator<Entry<K, V>> iterator = entryLinkedList.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> currentEntry = iterator.next();
            if (currentEntry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public V get(K key) {
        int index = this.hashcodeToIndex(key.hashCode());
        LinkedList<Entry<K, V>> entryLinkedList = this.bucket[index];
        if (Objects.isNull(entryLinkedList)) {
            return null;
        }
        Iterator<Entry<K, V>> iterator = entryLinkedList.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> currentEntry = iterator.next();
            if (currentEntry.getKey().equals(key)) {
                return currentEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index = this.hashcodeToIndex(key.hashCode());
        LinkedList<Entry<K, V>> entryLinkedList = this.bucket[index];
        if (Objects.isNull(entryLinkedList)) {
            this.bucket[index] = new LinkedList<>();
            entryLinkedList = this.bucket[index];
        }
        Iterator<Entry<K, V>> iterator = entryLinkedList.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> currentEntry = iterator.next();
            if (!currentEntry.getKey().equals(key)) {
                if (this.size >= this.threshold) {
                    this.handleResizingBucket();
                    this.put(key, value);
                } else {
                    entryLinkedList.insert(new Entry<>(key, value));
                }
                break;
            }
        }
        return value;
    }

    private void handleResizingBucket() {
        // TODO: handle resize bucket
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> otherMap) {

    }

    @Override
    public void clear() {
        Arrays.fill(this.bucket, null);
        this.size = 0;
    }
}
