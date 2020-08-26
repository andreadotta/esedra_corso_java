package it.esedra.corso.journal.collections;

import java.util.Arrays;

import it.esedra.corso.collections.Iterator;
import it.esedra.corso.collections.interfaces.Collection;
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
		return new Iterator<User>(array);
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

		for (User user : array) {
			PrintHelper.out(user.getUserName() + " " + user.getUserSurname());
			PrintHelper.out(user.getUserEmail() + "");
			PrintHelper.out(user.getDataRegistration() + "");			
		} 

	}

	@Override
	public User[] toArray() {

		return array;
	}

}
