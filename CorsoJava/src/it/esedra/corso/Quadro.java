/**
 * 
 */
package it.esedra.corso;

/**
 * @author bauhausk
 *
 */
enum Colors {
	RED,
	BLUE,
	BLACK
}

public class Quadro {
	
	private String author;
	private int code;
	private Colors color;
	
	public Quadro() {

	}
	
	public Quadro(String author, int code, Colors color) {
		this.author = author;
		this.code = code;
		this.color = color;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Colors getColor() {
		return color;
	}

	public void setColor(Colors color) {
		this.color = color;
	}
	
	public String toString() {
		return getAuthor();
	}
	
	public boolean equals(Object obj) {
		return ((Quadro) obj).getAuthor().equals(this.getAuthor());
	
	}
	
	public int hashCode() {
		return author.hashCode();
	}
	
	
}
