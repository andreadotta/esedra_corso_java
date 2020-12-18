package it.esedra.corso;

import java.util.Comparator;

public class EsempioComparator implements Comparator<String> {

	@Override
	public int compare(String a, String b) {
		if (a.equals("Milano")) {
			return -1;
		}
		if (b.equals("Milano")) {
			return 1;
		}
		return a.compareTo(b);
	}
	

}
