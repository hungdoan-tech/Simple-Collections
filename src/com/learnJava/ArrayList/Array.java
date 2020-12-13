package com.learnJava.ArrayList;

public class Array {

	private int length;
	private int count;
	private int[] arr;


	public int getCount() {
		return count;
	}

	public int getLength() {
		return length;
	}

	public int[] getArr() {
		return arr;
	}

	public Array(int length) {
		super();
		this.length = length;
		this.count = 0;
		this.arr = new int[this.length];
	}
	
	public int indexOf(int value) {
		for (int i = 0; i < this.arr.length; i++) {
			if(this.arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	public void insert(int value) {
		if(this.count < this.length) {
			this.arr[count++] = value;
		}
		else {
			
			this.length = this.length*2;
			int[] tempArr = this.arr.clone();
			this.arr = new int[this.length];
			
			for(int i=0;i<this.count;i++) {
				this.arr[i] = tempArr[i];
			}					
			this.insert(value);
		}
	}
	
	public void removeAt(int position) {
		if(position <= this.length && position > -1) {
			for(int i=position; i < this.length - 1; i++) {
				this.arr[i] = this.arr[i+1];
			}
			this.count--;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	
	public void print() {
		System.out.println("The lenght of this array is : " + this.length);
		System.out.println("This array has " + this.count + " element has non-empty value");
		for (int i = 0; i < this.count; i++) {
			System.out.print(this.arr[i] + " ");
		}
		System.out.println();
	}
}
