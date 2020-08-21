
public class Cellulare {
	
	private double carica ;
	private int numeroChiamate;
	public int getNumeroChiamate() {
		return numeroChiamate;
	}
	public void setNumeroChiamate(int numeroChiamate) {
		this.numeroChiamate = numeroChiamate;
	}
	public double getCarica() {
		return carica;
	}
	public void setCarica(double carica) {
		this.carica = carica;
	}
	
	public Cellulare(double carica) {
		super();
		this.carica = carica;
	}

}
