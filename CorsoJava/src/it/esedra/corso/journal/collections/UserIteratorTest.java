package it.esedra.corso.journal.collections;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.gianni.PrintHelper;
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

		username1.setUserName("Mario Rossi");
		username2.setUserName("Mario Bianchi");
		username3.setUserName("Gennaro Verdi");
		username4.setUserName("Cinzia Neri");
		username5.setUserName("Gianna Panna");

		Iterator<User> iterator = userCollection.createIterator();

		while (iterator.hasNext()) {
			PrintHelper.out(iterator.next() + "");
			PrintHelper.out(iterator.currentItem() + "");
			PrintHelper.out(iterator.isDone() + "");
		}

	}

}
