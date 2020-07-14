package it.esedra.corso.journal;

/**
 * Questa classe è un video presente nel capitolo
 * @author bauhausk
 *
 */
public class Video extends MultimediaResource {

	public Video(String name,String src) {
		super(name,src);
		
	}
	public void print() {
		System.out.println("quadro di padre Pio");
		System.out.println(this.getName()+" " + this.getSrc() );
		

}
}
