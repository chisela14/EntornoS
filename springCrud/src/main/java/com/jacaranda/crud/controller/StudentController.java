package com.jacaranda.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.crud.model.Student;
import com.jacaranda.crud.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService repositorio;
	
	@GetMapping("student/list")
	public String listStudent(Model model) {
		model.addAttribute("list", repositorio.getStudentList());
		return "listStudent";
	}
	
	@GetMapping("student/add")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("newStudent", student);
		return "addStudent";
	}
	
	@PostMapping("student/addSubmit")
	public String addSubmit(@ModelAttribute("newStudent") Student student) {
		repositorio.addStudent(student);
		return "redirect:/student/list";
	}
	
	//no se puede inyectar el objeto directamente
	@GetMapping("student/delete")
	public String deleteStudent(Model model,
			@RequestParam(name="name", required=false, defaultValue="") String name,
			@RequestParam(name="lastName", required=false, defaultValue="") String lastName) {
		
		Student student = repositorio.getStudent(name, lastName);
		model.addAttribute("studentDel", student);
		return "deleteStudent";
	}
	
	@PostMapping("student/deleteSubmit")
	public String deleteSubmit(@ModelAttribute("studentDel") Student student) {
		repositorio.removeStudent(student);
		return "redirect:/student/list";
	}
	
	@GetMapping("student/edit")
	public String editStudent(Model model,
			@RequestParam(name="name", required=false, defaultValue="") String name,
			@RequestParam(name="lastName", required=false, defaultValue="") String lastName) {
		
		Student student = repositorio.getStudent(name, lastName);
		model.addAttribute("studentEd", student);
		return "editStudent";
	}
	
	@PostMapping("student/editSubmit")
	public String listStudentseditMethod (@ModelAttribute("studentEd") Student student) {
		repositorio.updateStudent(student.getName(), student.getLastName(), student.getAge());
		return "redirect:/student/list";
	}

}
