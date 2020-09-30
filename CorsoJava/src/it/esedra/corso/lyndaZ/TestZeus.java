package it.esedra.corso.lyndaZ;

public class TestZeus {

	public static void main(String[] args) {
		Professore professore = new Professore("Zulu", "insegnate", 30);
		System.out.println(professore.getUomo());
		System.out.println(professore.getProfessione());
		System.out.println(professore.getAge());
	}

}
