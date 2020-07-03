package it.esedra.corso.gianni;

import java.util.*;
import java.lang.*;
import java.io.*;



class Animale {
    private String colore;
    private String verso;
    
    public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public String getVerso() {
		return verso;
	}
	public void setVerso(String verso) {
		this.verso = verso;
	}
	public void cheColore() {
    	System.out.println(colore);
    }
    public void faiVerso(){
    	System.out.println(verso);
    }
}