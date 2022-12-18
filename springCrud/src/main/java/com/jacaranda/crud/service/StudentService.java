package com.jacaranda.crud.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.crud.model.Student;

@Service
public class StudentService {
	
	private List<Student> studentList;
	
	public StudentService() {
		this.studentList = new ArrayList<>();
		studentList.add(new Student("Inma", "Olias", 25));
		studentList.add(new Student("Pepe", "Olias", 23));
		studentList.add(new Student("Marta", "Olias", 20));
		studentList.add(new Student("Juan", "Olias", 28));
	}
	
	
	public List<Student> getStudentList() {
		return studentList;
	}
	
	public void addStudent(Student s) {
		this.studentList.add(s);
	}
	
	public void removeStudent (Student s) {
		this.studentList.remove(s);
	}

	public Student getStudent(String nombre, String apellido) {
		Boolean encontrado = false;
		Student resultado = null;
		
		Iterator<Student> itr = this.studentList.iterator();
		while(itr.hasNext() && !encontrado) {
			resultado = itr.next();
			if(resultado.getName().equals(nombre) && resultado.getLastName().equals(apellido)) {
				encontrado = true;
			}
		}
		
		return resultado;
	}
	
	public boolean updateStudent(String nombre, String apellido, int edad) {
		boolean encontrado = false;
		Student resultado = null;
		
		Iterator<Student> itr = this.studentList.iterator();
		while(itr.hasNext() && !encontrado) {
			resultado = itr.next();
			if(resultado.getName().equals(nombre) && resultado.getLastName().equals(apellido)) {
				resultado.setAge(edad);
				encontrado = true;
			}
		}
		
		return encontrado;
	}
}
