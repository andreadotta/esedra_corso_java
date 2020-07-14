package it.esedra.corso.journal;

/**
 * Questa classe rappresenta una immagine presente nel capitolo
 * @author bauhausk
 *
 */
public class Image extends MultimediaResource {

	public Image(String name, String src) {
		super(name,src);
	}
	public void print() {
		System.out.println();
		System.out.println(this.getName()+" " + this.getSrc() );
		
}
}
