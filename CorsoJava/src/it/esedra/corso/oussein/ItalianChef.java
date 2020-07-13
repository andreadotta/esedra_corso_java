package it.esedra.corso.oussein;

import it.esedra.corso.helpers.PrintHelper;

public class ItalianChef extends Chef {
	
	public ItalianChef () {
		super();
		super.setNazione("Italia");
	}
	protected void setNazione(String nazione) {
		
	}
	
	public void faChicken() {
		System.out.println(" il chef cucina uove con parm");
	}
	
	public void faPasta() {
		PrintHelper.out(" lo chef fa pasta con frutti di mare");
		
	}

}
