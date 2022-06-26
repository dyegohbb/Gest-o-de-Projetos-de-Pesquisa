package com.search.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.search.project.model.Course;
import com.search.project.model.Student;
import com.search.project.model.dao.CourseDAO;
import com.search.project.model.dao.StudentDAO;

@Controller
public class StudentController {

	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private CourseDAO courseDAO;
	
	@GetMapping("/student/signup")
	public String register( Model model) {
		
		List<Course> courses = courseDAO.findAll();
		model.addAttribute("courses", courses);
		
		return "studentRegister";
	}
	
	@GetMapping("/students/list")
	public String list(Model model) {
		
		List<Student> students = studentDAO.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		model.addAttribute("students", students);
		return "studentsList";
	}
	
	@PostMapping("/students/search")
	public String search(@RequestParam String search, Model model) {
		List<Student> students = new ArrayList<Student>();
		
		if (search.isEmpty()) {
			return "redirect:/student/list";
		} else {
			students = studentDAO.findByName(search);
		}
		
		model.addAttribute("amount", students.size());

		model.addAttribute("students", students);
		return "studentsList";
	}
	
	@PostMapping("/student/save")
	public String teacherRegisterSave(@RequestParam Integer courseId, Student student, Model model) {
		
		Course course = courseDAO.findById(courseId).orElse(new Course());
		student.setCurso(course);
		
		this.studentDAO.save(student);
		model.addAttribute("name", student.getNome());
		model.addAttribute("type", "estudante");
		
		return "sucess";
	}
	
}
