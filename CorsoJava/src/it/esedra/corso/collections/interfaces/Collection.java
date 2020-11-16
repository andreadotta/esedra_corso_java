package it.esedra.corso.collections.interfaces;

import javax.json.JsonArray;
public interface Collection<T> {

	/**
	 * Crea un iteratore
	 * 
	 * @return
	 */
	Iterator<T> createIterator();

	/**
	 * Aggiunge un elemento
	 * 
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
	
	/**
	 * Restituisce il json dell'intera array
	 */
	JsonArray toJson();

}
