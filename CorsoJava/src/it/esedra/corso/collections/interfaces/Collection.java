package it.esedra.corso.collections.interfaces;

public interface Collection<T> {

	/**
	 * Crea un iteratore
	 * @return
	 */
	Iterator<T> createIterator();
	/**
	 * Aggiunge un elemento
	 * @param item
	 */
	void add(T item);
	
	/**
	 * Fa System out del contenuto della collention
	 */
	void test();
	
	/**
	 * Restituisce la array
	 */
	T[] toArray();
}
