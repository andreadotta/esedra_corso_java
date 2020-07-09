package it.esedra.corso.oussein;

import it.esedra.corso.helpers.PrintHelper;

public class Song {
	public static void main(String[] args) {
		Canzone mysong = new Canzone("holiday", "Green day", 300);
       
		PrintHelper.out(mysong.getTitoli() + " " + mysong.getArtist() + " " + mysong.getLength());
		
	}

}
