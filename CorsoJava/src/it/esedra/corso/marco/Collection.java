package it.esedra.corso.marco;

import it.esedra.corso.collections.Iterator;

public interface Collection<T> {

	Iterator<T> createIterator();
	/**
	 * Aggiunge un elemento
	 * @param item
	 */
	void add(T item);
	
	/**
	 * Fa System.out del contenuto della collection
	 */
	void test();
}
