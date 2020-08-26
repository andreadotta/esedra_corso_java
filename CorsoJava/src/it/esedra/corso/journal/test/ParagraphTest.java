package it.esedra.corso.journal.test;

import it.esedra.corso.journal.Paragraph;

public class ParagraphTest {

	public static void main(String[] args) {
		Paragraph<String> paragraphs1 = new Paragraph<>();
		paragraphs1.setText("questa e la lista dei sviluppatore di oggi");
		System.out.println(paragraphs1.getText());
		
		Paragraph<Integer> id01 = new Paragraph<>();
		id01.setId(01);
		System.out.println(id01.getId());
		
		
		
	}
	
}
