package it.esedra.corso.journal.collections;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.User;

public class UserIteratorTest {

	public UserIteratorTest() {

	}
	

	public static void main(String[] args) {


		Collection<User> userCollection = new UserCollection();

		User username1 = new User();
		User username2 = new User();
		User username3 = new User();
		User username4 = new User();
		User username5 = new User();

		username1.setName("Mario Rossi");
		username2.setName("Mario Bianchi");
		username3.setName("Gennaro Verdi");
		username4.setName("Cinzia Neri");
		username5.setName("Gianna Panna");

		userCollection.add(username1);
		userCollection.add(username2);
		userCollection.add(username3);
		userCollection.add(username4);
		userCollection.add(username5);
		
		Iterator<User> iterator = userCollection.createIterator();

		while (iterator.hasNext()) {
			PrintHelper.out(iterator.next() + "");
			PrintHelper.out(iterator.currentItem() + "");
			PrintHelper.out(iterator.isDone() + "");
		}

	}

}
