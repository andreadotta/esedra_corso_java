package it.esedra.corso.oussein.Derivate;

/**
 * Questa classe permette di settare i valori delle componenti di Base, e
 * ritorna a schermo la configurazione scelta
 * 
 * @author pc
 *
 */
public class DerivateClient {

	public static void main(String args[]) {

		Derivate derivate = new Derivate("oussein", 5300);
		derivate.setNome("Oussein");
		System.out.println(derivate.getNome());

		derivate.setSalary(5300);
		System.out.println(derivate.getSalary());

		derivate.setCAP(51031);
		System.out.println(derivate.getCAP());

	}
}
