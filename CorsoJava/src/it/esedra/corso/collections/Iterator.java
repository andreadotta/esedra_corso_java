package it.esedra.corso.collections;

public class Iterator<T> implements it.esedra.corso.collections.interfaces.Iterator<T> {

	public Iterator() {

	}

	private T[] array;
	private int current = -1;
	private boolean isDone = false;

	public Iterator(T[] array) {
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
