package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Iterator;

public class IntegerIterator implements Iterator<Integer> {

	private Integer[] array;
	private int current = -1;
	private boolean isDone = false;

	public IntegerIterator(Integer[] inputArray) {
		array = inputArray;
	}

	@Override
	public Integer next() {
		current++;
		return array[current];

	}

	@Override
	public Integer currentItem() {
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
