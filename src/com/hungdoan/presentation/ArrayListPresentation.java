package com.hungdoan.presentation;

import com.hungdoan.collection.ArrayList;
import com.hungdoan.collection.Iterator;
import com.hungdoan.collection.List;

public class ArrayListPresentation {
    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>(3);
        arrList.add(3);
        arrList.add(4);
        arrList.add(9);
        arrList.insertAt(20, 1);
        System.out.println(arrList.toString());

        arrList.reverse();
        Iterator<Integer> iterator = arrList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
