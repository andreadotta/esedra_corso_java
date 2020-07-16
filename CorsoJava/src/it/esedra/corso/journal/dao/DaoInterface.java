package it.esedra.corso.journal.dao;

import java.util.List;

public interface DaoInterface<T> {
	
	/**
	 * Aggiorna o inserisce un record
	 */
	void update();
	/**
	 * Elimina un record
	 */
	void delete();
	/**
	 * Restituisce tutti i record della tabella
	 * @return T
	 */
    List<T> getAll();
}
