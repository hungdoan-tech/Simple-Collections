package com.hungdoan.presentation;

import com.hungdoan.collection.Iterator;
import com.hungdoan.collection.list.LinkedList;
import com.hungdoan.collection.list.List;

public class LinkedListPresentation {

	public static void main(String[] args) {
		List<Integer> linkedList = new LinkedList<>();
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(9);
		linkedList.insertAt(20, 1);
		System.out.println(linkedList.toString());

		System.out.println(linkedList.toString());
		System.out.println(linkedList.size());
		System.out.println(linkedList.indexOf(9));
		System.out.println(linkedList.getAt(1));

		linkedList.reverse();
		Iterator<Integer> iterator = linkedList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
