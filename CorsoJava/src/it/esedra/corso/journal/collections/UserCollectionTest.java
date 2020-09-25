package it.esedra.corso.journal.collections;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.journal.User;
import it.esedra.corso.journal.UserBuilder;

public class UserCollectionTest {

	public UserCollectionTest() {

	}

	public static void main(String[] args) {

		Collection<User> userCollection = new UserCollection();

		User username1 = new UserBuilder().setName("Mario").setSurname("Rossi").setEmail("");
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

		userCollection.test();

	}

}
