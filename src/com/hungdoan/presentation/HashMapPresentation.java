package com.hungdoan.presentation;

import com.hungdoan.collection.map.HashMap;
import com.hungdoan.collection.map.Map;

public class HashMapPresentation {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 3);
        map.put('d', 4);
        System.out.println(map);
        map.remove('b');
        System.out.println(map);
    }
}
