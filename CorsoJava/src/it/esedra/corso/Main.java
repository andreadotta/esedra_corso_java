package it.esedra.corso;
class Main {

/*
	programma RICERCA1 (INSIEME, DATO) 

	// ricerca di un elemento DATO in un insieme INSIEME 
	// n indica il numero di elementi di INSIEME 
	
	i <- 0; // "<-" è una freccia cioè una assegnazione di valore  

		while  i <= n – 1 
			if INSIEME[i] = DATO 
				print DATO "è presente"; 
				stop; 
		    else i <- i + 1; 
		
		print DATO "non è presente" 

 */
	
	  public static void main(String[] args) {
	  
		  String[] INSIEME = {"FI", "MI", "PA", "NA", "BO", "TO", "VE", "CA" };
		  String DATO = "PA";
		  
		  RICERCA1(INSIEME, DATO);
	  }

	  static void RICERCA1(String[] INSIEME, String DATO){

		  int i = 0;
		  int n = INSIEME.length;
		  
		  while (i <= n -1) {
			  if (INSIEME[i] == DATO) {
				  System.out.println(DATO + " è presente");  
				  return;
			  } else {
				  i = i + 1;
			  }
			  //
		  }
		  System.out.println(DATO + " non è presente");  
	  }

}
