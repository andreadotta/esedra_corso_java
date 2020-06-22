package it.esedra.corso;
//package rappresenta  la dichiarazione di package.
// deve essere la prima istruzione
// indica il nome del package a cui questa classe appartiene
// se non indichiamo il package la calsse farà parte  del unnamed package


//è una dichiarazione di  importazione che consente di fare riferimento a un tipo oppure a un membro staticp.
import java.lang.*;

//importazione di tipo singolo 
import java.lang.String;

import it.esedra.corso.helpers.StringHelper;

public class Snippet2206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Snippet2206 snippet = new Snippet2206();
		
		String corsoCompleto = snippet.corso("java");
		
		System.out.println(corsoCompleto);
		
	}
	
	public String corso(String tipocorso) {
		

		String mese = "Giugno";
		
		return StringHelper.stringConcatWithSpace(tipocorso, mese);
	}

	
}
