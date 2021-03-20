package com.hungdoan.collection;

public class Presentation {
	
	public static void main(String[] args) {		
		ArrayListImplementation();
	}

	private static void ArrayListImplementation() {
		List<Integer> arrList = new ArrayList<Integer>(3);
		arrList.insert(3);
		arrList.insert(4);
		arrList.insert(9);
		arrList.insert(20);

		Iterator<Integer> iterator = arrList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
