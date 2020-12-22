package it.esedra.journal;

import it.esedra.corso.collections.interfaces.DataObjectInterface;

/**
 * Questa classe è un paragrafo del diario
 * 
 * @author Oussein
 * 
 */
public class Paragraph implements DataObjectInterface  {

	private  String text;
	private  int id;
	private int idChapter;


	public Paragraph(int id, String text) {
		
	}

	public Paragraph(int id, String text,int idChapter) {
		super();
		this.id = id;
		this.text = text;
		this.idChapter=idChapter;
	}

	public   int getId() {
		return id;
	}

	public String getText() {
		return text;
	}
	public int getIdChapter() {
		return idChapter;
	}	

}
