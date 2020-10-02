package it.esedra.corso.oussein.essse;

public class EssereHuman {
	private String nome;
	private String congnome;
	private int age;

	public EssereHuman(String nome, String congnome, int age) {

		this.setNome(nome);
		this.setCongnome(congnome);
		this.setAge(age);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCongnome() {
		return congnome;
	}

	public void setCongnome(String congnome) {
		this.congnome = congnome;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void print() {

	}

}
