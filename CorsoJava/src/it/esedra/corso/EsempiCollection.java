package it.esedra.corso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.esedra.corso.collections.interfaces.Collection;
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
		
		//ArrayList e LinkedList
		List<Integer> aNumbers = new ArrayList<>(10);
		List<Integer> lNumbers = new LinkedList<>();
		
		for (int i = 0; i < 10; i++) {
			aNumbers.add(i, new Random().nextInt(20));		
		}
		
		PrintHelper.out("Numeri ArrayList: " + aNumbers);
		
		for (int i = 0; i < 10; i++) {
			lNumbers.add(i, new Random().nextInt(20));
		}
		
		PrintHelper.out("Numeri LinkedList: " + lNumbers);
		
		aNumbers.removeAll(lNumbers);
		
		PrintHelper.out("Numeri dopo la rimozione: " + aNumbers);

		int number_to_put[] = {12, 44,12, 0, -1, 4, 33, -10, -9, -100};
		Queue<Integer> numbers = new PriorityQueue<>();
		for (int i = 0; i < number_to_put.length; i++) {
			numbers.offer(number_to_put[i]);
		}
		
		Integer elem = numbers.poll();
		
		while (elem != null) {
			PrintHelper.out(elem + " ");
			elem = numbers.poll();
		}
		
		
		
		Map<String, String> cityRegions = new HashMap<>(); 
		
		cityRegions.put("Napoli", "Campania");
		cityRegions.put("Salerno", "Campania");
		cityRegions.put("Benevento", "Lombardia");
		
		
		for(Map.Entry<String, String> m:cityRegions.entrySet()) {
			PrintHelper.out("Citta: " + m.getKey() + " (" + m.getValue() + ")");
		}
		
		cityRegions.put("Benevento", "Campania");
		
		
		
		for(Map.Entry<String, String> m:cityRegions.entrySet()) {
			PrintHelper.out("Citta: " + m.getKey() + " (" + m.getValue() + ")");
		}
		
		
		//ArrayList e LinkedList
		List<Integer> bNumbers = new ArrayList<>();
		bNumbers.add(1);
		bNumbers.add(2);
		bNumbers.add(3);
		for(Integer n:bNumbers) {
			PrintHelper.out(n);
		}
		
		Collections.shuffle(bNumbers);
		for(Integer n:bNumbers) {
			PrintHelper.out(n);
		}
	}
  
}
	

	
	
