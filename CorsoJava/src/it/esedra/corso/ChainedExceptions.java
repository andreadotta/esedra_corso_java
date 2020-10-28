package it.esedra.corso;

/**
 * SISTEMA DI TRACCIAMENTO ECCEZIONI A CATENA
 * @author bauhausk
 *
 */
public class ChainedExceptions {

	public ChainedExceptions() {

	}

	public static void call1() throws Exception {
		
		try {
			call2();
		} catch (Exception e) {
			System.out.printf("Causa originaria: %s%n", e.getCause().getMessage());
			System.out.println(e.getMessage());
			throw new Exception("Eccezione lanciata da call1.", e);
		}
	}
	
	public static void call2() throws Exception {
		try {
			call3();
		} catch (Exception e) {
			throw new Exception("Eccezione lanciata da call2.", e);
		}
		
	}

	public static void call3() throws Exception {
		throw new Exception("Eccezione lanciata da call3");
	}
	
	public static void main(String[] args) {
		try {
			call1();
		} catch (Exception e) {
			System.out.printf("Causa originaria: %s%n", e.getCause().getMessage());
			System.out.println(e.getMessage());
			System.out.println("Attenzione ECCEZIONE nel main rilevata!");
		}
	}
}
