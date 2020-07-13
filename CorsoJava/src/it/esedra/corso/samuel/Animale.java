package it.esedra.corso.samuel;

public abstract class Animale implements Movimento {

	private String nome;
    private Testa testa;
    
	public Testa getTesta() {
		return testa;
	}

	public void setTesta(Testa testa) {
		this.testa = testa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
