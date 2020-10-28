package it.esedra.corso;

import it.esedra.corso.helpers.PrintHelper;

public class B extends A {

	private int x = 11;

	protected void foo() {
		PrintHelper.out("foo in B");
	}

	public B() {
		super(); // per assicurare una corretta inizializzazione
					// della classe base
		// super.x permette di accedere al campo x in A nascosto dal campo x in B

		System.out.printf("x in B = %d, x in A = %d%n", x, super.x);
		// super.foo() permette di accedere al metodo foo in A
		// sovrascritto dal metodo foo in B
		// in pratica i campi con lo stess onome tra una classe base e una derivata,
		// sono
		// sempre nascosti ma i metodi con la stessa segnatura, tra una classe base e
		// una classe
		// derivata, sono sempre sovrascritti e il loro accesso avviene sempre in
		// in modo polimorfo a runtime sull'effetto tipo riferito
		super.foo();
		foo();
	}
}
