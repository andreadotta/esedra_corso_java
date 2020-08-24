package it.esedra.corso.marco;

public class ContaOccorrenzeTest {

	public static void main(String[] args) {

		// Dichiaro le variabili di tipo ContaOccorrenze che verranno assegnate come
		// parametri al metodo contaOccorrenze
		ContaOccorrenze testo = new ContaOccorrenze();
		ContaOccorrenze parola = new ContaOccorrenze();

		testo.setText("mare, mare, mare, terra, lago, lago, montagna, mare, terra.");
		parola.setWord("mare");
		testo.getText();
		parola.getWord();

		// Chiamo il metodo contaOccorrenze sulle variabili dichiarate
		testo.contaOccorrenze(testo.getText(), parola.getWord());

		// Stampo a schermo il risultato del metodo contaOccorrenze
		System.out.println(testo.contaOccorrenze(testo.getText(), parola.getWord()));

	}

}
