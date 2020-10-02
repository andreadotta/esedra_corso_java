package it.esedra.corso.oussein.Forme;

import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.oussein.animal.Animal;

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
