package it.esedra.corso.gianni.collections;

import java.util.Arrays;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.collections.Collection;
import it.esedra.corso.collections.Iterator;

public class StringIterator implements Iterator<String> {

	private String[] array;
	private int current = -1;
	private boolean isDone = false;
	/**
	 * Accetta in inpout una array di float
	 * @param array
	 */
	public StringIterator(String[] inputArray) {
		array = inputArray;
	}

	@Override
	public String next() {
		current++;
		return array[current];
	}

	@Override
	public String currentItem() {
		return array[current];
	}

	@Override
	public boolean hasNext() {
		int size = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				size++;
			} else {
				break;
			}
		}
		return (current + 1) < size;
	}

	@Override
	public boolean isDone() {
		int size = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				size++;
			} else {
				break;
			}
		}
		isDone = !((current + 1) < size);
		return isDone;
	}
}
