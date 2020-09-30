package it.esedra.corso.journal;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;



/**
 * Classe base dell'applicazione
 * 
 * @journal bauhausk
 *
 */
public class Journal {
	
	private final int id;
	private final String name;

	public Journal(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	

	}
   public int getId() {
	   return  id ;
   }

	public String getName() {
		return name;
	}

	
		
	
	
}
