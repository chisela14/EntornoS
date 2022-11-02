package com.studentJacaranda.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="student")
public class Student {
	@Id
	private int id;
	@Column(name="first_name")
	private String name;
	@Column(name="last_name")
	private String surname;
	private String email;
	private String gender;
	@ManyToOne
	@JoinColumn(name = "city") //Nombre de la columna en la base de datos, que es FK
	private City city;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(int id, String name, String surname, String email, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.gender = gender;
	}

	public City getCity() {
		return city;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
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
		Student other = (Student) obj;
		return id == other.id;
	}

	
	

}
