package it.esedra.corso.marco;

public class UserIterator implements Iterator<User> {

	private User[] array;
	private int current = -1;
	private boolean isDone = false;

	public UserIterator(User[] inputArray) {
		array = inputArray;
	}

	@Override
	public User next() {
		return null;
	}

	@Override
	public User currentItem() {
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
