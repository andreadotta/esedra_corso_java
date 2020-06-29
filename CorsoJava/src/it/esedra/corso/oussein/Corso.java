package it.esedra.corso.oussein;

public class Corso {

	public Corso() {
		
	}

	public static void main(String[] args) {
		String nome = "ousseynou";
		System.out.println("il mio nome e " + nome);

		String congnome = "Mbengue";
		System.out.println("il mio congnome e " + congnome);
	
         String cittadinascita = "Agliana";
		System.out.println("la mia Citta di Nascita e " + cittadinascita);

		int eta = 20;

		double altezza = 1.98;
		System.out.println("la mia Altezza e " + altezza);

		String genere = "Maschio";
        
		if (eta > 18) {
			System.out.println("sei maggiorenne");
		} else {
			System.out.println("sei minorenne");
		}

		switch (genere) {
		case ("Maschio"):
			System.out.println("l utente e Maschio");
			break;
		case ("femmina"):

			System.out.println("l utente e femmina");
		}
	}





	}


