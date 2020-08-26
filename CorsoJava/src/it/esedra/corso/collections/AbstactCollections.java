package it.esedra.corso.collections;

import java.util.Arrays;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;

public abstract class AbstactCollections<T> implements Collection<T> {

	public final static int DEFAULT_SIZE = 10;
	
	public AbstactCollections() {

	}
	
	public AbstactCollections(T[] array) {
		this.array = array;
	}
	
	private T[] array;
	

	@Override
	public Iterator<T> createIterator() {
		return null;
	}

	@Override
	public void add(T item) {
	
		boolean flag = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				array[i] = item;
				flag = true;
				break;
			}
		}
		if (flag == false) {
			array = Arrays.copyOf(array, array.length + 1);
			array[array.length -1] = item;
		}
		
	}

	@Override
	public void test() {

		
	}
	
	@Override
	public T[] toArray() {
		return this.array;
		
	}

}
