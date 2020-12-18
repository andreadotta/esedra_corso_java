package it.esedra.corso;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.esedra.corso.helpers.PrintHelper;

public class EsempiCollection {
	
	public static void main (String[] args) {
		
		Set<String> setTest = new TreeSet<String>();
		setTest.add("Gianni");
		setTest.add("Oussein");
		setTest.add("Oussein");
		setTest.add("Ciao");
		
		Iterator<String> itSet = setTest.iterator();
		while (itSet.hasNext()) {
			PrintHelper.out(itSet.next());
		}
		
		for(String nome:setTest) {
			PrintHelper.out(nome);
		}
		
		SortedSet<String> sortedTest = new TreeSet<String>(new EsempioComparator());
		sortedTest.add("Milano");
		sortedTest.add("Napoli");
		sortedTest.add("Palermo");
		sortedTest.add("Ancona");
		
		PrintHelper.out(sortedTest.first());
		
		for(String nome:sortedTest) {
			PrintHelper.out(nome);
		}
	
	}
	
	

}
