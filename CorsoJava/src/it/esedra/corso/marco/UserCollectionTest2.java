package it.esedra.corso.marco;

import java.util.ArrayList;

import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.User;

public class UserCollectionTest2 extends User {

	public static void main(String[] args) {
		
		ArrayList<User> userCollection = new ArrayList<User>();
		
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
		
		for ( int i = 0; i < userCollection.size(); i++) {
			System.out.println(userCollection);
		}

	}

}
