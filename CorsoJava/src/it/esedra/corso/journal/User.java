package it.esedra.corso.journal;
/**
 * Dovete creare una nuova classe User questa 
 * classe rappresenta l'utente che fa login e avrà i campi 
 * userEmail 
 * userName 
 * userPassword 
 * userSurname 
 * dataRegistration (java.util.data)
 * @author Marco
 *
 */
public class User {
	
	private String userName;
	private String userSurname;
	private String userEmail;
	private String userPassword;
	private java.util.Date dataRegistration;
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserSurname() {
		return userSurname;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	public java.util.Date getDataRegistration() {
		return dataRegistration;
	}
	public void setDataRegistration(java.util.Date dataRegistration) {
		this.dataRegistration = dataRegistration;
	}
	
	public User() {
		
	}

}
