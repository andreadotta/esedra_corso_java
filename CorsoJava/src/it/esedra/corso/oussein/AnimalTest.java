package it.esedra.corso.oussein;

public class AnimalTest {

	public static void main(String[] args) {

		Animal mycow = new Cow();
		mycow.eat();
		mycow.speak();
		Animal mydog = new Dog();
		mydog.eat();
		mydog.speak();

	}
}
