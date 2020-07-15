package it.esedra.corso.journal.dao;

import it.esedra.corso.journal.User;

public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userdao = new UserDao(new User());
		userdao.get();
	}

}
