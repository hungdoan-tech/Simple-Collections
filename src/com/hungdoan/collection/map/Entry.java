package com.hungdoan.collection.map;

public class Entry<K, V> {

    private final int hash;

    private final K key;

    private final V value;

    public Entry(K key, V value) {
        this.hash = key.hashCode();
        this.key = key;
        this.value = value;
    }

    public boolean equals(Entry<K, V> other) {
        if (other.hash != this.hash) {
            return false;
        }
        return key.equals(other.key);
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
