package pruebaDic.DAO;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

//import pruebaDic.model.Travels;
import pruebaDic.model.User;

public class DaoUser {

	private StandardServiceRegistry sr;
	private SessionFactory sf;
	private Session session;

	public DaoUser() {
		this.sr = new StandardServiceRegistryBuilder().configure().build();
		this.sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		this.session = sf.openSession();
	}

	public Session getSession() {
		return session;
	}

	public User get(String username) throws DaoException {
		User user = null;
		try {
			user = session.get(User.class, username);
		} catch (Exception e) {
			throw new DaoException("No se ha encontrado el usuario en la base de datos");
		}
		return user;
	}

	public ArrayList<User> getList() {
		ArrayList<User> lista= null;
		try {
			String hql = "SELECT * FROM user u";
			Query<User> query = session.createNativeQuery(hql, User.class);
			lista =  (ArrayList<User>) query.getResultList();
		} catch (Exception f) {
			System.out.println("Error");
		}
		return lista;
	}

	public boolean add(User user) {
		boolean result = false;
		try {

			session.getTransaction().begin();
			session.save(user);
			session.getTransaction().commit();
			result = true;
		} catch (Exception g) {
			System.out.println("Error");
		}
		return result;
	}

	public void delete(User user)  {
		try {
			session.getTransaction().begin();
			session.delete(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error");
		}
		
	}

	public boolean update(User user) {
		boolean result = false;
		try {

			session.getTransaction().begin();
			session.update(user);
			session.getTransaction().commit();
			result = true;
		} catch (Exception g) {
			System.out.println("Error");
		}
		return result;
	}
	
	/**
	 * Método que comprueba los datos del usuario para hacer login
	 * después de haber recogido un usuario de la sesión y haber comprobado que 
	 * existe en la base de datos
	 * @param u usuario
	 * @param pass contraseña a comprobar
	 * @return false si la contraseña no coincide
	 */
	public boolean checkUser(User u, String pass) { 
		boolean result = false;
		if(u.getPassword().equals(pass)) {
			result = true;
		}
		return result;
	}
	
}
