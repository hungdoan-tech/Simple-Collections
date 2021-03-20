package com.hungdoan.collection;

public class Presentation {
	
	public static void main(String[] args) {		
		ArrayListImplementation();
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
