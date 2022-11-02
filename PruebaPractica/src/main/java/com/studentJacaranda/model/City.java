package com.studentJacaranda.model;


import java.util.List;
import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name="city")
public class City {
	@Id
	private int id;
	private String city;
	private String country;
	@OneToMany(mappedBy="city") //city es el atributo de la clase students que mapea la ciudad
	private List<Student> students;
	
	public City(int id, String city, String country) {
		super();
		this.id = id;
		this.city = city;
		this.country = country;
		this.students = null;
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Student> getStudents() {
		return  students;
	}
	
	//añadido
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return id == other.id;
	}

	
	

}
