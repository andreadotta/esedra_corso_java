package it.esedra.corso.oussein;

/**(la classe Derivate è la classe derivata dalla superclasse Base)*/

public class Derivate extends Base {

	private int CAP;

	public int getCAP() {
		return CAP;
	}

	public void setCAP(int cAP) {
		CAP = cAP;
	}
	

	public  void print() {
		System.out.println(  CAP ) ;
		
	} 
}