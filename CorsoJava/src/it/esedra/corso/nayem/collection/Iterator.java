package it.esedra.corso.nayem.collection;

public interface Iterator <D>{

	D next();
	
	D currentItem();
	
	
	boolean hasNext();
	
	boolean isDone();
}
