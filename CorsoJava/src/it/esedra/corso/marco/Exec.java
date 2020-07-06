package it.esedra.corso.marco;

public class Exec {

	public static void main(String[] args) {

		Anagrafica anagrafica = new Anagrafica();

		anagrafica.setNome("Marco");
		anagrafica.setSecondoNome("Gargamella");
		anagrafica.setCognome("Simi");
		anagrafica.setGenere("maschio");
		anagrafica.setEta("37 anni");
		anagrafica.setIndirizzo("via del Tufo 1");
		anagrafica.setCap("58100");
		anagrafica.setCodiceFiscale("SMIMRC82P29E202W");
		anagrafica.setProfessione("Programmatore");

		System.out.println(anagrafica.getAnagraficaExtended());
		System.out.println(anagrafica.getIndirizzo());
		System.out.println(anagrafica.getProfessione());

	}

}