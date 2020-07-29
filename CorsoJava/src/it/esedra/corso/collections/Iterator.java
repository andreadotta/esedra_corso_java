package it.esedra.corso.collections;

public interface Iterator<T> {
	/**
	 * Restituirà il prossimo elemento
	 * @return
	 */
	T next();
	/**
	 * Restituirà l'elemento corrente
	 * @return
	 */
	T currentItem();
	
	/**
	 * Restituisce true se ha ancora un elemento
	 * @return
	 */
	boolean hasNext();
	/**
	 * Se è giunto al termine
	 * @return
	 */
	boolean isDone();
	


}
