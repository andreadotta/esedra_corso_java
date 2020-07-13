package it.esedra.corso.oussein;

import it.esedra.corso.helpers.PrintHelper;

public class Dog implements Animal {

	@Override
	public void eat() {
		PrintHelper.out("dog eats some kibles");

		
	}

	@Override
	public void speak() {
		PrintHelper.out(" dog fa woof woof");
		
		
	}

}
