package it.esedra.corso;

public class TypeParamTest {

	public static void main(String[] args) {

		// l'argomento ti tipo soddifa il vincolo imposto su T
		MyClass_1<Base> m1 = new MyClass_1<>();
		m1.name(new Base());

		// l'argomento ti tipo soddifa il vincolo imposto su T
		MyClass_1<Derived> m2 = new MyClass_1<>();
		m2.name(new Derived());

		// argomento soddisfa il vincolo imposto su T
		MyClass_2<MyInt> m3 = new MyClass_2<>();
		m3.foo(new MyInt(), new Integer[] { 1, 2, 4, 5 });

	}

}
