package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Iterator;

public class AbstractIterator<T>  implements Iterator<T> {

	public AbstractIterator() {
		// TODO Auto-generated constructor stub
	}

	
	private T[] array;
	private int current = -1;
	private boolean isDone = false;

	public AbstractIterator(T[] array) {
		this.array = array;
	}

	@Override
	public T next() {
		current++;
		return array[current];
	}

	@Override
	public T currentItem() {
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
