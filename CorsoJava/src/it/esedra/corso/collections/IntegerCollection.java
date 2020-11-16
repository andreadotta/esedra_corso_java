package it.esedra.corso.collections;

import javax.json.JsonArray;

import it.esedra.corso.collections.interfaces.Collection;

public class IntegerCollection extends AbstactCollections<Integer> implements Collection<Integer> {

	public IntegerCollection() {
		super(new Integer[AbstactCollections.DEFAULT_SIZE]);
	}

	@Override
	public Iterator<Integer> createIterator() {
		return new Iterator<Integer>(super.toArray());
	}

	@Override
	public JsonArray toJson() {
		// TODO Auto-generated method stub
		return null;
	}

}
