package it.esedra.corso.journal.collections;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import it.esedra.corso.collections.AbstactCollections;
import it.esedra.corso.collections.Iterator;
import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.journal.Journal;

public class JournalCollection extends AbstactCollections<Journal> implements Collection<Journal> {

	public JournalCollection() {
		super(new Journal[AbstactCollections.DEFAULT_SIZE]);
	}

	@Override
	public Iterator<Journal> createIterator() {
		return new Iterator<Journal>(super.toArray());
	}

	
	
}
