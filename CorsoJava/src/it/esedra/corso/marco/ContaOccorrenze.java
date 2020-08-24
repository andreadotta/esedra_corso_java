package it.esedra.corso.marco;

import java.util.StringTokenizer;

public class ContaOccorrenze {

	// Costruttore della classe
	public ContaOccorrenze() {

	}

	// variabili di classe che verranno usate dal metodo contaOccorrenze
	public String text;
	public String word;

	// Getters e Setters
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	// Questo è il metodo che utilizza lo StringTokenizer per poi contare le
	// occorrenze della variabile word
	public String contaOccorrenze(String text, String word) {

		int contatoreParola = 0;

		StringTokenizer st = new StringTokenizer(text, ". , : ;");

		while (st.hasMoreTokens()) {
			text = st.nextToken();
			if (text.equals(word)) {
				contatoreParola++;
			}

		}

		return "Numero occorrenze: " + contatoreParola;

	}

}
