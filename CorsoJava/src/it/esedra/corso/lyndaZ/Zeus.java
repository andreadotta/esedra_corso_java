/**
 * 
 */
package it.esedra.corso.lyndaZ;

/**
 * @author mcbra
 *
 */
public abstract class Zeus {
private String Uomo ;
private String professione ;
private int age	;


	public Zeus(String uomo, String professione , int age ) {
		this.Uomo= uomo ;
		this.professione= professione ;
		this.age = age ;
		
		
	}


	/**
	 * @return the uomo
	 */
	public String getUomo() {
		return Uomo;
	}


	/**
	 * @param uomo the uomo to set
	 */
	public void setUomo(String uomo) {
		Uomo = uomo;
	}


	/**
	 * @return the professione
	 */
	public String getProfessione() {
		return professione;
	}


	/**
	 * @param professione the professione to set
	 */
	public void setProfessione(String professione) {
		this.professione = professione;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
public void print() {
	System.out.println("Uomo" + "professione" + age);
	
}
 public abstract String getInsegnate();
}
