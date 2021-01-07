package com.myOwnCollection;

public class ArrayList<T> {

	private int length;
	private int count;
	private static final int DEFAULT_LENGHT = 10;
	private Object[] arr;


	public int getCount() {
		return count;
	}

	public int getLength() {
		return length;
	}

	public Object[] getArr() {
		return arr;
	}

	public ArrayList() {		
		this.count = 0;
		this.arr = new Object[ArrayList.DEFAULT_LENGHT];
	}
	
	public ArrayList(int length) {
		this.length = length;
		this.count = 0;
		this.arr = new Object[this.length];
	}
	
	public int indexOf(T value) {
		for (int i = 0; i < this.arr.length; i++) {
			if((T) this.arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	public void insert(T value) {
		if(this.count < this.length) {
			this.arr[count++] = value;
		}
		else {
			
			this.length = this.length*2;
			Object[] tempArr = this.arr.clone();
			this.arr = new Object[this.length];
			
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
	
	public T getAt(int index) {		
		return index<=this.count ? (T) this.arr[index] : null;
	}
	
	public void print() {
		System.out.println("The lenght of this array is : " + this.length);
		System.out.println("This array has " + this.count + " element has non-empty value");
		for (int i = 0; i < this.count; i++) {
			System.out.print((T) this.arr[i] + " ");
		}
		System.out.println();
	}
}
