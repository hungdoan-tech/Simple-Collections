package com.hungdoan.collection;

public class ArrayList<T> implements List<T> {
	
	private final int SCALE_CONSTANT = 2;
	
	private final int DEFAULT_LENGTH = 10;
	
	private Object[] array;
	
	private int lenght;
	
	private int currentIndex;

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public Object[] getArray() {
		return array;
	}

	public void setArray(Object[] array) {
		this.array = array;
	}
	
	public int getCurrentIndex() {
		return currentIndex;
	}

	public ArrayList() {
		this.currentIndex = 0;
		this.lenght = this.DEFAULT_LENGTH;
		this.array = new Object[this.lenght];
	}
	
	public ArrayList(int length) {		
		this.currentIndex = 0;
		this.lenght = length;
		this.array = new Object[this.lenght];
	}
	
	public ArrayList(Object[] inArray) {
		
		this.setArray(inArray);
		this.currentIndex = inArray.length; 
		this.setLenght((int) (inArray.length * this.SCALE_CONSTANT));
	}
	
	public boolean insert(T inValue) {
		if(this.currentIndex == this.lenght) {
			Object[]  tempArr = this.array;
			this.lenght = (int) (this.lenght * this.SCALE_CONSTANT);
			this.array = new Object[this.lenght];
			this.scaleUpMainArray(tempArr);
		}
		this.array[currentIndex++] = inValue; 
		return true;
	}
	
	public boolean removeAt(int index) {
		if(index >= this.lenght || index < 0) {
			return false;
		}
		this.switchElementPositionToLeft(index);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public T getAt(int index) {
		if(index >= this.lenght || index < 0) {
			return null;
		}
		return (T) (this.array[index]);
	}
	
	private Object[] switchElementPositionToLeft(int startIndex) {		 
		for(int i=startIndex; i < lenght - 1; i++) {
			this.array[i] = this.array[i+1];
		}
		this.currentIndex--;
		return this.array;
	}
	
	private Object[] scaleUpMainArray(Object[] oldArray) {
		int i = 0;
		for(Object item : oldArray) {
			this.array[i] = item;
			i++;
		}
		return this.array;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("[");
		for(int i =0; i < this.currentIndex; i++) {
			stringBuilder.append((T) (this.array[i]));
			stringBuilder.append(",");
		}				
		stringBuilder.deleteCharAt(stringBuilder.length()-1);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contain(T inValue) {
		for(Object item : this.array) {
			T value = (T)(item);
			if(value.equals(inValue)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (this.currentIndex == 0) ? true : false;
	}

	@SuppressWarnings("unused")
	@Override
	public void clear() {
		for(Object item : this.array) {
			item = null;
		}
		this.currentIndex = 0;
		this.lenght = this.DEFAULT_LENGTH;
		this.array = new Object[this.lenght];
	}

	@Override
	public int size() {	
		return this.lenght;
	}
	
	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new ArrayListIterator<T>(this);
 		return iterator;
	}
}
