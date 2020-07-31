package it.esedra.corso.lynda.myjournal;

public class JournalData implements Gossip {
	public JournalData() {
		    String genre = "narative";
			System.out.println("my jornal type is " + genre);

			String tittle = "women";
			System.out.println ("and its tittled " + tittle);
			
			int page = 200;
            System.out.println (page );
        		 
	        String author = "Lyn Mcbrain";
			System.out.printf ("the protagonist of" , "tittle"  + author);			
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}
	 
}