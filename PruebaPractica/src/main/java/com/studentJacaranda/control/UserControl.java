package com.studentJacaranda.control;

import org.hibernate.Session;

import com.studentJacaranda.model.User;

public class UserControl {

	public static User getUser(String name) throws DaoException {
		Session session = ConnectionBD.getSession();
		User user = (User) session.get(User.class, name);
		if(user == null) {
			throw new DaoException("No se ha encontrado ningun usuario con ese nombre");
		}
		return user;
	}
	
	public static boolean userIsValid(String name, String password) {
		boolean result = false;
		try {
			User user = getUser(name);
			if(user.getPassword().equals(password)) {
				result = true;
			}
		}catch(DaoException d) {
			
		}
		return result;
	}

}
