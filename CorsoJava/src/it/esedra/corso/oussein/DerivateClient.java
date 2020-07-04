package it.esedra.corso.oussein;

public class DerivateClient {

	public static void main(String args[]) {

		Derivate derivate = new Derivate();
		derivate.setNome("Oussein");
		System.out.println(derivate.getNome());

		derivate.setSalary(5300);
		System.out.println(derivate.getSalary());

		derivate.setCAP(51031);
		System.out.println(derivate.getCAP());

	}
}
