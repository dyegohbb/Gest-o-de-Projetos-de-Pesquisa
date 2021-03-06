package com.search.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.search.project.model.Course;
import com.search.project.model.Teacher;
import com.search.project.model.dao.CourseDAO;
import com.search.project.model.dao.TeacherDAO;

@Controller
public class CourseController {

	@Autowired
	private CourseDAO courseDAO;
	
	@Autowired
	private TeacherDAO teacherDAO;
	
	@GetMapping("/courseRegister")
	public String courseRegister(Model model){
		
		List<Teacher> teachers = teacherDAO.findAll();
		model.addAttribute("teachers", teachers);
		return "courseRegister";
	}
	
	@PostMapping("/courseRegister/save")
	public String courseRegisterSave(@RequestParam Integer teacherId, Course course, Model model) {
		
		Teacher teacher = teacherDAO.findById(teacherId).orElse(new Teacher());
		course.setCoordenador(teacher);
		
		this.courseDAO.save(course);
		model.addAttribute("name", course.getNome());
		model.addAttribute("type", "curso");
		
		return "sucess";
	}
}
