package com.myOwnCollection;

public class Main {

	public static void main(String[] args) {
//		LinkedList<Integer> tempList = new LinkedList<Integer>();  
//		tempList.addFirst(6);
//		tempList.addFirst(7);
//		tempList.addFirst(9);
//		tempList.addLast(8);
//		tempList.print();
		
		
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		tempList.insert(6); 
		tempList.insert(7);
		tempList.insert(8);
		tempList.insert(9);
		tempList.print();
		
		System.out.println(tempList.indexOf(9));
		tempList.print();
	}
}
