package it.esedra.corso;

import it.esedra.corso.helpers.PrintHelper;

public class MyClass_2<T extends ISortable<Integer>> {

	public void foo(T t, Integer[] array) {
		t.sort(array);// posso invocare sort su t di tipo T

		for (int el : array) {
			PrintHelper.out(el + "");
		}
	}
}
