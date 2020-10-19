package it.esedra.corso;

import it.esedra.corso.helpers.PrintHelper;

public class Snippet1910 {

	public Snippet1910() {
		// TODO Auto-generated constructor stub
		
		
		//GUIDA ECCEZIONI:
		//https://www.html.it/pag/15105/gestire-le-eccezioni/
		
		String[] arrays = new String[1];
		
		//FORMA 1
		try { //
			
		} catch (Exception e) {  //catch class type tramite pipe | possiamo indicare tipi di classe alternativi  
			//catch block
		} 
		
		//FORMA 2
		try { //
			// TRY BODY: qui eseguiamo il programma
			arrays[0] = "Roberto";
			arrays[1] = "Baldi";
			arrays[2] = "Java";			
			
		} catch (Exception e) {  //catch class type tramite pipe | possiamo indicare tipi di classe alternativi  
			//catch block
			PrintHelper.out("Errore:" +  e.getMessage());
			
		} finally {
			//finally block
			PrintHelper.out("Finally 1");
		}
		
		///FORMA 3
		//si utilizza solo se il TRY non specifica un catch allora
		// finally è obbligatorio.
		try {
			
		} finally {
			PrintHelper.out("Finally 2");
		}
		
		
	}
	
	public static void main(String[] args) {
		new Snippet1910();
	}

}
