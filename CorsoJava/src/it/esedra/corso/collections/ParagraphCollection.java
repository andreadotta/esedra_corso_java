package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.journal.Paragraph;

public class ParagraphCollection extends AbstactCollections<Paragraph> implements Collection<Paragraph> {

	public ParagraphCollection() {
		super(new Paragraph[AbstactCollections.DEFAULT_SIZE]);
	}

	@Override
	public Iterator<Paragraph> createIterator() {
		return new Iterator<Paragraph>(super.toArray()); 

}
}
	