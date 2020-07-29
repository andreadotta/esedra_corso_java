package it.esedra.corso.oussein;

import java.util.Iterator;

public class MyEsedra implements EsedraIterator {

	public static void main(String[] args) {
		EsedraIterator esedra = new MyEsedra();

		System.out.println("nome=" + esedra);

	}

	@Override
	public void next() {
		System.out.println("io lavoro li");
	}

	public Iterator<MyEsedra> iterator() {

		return new Iterator<MyEsedra>() {

			@Override
			public MyEsedra next() {

				return null;
			}

			@Override
			public boolean hasNext() {
				
				return false;
			}
		};

	}

	@Override
	public void isDone() {

	}

	@Override
	public void currentItem() {

	}
}
