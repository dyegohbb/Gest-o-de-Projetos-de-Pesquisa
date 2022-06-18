package com.search.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.search.project.model.Teacher;
import com.search.project.model.dao.TeacherDAO;

@Controller
public class TeacherController {

	@Autowired
	private TeacherDAO teacherDAO;
	
	@GetMapping("/teacher/signup")
	public String projects() {
		return "teacherSignup";
	}
	
	@PostMapping("/teacher/save")
	public String teacherRegisterSave(Teacher teacher, Model model) {
		
		this.teacherDAO.save(teacher);
		model.addAttribute("teacher", teacher);
		
		return "teacherSignup";
	}
}
