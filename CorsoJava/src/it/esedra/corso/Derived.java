package it.esedra.corso;

import it.esedra.corso.helpers.PrintHelper;

public class Derived extends Base {

	public Derived() {
		// TODO Auto-generated constructor stub
	}

	public void m_derived() {
		PrintHelper.out(getClass().getName());
	}
}
