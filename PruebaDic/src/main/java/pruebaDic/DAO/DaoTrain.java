package pruebaDic.DAO;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


import pruebaDic.model.Train;
//import pruebaDic.model.User;

public class DaoTrain {

	private StandardServiceRegistry sr;
	private SessionFactory sf;
	private Session session;

	public DaoTrain() {
		this.sr = new StandardServiceRegistryBuilder().configure().build();
		this.sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		this.session = sf.openSession();
	}

	public Session getSession() {
		return session;
	}

	public Train get(int cod) {
		Train traintravel = null;
		try {
			traintravel = session.get(Train.class, cod);
		} catch (Exception e) {
			System.out.println("Error");
		}
		return traintravel;
	}

	public ArrayList<Train> getList() {
		ArrayList<Train> lista= null;
		try {
			String hql = "SELECT * FROM train u";
			Query<Train> query = session.createNativeQuery(hql, Train.class);
			lista =  (ArrayList<Train>) query.getResultList();
		} catch (Exception f) {
			System.out.println("Error");
		}
		return lista;
	}
	
	public ArrayList<Train> getAvailableTrains(){
		ArrayList<Train> lista= (ArrayList<Train>) session.createQuery("SELECT t FROM pruebaDic.model.Train t where numbertickets>0", Train.class).getResultList();
		return lista;
	}

	public boolean add(Train traintravel) {
		boolean result = false;
		try {

			session.getTransaction().begin();
			session.save(traintravel);
			session.getTransaction().commit();
			result = true;
		} catch (Exception g) {
			System.out.println("Error");
		}
		return result;
	}

	public void delete(Train traintravel)  {
		try {
			session.getTransaction().begin();
			session.delete(traintravel);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error");
		}
		
	}

	public boolean update(Train traintravel) throws DaoException {
		boolean result = false;
		try {

			session.getTransaction().begin();
			session.update(traintravel);
			session.getTransaction().commit();
			result = true;
		} catch (Exception g) {
			throw new DaoException("No se ha podido actualizar el tren");
		}
		return result;
	}
	
}
