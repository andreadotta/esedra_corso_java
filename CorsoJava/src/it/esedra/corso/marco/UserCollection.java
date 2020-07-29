package it.esedra.corso.marco;

import java.util.Arrays;

import it.esedra.corso.collections.Collection;
import it.esedra.corso.collections.Iterator;
import it.esedra.corso.helpers.PrintHelper;

import it.esedra.corso.journal.User;

public class UserCollection implements Collection<User> {

	private final int DEFAULT_SIZE = 5;

	private User[] array;

	public UserCollection() {
		array = new User[DEFAULT_SIZE];
	}

	@Override
	public Iterator<User> createIterator() {
		return new UserIterator(array);
	}

	@Override
	public void add(User item) {

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
			array[array.length - 1] = item;
		}

	}

	@Override
	public void test() {

		for (int i = 0; i < array.length; i++) {
			PrintHelper.out(array[i] + "");
		}

	}

}
