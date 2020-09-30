package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Collection;

public class StringCollectionTest {

	public StringCollectionTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Collection<String> StringCollention = new StringCollection();

		StringCollention.add((String) "Ciao");
		StringCollention.add((String) "Oggi");
		StringCollention.add((String) "Domani");
		StringCollention.add((String) "Ieri");
		StringCollention.add((String) "Corso");
		StringCollention.add((String) "Scuola");
		StringCollention.add((String) "Java");
		StringCollention.add((String) "Iteratore");
		StringCollention.add((String) "Gianni");
		StringCollention.add((String) "Collection");
		StringCollention.add((String) "Computer");

		StringCollention.test();

	}

}
