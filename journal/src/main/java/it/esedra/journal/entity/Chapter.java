package it.esedra.journal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chapter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	
	private int id;
	private  String title;
	private  String date;


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public String getTitle() {
		return title;
	}

	public String getDate() {
		return date;
	}
	
	

}
