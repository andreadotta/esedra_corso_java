package it.esedra.corso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import it.esedra.corso.helpers.PrintHelper;

/**
 * Non permettiamo che la classe sia derivabile e quindi i ruoi metodi
 * ridefinibili
 * 
 * @author bauhausk
 *
 */
final class CheckingAccount {

	public final String name;
	public final String bank;
	public final String city;
	private final List<Integer> accounts;

	public CheckingAccount(String name, String bank, String city, List<Integer> accounts) {

		this.name = name;
		this.bank = bank;
		this.city = city;
		this.accounts = accounts;
	}

	public final List<Integer> getAccounts() {

		return Collections.unmodifiableList(accounts); // collezione immobificabile
	}

	public CheckingAccount orderAccounts() {
		// effettuiamo un ordinamento su una copia ma l'oggetto non è modificato
		List<Integer> copy = new ArrayList<>(accounts);
		Collections.sort(copy);
		return new CheckingAccount(name, bank, city, copy);
	}

}

public class Immutability {

	public static void main(String[] args) {
		CheckingAccount sigRossi = new CheckingAccount("Rossi", "Superbanca", "Prato", Arrays.asList(123, 5674, 950));

		// java.lang.UnsupportedOperationException
		// sigRossi.getAccounts().clear();

		PrintHelper.out("Conti nr.");
		PrintHelper.out(sigRossi.getAccounts().toString());

		PrintHelper.out("Conti nr.");
		PrintHelper.out(sigRossi.orderAccounts().getAccounts().toString());
	}

}
