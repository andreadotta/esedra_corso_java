package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;

public class FloatCollection extends AbstactCollections<Float> implements Collection<Float> {

	public FloatCollection() {
		super(new Float[AbstactCollections.DEFAULT_SIZE]);
	}

	@Override
	public Iterator<Float> createIterator() {
		return new FloatIterator(super.toArray());
	}

}
