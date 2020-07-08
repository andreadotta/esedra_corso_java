package it.esedra.corso.oussein;

/** (la classe Derivate è la classe derivata dalla superclasse Base) */

public  class Derivate extends Base {
	public Derivate(String nome, int salary) {
		super(nome, salary);

	}

	public final String insegnante = "oussein";

	private int CAP;

	public int getCAP() {
		return CAP;
	}

	public void setCAP(int cAP) {
		CAP = cAP;
	}

	public void print() {
		System.out.println(CAP);

	}

	@Override
	public String getInsegnante() {
		return insegnante;
	}
}