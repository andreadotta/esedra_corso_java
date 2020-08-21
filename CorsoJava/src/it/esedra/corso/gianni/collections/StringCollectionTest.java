package it.esedra.corso.gianni.collections;

import java.util.Arrays;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.collections.Collection;
import it.esedra.corso.collections.FloatCollention;
import it.esedra.corso.collections.Iterator;

public class StringCollectionTest {

	public StringCollectionTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		Collection<String> StringCollention = new StringCollection();
		
		StringCollention.add("Ciao");
		StringCollention.add("Oggi");
		StringCollention.add("Domani");
		StringCollention.add("Ieri");
		StringCollention.add("Corso");
		StringCollention.add("Scuola");
		StringCollention.add("Java");
		StringCollention.add("Iteratore");
		StringCollention.add("Gianni");
		StringCollention.add("Collection");
		StringCollention.add("Computer");
		
		StringCollention.test();
		
		
	}

}
