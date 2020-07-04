package it.esedra.corso.oussein;

public class Base {

	private String nome;
	private int salary;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void print() {
		System.out.println(nome + " " + salary);
	}
}

