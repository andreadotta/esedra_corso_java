package it.esedra.corso.collections;

import javax.json.JsonArray;

import it.esedra.corso.collections.interfaces.Collection;

public class FloatCollection extends AbstactCollections<Float> implements Collection<Float> {

	public FloatCollection() {
		super(new Float[AbstactCollections.DEFAULT_SIZE]);
	}

	@Override
	public Iterator<Float> createIterator() {
		return new Iterator<Float>(super.toArray());
	}

	@Override
	public JsonArray toJson() {
		// TODO Auto-generated method stub
		return null;
	}

}
