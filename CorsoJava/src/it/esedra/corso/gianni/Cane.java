package it.esedra.corso.gianni;

import java.util.*;
import java.lang.*;
import java.io.*;


class Cane extends Animale {
	public void Cane() {
		this.setVerso("bau");
	}
    public void faiVerso() {
    	System.out.println("il verso del cane è " + getVerso());
    }
}
