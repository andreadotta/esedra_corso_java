package it.esedra.corso.journal;

import java.util.List;
import java.util.ListIterator;

import it.esedra.corso.gianni.PrintHelper;
import it.esedra.corso.journal.dao.UserDao;

public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// Esempio di iterazione
		UserDao userdao = new UserDao(new User());
		List<User> users = userdao.getAll();
		
		for (User user : users) {
			PrintHelper.out(user.getUserName());			
		}
		

		
	}

}
