package it.esedra.corso;

public class Snippet1607 {

	public Snippet1607() {
			
		C<Integer> c = new C<>(); //C<Integer> è un parametrized type	
								  // Integer è un type argument

		c.setC(1);
		
		
		
		C<String> f = new C<>();
		
		f.setC("ciao");

		
	}

}


