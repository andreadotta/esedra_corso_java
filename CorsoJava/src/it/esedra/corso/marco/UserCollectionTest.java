package it.esedra.corso.marco;

import it.esedra.corso.collections.Collection;
import it.esedra.corso.journal.User;

public class UserCollectionTest extends User {

	public UserCollectionTest() {

	}

	public static void main(String[] args) {

		Collection<User> userCollection = new UserCollection();

		User username1 = new User();
		User username2 = new User();
		User username3 = new User();
		User username4 = new User();
		User username5 = new User();

		username1.setUserName("Mario Rossi");
		username1.setUserName("Mario Bianchi");
		username1.setUserName("Gennaro Verdi");
		username1.setUserName("Cinzia Neri");
		username1.setUserName("Gianna Panna");

		userCollection.add(username1);
		userCollection.add(username2);
		userCollection.add(username3);
		userCollection.add(username4);
		userCollection.add(username5);

		userCollection.test();

	}

}
