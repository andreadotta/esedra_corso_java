package it.esedra.corso.journal.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	
	AuthorTest.class,
	ChapterTest.class,
	ImageTest.class,
	JournalTest.class,
	ParagraphTest.class,
	UserTest.class,
	VideoTest.class
	
})
public class AllTests {

}
