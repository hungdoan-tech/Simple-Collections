package com.hungdoan.collection;

public class Presentation {
	
	public static void main(String[] args) {		
//		ArrayListImplementation();
		LinkedListImplementation();
	}

	private static void LinkedListImplementation() {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(9);
		System.out.println(linkedList.toString());
		System.out.println(linkedList.size());
		System.out.println(linkedList.indexOf(9));
		System.out.println(linkedList.getAt(1));
		
//		arrList.reverse();
//		Iterator<Integer> iterator = arrList.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
//		
//		LinkedList<Integer> arrList2 = new LinkedList<Integer>(3);
//		arrList2.insert(3);
//		arrList2.insert(5);
//		arrList2.insert(9);
//		arrList2.insertAt(21, 1);
//		
//		ArrayList<Integer> arr3 = arrList.intersect(arrList2);
//		System.out.println(arr3.toString());
	}
	
	private static void ArrayListImplementation() {
		ArrayList<Integer> arrList = new ArrayList<Integer>(3);
		arrList.insert(3);
		arrList.insert(4);
		arrList.insert(9);
		arrList.insertAt(20, 1);
		System.out.println(arrList.toString());
		
		arrList.reverse();
		Iterator<Integer> iterator = arrList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		ArrayList<Integer> arrList2 = new ArrayList<Integer>(3);
		arrList2.insert(3);
		arrList2.insert(5);
		arrList2.insert(9);
		arrList2.insertAt(21, 1);
		
		ArrayList<Integer> arr3 = arrList.intersect(arrList2);
		System.out.println(arr3.toString());
	}
}
