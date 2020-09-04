package it.esedra.corso.journal;

/**
 * Dovete creare una nuova classe User; questa classe rappresenta l'utente che fa
 * login e avrà i campi: name, surname, email, password, registration
 * 
 * @author Marco
 *
 */
public class User {

	private Integer id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String registration;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public User() {

	}

}
