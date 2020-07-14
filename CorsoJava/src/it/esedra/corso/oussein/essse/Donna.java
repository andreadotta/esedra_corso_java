package it.esedra.corso.oussein.essse;

public class Donna extends EssereHuman {

	public Donna(String nome, String congnome, int age) {
		super(nome, congnome, age);
		
	}
	public void print() {
		System.out.println("sono un donna");
		System.out.println(this.getNome()+" " + this.getCongnome()+" " + this.getAge() );
		
	}
}
