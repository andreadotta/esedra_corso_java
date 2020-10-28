package it.esedra.corso;

import java.util.function.IntPredicate;

import it.esedra.corso.helpers.PrintHelper;

class ClassA // PROPRIO SCOPE - OUTER
{
	public static final int NUMBER = 10;

}

class ClassB // PROPRIO SCOPE - OUTER
{
	public static final int NUMBER = 100;

}

class ClassC // PROPRIO SCOPE - OUTER
{
	public static final int SIZE = 1000;

	public static class ClassD // PROPRIO SCOPE INNER

	{
		public static final int SIZE = 2000;
	}
}

class ClassE // PROPRIO SCOPE - OUTER
{
	private int width = 55;
	private String prefix = "$$$";
	public void setWith(int width)
	{
		int w = width; //è usato un param width che nasconde la variabile di istanza width;
		int w2 = this.width; // qui la variabile d'istanza width è usata tramite il this
		
		String prefix = ";;;"; //prefix di ClassE è nascosta dalla var locale prefix
		PrintHelper.out("In setWith prefix e: " + prefix);
	}
}

class ClassF // // PROPRIO SCOPE - OUTER SCOPE
{

	private int flag = -1;
	private int value = 100;
	private IntPredicate i_pred = (int flag) -> //PROPRIO SCOPE - INNER SCOPE
	{
		
		int _f = flag; //il paramentro flag nasconde la variabile d'istanza flag
		int value = 200; // la variabile locale value nasconde la variabile d'instanza
		
		return value == _f;
		
	};
	
	public boolean test(int f) {
		return i_pred.test(f);
	}
	
}


class ClassG //PROPRIO SCOPE - OUTER SCOPE
{
	private int flag = 100;
	private int value = 200;
	private int counter = 400;	

	public void test(int flag) {

		int inc = 10;
		//CLASSE LOCALE
		IntPredicate p1 = new IntPredicate() {
			
			@Override
			public boolean test(int value) {
				/*
				inc = 330; Ci sarebbbe un errore
				Se volessimo qui assegnare un valore ad inc
				si avrebbe un errore
				perché le variabili locali che fanno riferimento da una classe inner
				devono essere FINAL
				*/
				
				//inc nasconde la variabile locale inc del metodo test
				int inc = 33;
				

				return value + inc == flag;
			}
		};
		PrintHelper.out("test del precicato p1 = " + p1.test(flag));		
		
		
		//LAMBA EXPRESSION
		IntPredicate p2 = value -> //NON HA SCOPE PROPRIO
		{
			//inc NON può essere dichiarata perché già dichiarata in test
			//non può essere nemmeno ridefinita
			 
			
			counter += 200; //la restrizione FINAL non opera sui campi di una classe
			
			return value + counter == flag; //value nasconde la variabile di istanza
		};
	}
	
}

public class Snippet1210 {

	public Snippet1210() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		ClassE classE = new ClassE();
		classE.setWith(99);
		
		ClassF cf = new ClassF();
		PrintHelper.out("test classf i_pred = " + cf.test(30));
		
		ClassG cg = new ClassG();
		cg.test(100);
	}
}
