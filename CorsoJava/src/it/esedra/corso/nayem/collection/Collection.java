package it.esedra.corso.nayem.collection;



public interface Collection <D>{
	
	Iterator<D> createIterator();
	
	void add(D item);
	
	
	void test();

}
