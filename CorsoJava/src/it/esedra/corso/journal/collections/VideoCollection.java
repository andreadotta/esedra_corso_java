package it.esedra.corso.journal.collections;

import java.util.Arrays;

import it.esedra.corso.collections.AbstactCollections;
import it.esedra.corso.collections.Iterator;
import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.User;
  
public class VideoCollection extends AbstactCollections<Video> implements Collection<Video> {

	public VideoCollection() {
		super(new Video[AbstactCollections.DEFAULT_SIZE]);
	}

	@Override
	public Iterator<Video> createIterator() {
		return new Iterator<Video>(super.toArray());
	}

}
