package it.esedra.corso.oussein.animal;

import it.esedra.corso.helpers.PrintHelper;

public class Cow implements Animal {

	@Override
	public void eat() {
		PrintHelper.out("cow eats some grass");

	}

	@Override
	public void speak() {
		PrintHelper.out(" cow fa moof moof");

	}

}
