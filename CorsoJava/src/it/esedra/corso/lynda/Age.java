package it.esedra.corso.lynda;

public class Age {
	
	private static int numero21;

	public static void main(String[] args) {
	
		  int numero1 = 40 ;
	      NumeroIntero numero = new NumeroIntero (); //instance
		numero.numeroIntero = 40; //object ("forty"); becomes a local variable
		numero.stampaNumero();
		
		
		NumeroIntero numero21 = new NumeroIntero (); 
		NumeroIntero.numero = 60; //object becomes a local variable
		numero21.stampaNumero();
		
		
		
		/*** Questa classe definisce il concetto di numero intero come oggetto. In essa
		*vengono dichiarati una variabile (ovviamente) intera ed un metodo che stamperà la variabile stessa.
		*Scrivere, compilare ed eseguire una classe che:
		*- istanzierà almeno due oggetti dalla classe NumeroIntero (contenente ovviamente un metodo main()), 
		*- cambierà il valore delle relative variabili 
         **/
	}
	}


