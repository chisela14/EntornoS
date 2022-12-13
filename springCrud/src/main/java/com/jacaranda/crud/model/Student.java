package com.jacaranda.crud.model;

import java.util.Objects;

public class Student {
	
	private String name;
	private String lastName;
	private int age;
	
	public Student() {
	
	}

	public Student(String nombre, String apellido, int edad) {
		this.name = nombre;
		this.lastName = apellido;
		this.age = edad;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lastName, age, name);
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
		return Objects.equals(lastName, other.lastName) && age == other.age && Objects.equals(name, other.name);
	}
	
	
	
	
	
}
