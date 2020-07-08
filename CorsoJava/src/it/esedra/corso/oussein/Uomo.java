package it.esedra.corso.oussein;

public class Uomo extends EssereHuman {

	public Uomo(String nome, String congnome, int age) {
		super(nome, congnome, age);
		
	}
public void print() {
	System.out.println("sono un uomo");
	System.out.println(this.getNome()+" " + this.getCongnome()+" " + this.getAge() );
	
}
}
