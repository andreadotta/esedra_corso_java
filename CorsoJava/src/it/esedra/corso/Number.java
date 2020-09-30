package it.esedra.corso;

public class Number implements Debuggable {

	private int number1;
	private int number2;

	public Number(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}

	public void makeSum() {
		int res = number1 + number2;
		debugOnConsole("numero1 + numero2 = " + res);
	}

}
