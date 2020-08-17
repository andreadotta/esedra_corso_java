package it.esedra.corso.marco;

import it.esedra.corso.helpers.PrintHelper;

public class UserCollectionTest {

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
		username2.setUserName("Mario Bianchi");
		username3.setUserName("Gennaro Verdi");
		username4.setUserName("Cinzia Neri");
		username5.setUserName("Gianna Panna");

		userCollection.add(username1);
		userCollection.add(username2);
		userCollection.add(username3);
		userCollection.add(username4);
		userCollection.add(username5);

		userCollection.test();

	}

}
