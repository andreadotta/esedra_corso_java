package it.esedra.corso.nayem.collection;

public class DoubleIterator implements Iterator<Double> {

	private Double[] array;
	private int current = -1;
	private boolean isDone = false;

	public DoubleIterator(Double[] inputArray) {
		array = inputArray;
	}

	@Override
	public Double next() {
		current++;
		return array[current];
	}

	@Override
	public Double currentItem() {
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
