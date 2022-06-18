package com.search.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.search.project.model.Student;
import com.search.project.model.dao.StudentDAO;

@Controller
public class StudentController {

	@Autowired
	private StudentDAO studentDAO;
	
	@GetMapping("/student/signup")
	public String projects() {
		return "studentSignup";
	}
	
	@PostMapping("/student/save")
	public String teacherRegisterSave(Student student, Model model) {
		
		this.studentDAO.save(student);
		model.addAttribute("teacher", student);
		
		return "teacherSignup";
	}
	
}
