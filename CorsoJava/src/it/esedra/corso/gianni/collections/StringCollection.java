package it.esedra.corso.gianni.collections;

import java.util.Arrays;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.collections.Collection;
import it.esedra.corso.collections.Iterator;

public class StringCollection implements Collection<String> {

	private final int DEFAULT_SIZE = 10;
	
	private String[] array;
		
	public StringCollection() {
		array = new String[DEFAULT_SIZE];
	}

	@Override
	public Iterator<String> createIterator() {
		return new StringIterator(array);
	}

	@Override
	public void add(String item) {
	
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
