package it.esedra.corso;

import it.esedra.corso.helpers.PrintHelper;

interface MyInterface
{
	default void bar() { PrintHelper.out("MyInterface"); }
	static void foo() { PrintHelper.out("MyInterface"); }
}
interface MyInterface2 extends MyInterface {}

interface MyInterface3 extends MyInterface {
	default void bar() { PrintHelper.out("MyInterface3"); }
	static void foo() { PrintHelper.out("MyInterface3"); }
}

interface MyInterface4 {
	default void bar() { PrintHelper.out("MyInterface4"); }
}

class MyClass implements MyInterface
{
	static void foo() {  }
}
class MyClass2 extends MyClass {}

class MyClass3
{
	public void foo() { PrintHelper.out("MyClass3"); }
}

class MyClass4 extends MyClass3 implements MyInterface {}

class MyClass5 implements MyInterface, MyInterface3 {}

class MyClass6 implements MyInterface, MyInterface4 {
	public void bar() {
		MyInterface4.super.bar();
	}
}

public class Snippet3009 {

	public Snippet3009() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		MyInterface myInt = new MyClass();
		MyClass myClass = new MyClass();

		// myInt.foo(); errato
		MyInterface.foo(); //corretto
		
		myClass.foo(); //corretto
		MyClass.foo(); //corretto
	
		// MyInterface2.foo(); non è possibile applicare l'ereditarietà ai metodi statici
		//di interfaccia
		MyClass2.foo(); //ok
		
		new Number(100, 100).makeSum();
		
		new MyClass4().foo();
		
		new MyClass5().bar();
		
		new MyClass6().bar();
	}

}
