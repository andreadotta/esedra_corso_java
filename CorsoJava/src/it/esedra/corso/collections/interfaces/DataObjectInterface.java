package it.esedra.corso.collections.interfaces;

import javax.json.JsonObject;

public interface DataObjectInterface {

	
	/**
	 * Trasforma l'oggetto in una stringa json
	 * @return
	 */
	JsonObject toJson();	
	
}
