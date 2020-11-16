package it.esedra.corso.collections;

import javax.json.JsonArray;

import it.esedra.corso.collections.interfaces.Collection;

public class DoubleCollection extends AbstactCollections<Double> implements Collection<Double> {

	public DoubleCollection() {
		super(new Double[AbstactCollections.DEFAULT_SIZE]);
	}

	@Override
	public Iterator<Double> createIterator() {
		return new Iterator<Double>(super.toArray());
	}

	@Override
	public JsonArray toJson() {
		// TODO Auto-generated method stub
		return null;
	}

}
