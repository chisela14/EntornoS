package pruebaDic.DAO;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import pruebaDic.model.Travels;
import pruebaDic.model.User;

public class DaoTravel {

	private StandardServiceRegistry sr;
	private SessionFactory sf;
	private Session session;

	public DaoTravel() {
		this.sr = new StandardServiceRegistryBuilder().configure().build();
		this.sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		this.session = sf.openSession();
	}

	public Session getSession() {
		return session;
	}
	
	public boolean add(Travels travel) throws DaoException {
		boolean result = false;
		try {

			session.getTransaction().begin();
			session.save(travel);
			session.getTransaction().commit();
			result = true;
		} catch (Exception g) {
			throw new DaoException("No se ha podido añadir el viaje");
		}
		return result;
	}
	
	public ArrayList<Travels> getUserTravels(User user){
	ArrayList<Travels> purchases = (ArrayList<Travels>) session.createQuery("SELECT t FROM pruebaDic.model.Travels t where iduser='" + user.getUsername() + "'", Travels.class).getResultList();
	return purchases;
	}

}
