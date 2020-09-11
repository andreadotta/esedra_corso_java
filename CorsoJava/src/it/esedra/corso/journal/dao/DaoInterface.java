package it.esedra.corso.journal.dao;

import java.sql.Connection;

import it.esedra.corso.collections.interfaces.Collection;

/**
 * Questa è una semplice implementazione del DAO Pattern in Java
 * @author bauhausk
 *
 * @param <T>
 */
public interface DaoInterface<T> {
	
	/**
	 * Imposta una connessione
	 * @param con
	 */
	void setConnection(Connection con);
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
    Collection<T> getAll();
    
    /**
	 * Restituisce tutti i record della tabella
	 * @return T
	 */
    T get(T id);
    
}
