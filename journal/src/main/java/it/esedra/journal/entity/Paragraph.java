package it.esedra.journal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Paragraph {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private String text;
	
	private int id;
	

	

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	}



