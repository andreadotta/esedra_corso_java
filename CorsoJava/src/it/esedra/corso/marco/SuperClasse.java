package it.esedra.corso.marco;

public class SuperClasse {

	public static void main(String[] args) {
		
		ClasseDerivata time = new ClasseDerivata();
		time.setHours(18);
		time.setMinutes(37);	
		time.setSeconds(26);
		time.setMilliseconds(789);
		time.setDayName("Venerdì");
		
		System.out.println(time.getTimeAndYear());

	}

}
