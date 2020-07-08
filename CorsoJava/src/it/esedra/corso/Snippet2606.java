package it.esedra.corso;



public class Snippet2606 {

	    
	/*
	 * I commenti per la documentazione. 
	 * Java ha un formato standard per i commenti che descrivone le classi e le loro caratteristiche. 
	 * Il java jdk contiene uno strumento che si chiama appunto javadoc che genera automaticamente 
	 * un opportuno insieme di pagine HTML che descrivono le vostre classi ovviamente se si usano dei 
	 * commenti in una determinata forma. 
	 * Il commento per la documentazione è sono delimitati dal / * * e * / i commenti per 
	 * le classi sia quelli per i metodi iniziano con un testo in formato libero, 
	 * ma il programma Java doc inserisce la prima fase in una tabella riassuntiva. 
	 * Per cui generale è meglio scrivere con cura tale prima frase. 
	 * Accetta questi input lista di argomenti. 
	 * Non è necessario che in una frase ci sia una grammatica azione completa, 
	 * ma dovrebbe conservare il proprio significato anche fuori dal commento, 
	 * quindi dovete immaginarvi questa frase che scrivete voi all'inizio del commento 
	 * come una come all'interno di una tabella riassuntiva. 
	 * I commenti e per i metodi e per i e i costruttori contengono ulteriori informazioni 
	 * per ciascun parametro occorre inserire una riga che inizia con il marcatore @param come abbiamo 
	 * seguito dal nome del parametro ed una breve spiegazione una ulteriore riga invece che inizia con 
	 * il marcatore @return descrivere il valore di ritorno restituito dal metodo 
	 * I metodi che non hanno parametri non hanno nemmeno righe e non hanno un valore di ritorno non hanno @return 
	 * 
	 */
	
	/** metodi getter e setter*/
	
	
	/*
	 * Per generare automaticamente i metodo getters and setters utilizzo una funzionalità dell'IDE
	 * Eclipse. 
	 * Cliccando sul file .vava si apre il menu
	 * seleziono quindi "Source" e quindi "Generate Getters and setters"
	 * seleziono quindi le variabili per cui voglio create i metodi
	 * clicco su "Generate"
	 */
	private int age;
	
	private String name;

	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	/*
	 * Gli oggetti sono entità di un programma e sono solo dotati di tre proprietà caratteristiche fondamentali
	 * , lo stato 
	 *   il comportamento 
	 *   l'identità 
	 *  
	 *  L'insieme di tutte le informazioni conservate da un oggetto costituisce 
	 *  lo STATO dell'oggetto stesso 
	 *  Lo stato di un oggetto può modificarsi nel tempo ma soltanto in occasione 
	 *  di un'operazione che venga compiuta sull'oggetto stesso che ne provoca 
	 *  un cambiamento di stato 
	 */
	
	
	
}
