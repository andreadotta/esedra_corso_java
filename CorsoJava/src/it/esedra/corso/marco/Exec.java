package it.esedra.corso.marco;

public class Exec {

	public static void main(String[] args) {
		
		Anagrafica anagrafica = new Anagrafica();
		anagrafica.setNome("Marco");
		anagrafica.setCognome("Simi");
		anagrafica.setEta("37 anni");
		anagrafica.setIndirizzo("via del Tufo 1, Grosseto(GR)");
		
		System.out.println(anagrafica.getAnagrafica());

	}

}