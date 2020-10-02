package it.esedra.corso;

import it.esedra.corso.helpers.PrintHelper;

/**
 * 
 * Realaizione di sottotipo Derived <: Base Generic<T> NON E' VERO
 * Generic<Derived> <: Generic<Base>
 * 
 * 1.
 * 
 */
public class Derived extends Base {

	public Derived() {
		// TODO Auto-generated constructor stub
	}

	public void m_derived() {
		PrintHelper.out(getClass().getName());
	}
}
