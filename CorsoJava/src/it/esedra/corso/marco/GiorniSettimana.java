package it.esedra.corso.marco;

import java.util.Scanner;

public class GiorniSettimana {

	public static void main(String[] args) {
		
		Scanner tastiera = new Scanner(System.in);
		
		System.out.print("Inserisci un numero corrispondente al giorno della settimana [1-7]: ");
		int giorno = tastiera.nextInt();
		
		switch (giorno) {
		
		case 1: System.out.print("Il giorno selezionato è LUNEDI'");
		break;
		case 2: System.out.print("Il giorno selezionato è MARTEDI'");
		break;
		case 3: System.out.print("Il giorno selezionato è MERCOLEDI'");
		break;
		case 4: System.out.print("Il giorno selezionato è GIOVEDI'");
		break;
		case 5: System.out.print("Il giorno selezionato è VENERDI'");
		break;
		case 6: System.out.print("Il giorno selezionato è SABATO");
		break;
		case 7: System.out.print("Il giorno selezionato è DOMENICA");
		break;
		default: System.out.print("Il numero inserito è errato.");
		
		}
		
		switch (giorno) {
		
		case 1: case 2: case 3: case 4: case 5: 
			System.out.println(" ...ed è un giorno lavorativo.");
		break;
		case 6:
			System.out.println(" ...ed è un giorno prefestivo");
		break;
		case 7:
			System.out.println(" ...ed è un giorno festivo");
		break;
		default:
			System.out.println("Il numero inserito è errato.");
						
		}
		
		tastiera.close();
		
	}
	
}
