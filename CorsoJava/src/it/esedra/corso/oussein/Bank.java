package it.esedra.corso.oussein;

public class Bank {
	private String name;


public Bank(String name) {
	this.name=name;
	
}
public String getName() {
	return name;
}
public void transfer(Account<Character> sourceAccount, Account<String> targetAccount, int amount) {
	if(sourceAccount.getAmount()>amount);
	sourceAccount.remouveMoney(amount);
	targetAccount.addMoney(amount);
	
	System.out.println(sourceAccount.getOwner() + "a mandato" + amount + " " + sourceAccount.getCurrency() +
			"" + targetAccount.getOwner());
}

}