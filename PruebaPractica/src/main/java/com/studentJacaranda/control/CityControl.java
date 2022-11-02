package com.studentJacaranda.control;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.studentJacaranda.model.City;
import com.studentJacaranda.model.Student;

public class CityControl {

	public static City getCity(int id) throws DaoException {

		Session session = ConnectionBD.getSession();
		City city = (City) session.get(City.class, id);
		if(city == null) {
			throw new DaoException("No se ha encontrado ninguna ciudad con ese id");
		}
		return city;
	}

	public static boolean saveCity(City city) throws DaoException {
		boolean resultado = false;
		Session session = ConnectionBD.getSession();

		try {
			session.getTransaction().begin();
			session.saveOrUpdate(city);
			session.getTransaction().commit();
			resultado = true;

		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new DaoException("Ya existe esta ciudad");
		}
		
		return resultado;
	}

	public static boolean deleteCity(City city) throws DaoException {
		boolean resultado = false;
		Session session = ConnectionBD.getSession();

		try {
			session.getTransaction().begin();
			session.delete(city);
			session.getTransaction().commit();
			resultado = true;

		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new DaoException("No se ha podido borrar la ciudad");
		}
		return resultado;
	}

	public static ArrayList<City> getCities() {
		Session session = ConnectionBD.getSession();
		
		Query<City> query = session.createQuery("SELECT p FROM com.studentJacaranda.model.City p");
		ArrayList<City> cities = (ArrayList<City>) query.getResultList();
		
		return cities;

	}
	//consigue los estudiantes de una ciudad, los añade a dicha ciudad y devuleve una lista
	public static ArrayList<Student> getStudents(int cityId) throws DaoException {
		Session session = ConnectionBD.getSession();
		City c = getCity(cityId);
		String city = c.getCity();
		Query<Student> query = session.createQuery("SELECT b FROM com.jacaranda.model.Student b where city='" + city + "'");
		ArrayList<Student> studentList = (ArrayList<Student>) query.getResultList();
		c.setStudents(studentList);
		return studentList;

	}
}
