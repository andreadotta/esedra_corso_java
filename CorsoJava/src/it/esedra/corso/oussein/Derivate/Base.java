package it.esedra.corso.oussein.Derivate;

/** metodi getter e setter */

public abstract class Base {

	private String nome;
	private int salary;

	public Base(String nome, int salary) {
		super();
		this.nome = nome;
		this.salary = salary;

	}

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

	public abstract String getInsegnante();
}
