package com.jacaranda.studentdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.studentdb.model.Student;
import com.jacaranda.studentdb.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService service;
	
	//falta el login porque se me estaba cambiando el ordenador
	
	@GetMapping({"/","student/list"})
	public String listStudent(Model model) {
		model.addAttribute("list", service.getStudents());
		return "listStudent";
	}
	
	@GetMapping("student/add")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("newStudent", student);
		return "addStudent";
	}
	
	@PostMapping("student/addSubmit")
	public String addSubmit( @Validated @ModelAttribute("newStudent") Student student,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "addStudent";
		}else {
			service.add(student);
			return "redirect:/student/list";
		}
	}
	
	//no se puede inyectar el objeto directamente
	@GetMapping("student/delete")
	public String deleteStudent(Model model, @RequestParam("id") Long id) {
		
		Student student = service.getStudent(id);
		model.addAttribute("studentDel", student);
		return "deleteStudent";
	}
	
	@PostMapping("student/deleteSubmit")
	public String deleteSubmit(@ModelAttribute("studentDel") Student student) {
		service.delete(student);
		return "redirect:/student/list";
	}
	
	@GetMapping("student/edit")
	public String editStudent(Model model,
			@RequestParam(name="id", required=true) Long id) {
		
		Student student = service.getStudent(id);
		model.addAttribute("studentEd", student);
		return "editStudent";
	}
	
	@PostMapping("student/editSubmit")
	public String editSubmit (@ModelAttribute("studentEd") Student student) {
		System.out.println(student);
		service.update(student);
		return "redirect:/student/list";
	}

}
