package com.hungdoan.collection;

import java.util.HashMap;
import java.util.Map;

public class ArrayList<T> implements List<T> {
	
	private final int SCALE_CONSTANT = 2;
	
	private final int DEFAULT_LENGTH = 10;
	
	private Object[] array;
	
	private int length;
	
	private int currentIndex;

	public int getLenght() {
		return length;
	}

	public void setLenght(int lenght) {
		this.length = lenght;
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
		this.length = this.DEFAULT_LENGTH;
		this.array = new Object[this.length];
	}
	
	public ArrayList(int length) {		
		this.currentIndex = 0;
		this.length = length;
		this.array = new Object[this.length];
	}
	
	public ArrayList(Object[] inArray) {
		
		this.setArray(inArray);
		this.currentIndex = inArray.length; 
		this.setLenght((int) (inArray.length * this.SCALE_CONSTANT));
	}
	
	public ArrayList(List<T> inList) {
		
		this.currentIndex = 0;
		this.length = inList.size();
		this.array = new Object[this.length];
		
		Iterator<T> iterator = inList.iterator();
		while(iterator.hasNext()) {
			this.insert(iterator.next());
			this.currentIndex++;
		}
	}
	
	public boolean insert(T inValue) {
		if(this.currentIndex == this.length) {
			Object[]  tempArr = this.array;
			this.length = (int) (this.length * this.SCALE_CONSTANT);
			this.array = new Object[this.length];
			this.scaleUpMainArray(tempArr);
		}
		this.array[currentIndex++] = inValue; 
		return true;
	}
	
	public boolean removeAt(int index) {
		if(index >= this.length || index < 0) {
			return false;
		}
		this.switchElementPositionToLeft(index);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public T getAt(int index) {
		if(index >= this.length || index < 0) {
			return null;
		}
		return (T) (this.array[index]);
	}
	
	private Object[] switchElementPositionToLeft(int startIndex) {		 
		for(int i=startIndex; i < this.currentIndex - 1; i++) {
			this.array[i] = this.array[i+1];
		}
		this.currentIndex--;
		return this.array;
	}
	
	private Object[] switchElementPositionToRight(int startIndex) {		 
		for(int i=this.currentIndex; i > startIndex; i--) {
			this.array[i] = this.array[i-1];
		}		
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
		this.length = this.DEFAULT_LENGTH;
		this.array = new Object[this.length];
	}

	@Override
	public int size() {	
		return this.length;
	}
	
	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new ArrayListIterator<T>(this);
 		return iterator;
	}

	public T max() {
		
//		we need our each element must be implement Comparable interface 
		
//		T max = (T) this.array[0];
//		for(Object item: this.array) {
//			if(max > item) {
//				
//			}
//		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> intersect(ArrayList<T> opponent) {
		
		Map<Object, Integer> intercectMap = new HashMap<Object, Integer>();
		int firstLength = this.getCurrentIndex();
		int secondLength = opponent.getCurrentIndex();
		int finalLength = (firstLength >= secondLength) ? firstLength : secondLength; 
		
		for(int i=0; i < finalLength; i++) {
			Object mainItem = this.getAt(i);
			Object opponentItem = opponent.getAt(i);
			
			if(intercectMap.containsKey(mainItem)) {
				Integer currentValue = intercectMap.get(mainItem); 
				intercectMap.put(mainItem, currentValue + 1);
			} else {
				intercectMap.put(mainItem, 1);
			}
			
			if(intercectMap.containsKey(opponentItem)) {
				Integer currentValue = intercectMap.get(opponentItem); 
				intercectMap.put(opponentItem, currentValue + 1);
			} else {
				intercectMap.put(opponentItem, 1);
			}
		}
		
		ArrayList<T> output = new ArrayList<T>();
		for(var item : intercectMap.entrySet()) {			
				if(item.getValue() > 1) {
					output.insert((T) item.getKey());
				}			
		}
		return output;
	}

	@Override
	public void reverse() {
		Object[] reverseArray = new Object[this.size()];
		int reverseIndex = 0;
		for(int i = this.getCurrentIndex() - 1; i >= 0; i--) {
			Object item = this.array[i]; 
			reverseArray[reverseIndex++] = item;
		}
		this.array = reverseArray;
	}

	@Override
	public boolean insertAt(T value, int index) {
		if(index >= this.size() || index < 0) {
			return false;
		}
		if(this.getCurrentIndex() == this.size()) {
			this.insert(null);
		}
		switchElementPositionToRight(index);
		this.array[index] = value;
		return true;
	}

	@Override
	public int indexOf(T value) {
		// TODO Auto-generated method stub
		return 0;
	}
}
