package it.esedra.corso.collections;

import java.util.Arrays;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.helpers.PrintHelper;



public class GenericCollection<T> implements Collection<T> {


	private final int DEFAULT_SIZE = 10;
	
	private T[] array;
		
	public GenericCollection() {
		array = (T[]) new Object[DEFAULT_SIZE];
	}

	@Override
	public Iterator<T> createIterator() {
		return null;
//		return new Iterator(array);
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
	
	public void test() {
		for (int i = 0; i < array.length; i++) {
				PrintHelper.out(array[i] + "");
		}
	}

	

}
