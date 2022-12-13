package com.jacaranda.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("student/delete")
	public String deleteStudent(Model model) {
		Student student = new Student();
		model.addAttribute("studentDel", student);
		return "deleteStudent";
	}
	
	@PostMapping("student/deleteSubmit")
	public String deleteSubmit(@ModelAttribute("student") Student student) {
		repositorio.removeStudent(student);
		return "redirect:/student/list";
	}

}
