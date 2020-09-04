package it.esedra.corso.oussein.generics;

public class MainTestAccount {

	public static void main(String[] args) {
		Account<Character> myAccount=new Account<>("Ousseynou",200, 'e'  );
		myAccount.showBalance();
		
		Account<String> otherAccount=new Account<>("Ndiemane",100, "euros");
		otherAccount.showBalance();
		
		
		
		Bank bank =new Bank("WeusBank");
		bank.transfer(myAccount, otherAccount,25);
		
		myAccount.showBalance();
		otherAccount.showBalance();

	}

}



