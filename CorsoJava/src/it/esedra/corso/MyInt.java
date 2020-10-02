package it.esedra.corso;

import java.util.Arrays;

public class MyInt implements ISortable<Integer> {

	@Override
	public void sort(Integer[] t) {
		Arrays.sort(t);

	}

}
