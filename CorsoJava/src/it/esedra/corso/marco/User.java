package it.esedra.corso.marco;
/**
 * Dovete creare una nuova classe User questa 
 * classe rappresenta l'utente che fa login e avrà i campi 
 * userEmail 
 * userName 
 * userPassword 
 * userSurname 
 * dataRegistration (java.util.data)
 * @author bauhausk
 *
 */
public class User {
	
	private String userEmail;
	private String userName;
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
	private String userPassword;
	private String  userSurname;
	private java.util.Date dataRegistration;
	public User() {
		
	}

}
