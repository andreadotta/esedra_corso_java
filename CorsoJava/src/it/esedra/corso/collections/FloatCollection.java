package it.esedra.corso.collections;

import java.util.Arrays;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.helpers.PrintHelper;



public class FloatCollection implements Collection<Float> {

	private final int DEFAULT_SIZE = 10;
	
	private Float[] array;
		
	public FloatCollection() {
		array = new Float[DEFAULT_SIZE];
	}

	@Override
	public Iterator<Float> createIterator() {
		return new FloatIterator(array);
	}

	@Override
	public void add(Float item) {
	
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
