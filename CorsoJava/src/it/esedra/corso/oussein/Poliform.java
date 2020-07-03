package it.esedra.corso.oussein;

public class Poliform extends Ereditaria {
	int salary;

	public Poliform(String nm, int s) {
		super(nm);
		this.salary = s;

	}

	public static void main(String[] args) {
		Poliform insegnante = new Poliform("Andrea", 5300);
		System.out.println("poliform e:" + insegnante.nome);
		System.out.println("poliform e:" + insegnante.salary + "euros");

	}

}
