package com.search.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.search.project.model.SearchProject;
import com.search.project.model.Student;
import com.search.project.model.Teacher;
import com.search.project.model.dao.SearchProjectDAO;
import com.search.project.model.dao.StudentDAO;
import com.search.project.model.dao.TeacherDAO;

@Controller
public class SearchProjectController {

	@Autowired
	private SearchProjectDAO searchProjectDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private TeacherDAO teacherDAO;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/projects")
	public String projects() {
		return "projects";
	}
	
	@GetMapping("/project-register")
	public String projectRegister() {
		return "projectRegister";
	}
	
	@PostMapping("/project-register/save")
	public String projectRegisterSave(SearchProject searchProject, Model model) {
		
		this.searchProjectDAO.save(searchProject);
		model.addAttribute("student", searchProject);
		
		return "home";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@GetMapping("/student-register")
	public String studentRegister() {
		return "studentRegister";
	}
	
	@PostMapping("/student-register/save")
	public String studentRegisterSave(Student student, Model model) {
		
		this.studentDAO.save(student);
		model.addAttribute("student", student);
		
		return "home";
	}
	
	@GetMapping("/teacher-register")
	public String teacherRegister() {
		return "teacherRegister";
	}
}
