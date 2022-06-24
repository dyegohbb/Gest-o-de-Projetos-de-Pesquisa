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
	private TeacherDAO teacherDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<SearchProject> lastProjects = searchProjectDAO.findLastProjects();
		model.addAttribute("lastProjects", lastProjects);
		
		return "home";
	}

	@GetMapping("/projects")
	public String projects(Model model) {
		
		List<SearchProject> projects = searchProjectDAO.findAll(Sort.by(Sort.Direction.ASC, "titulo"));
		model.addAttribute("projects", projects);
		
		Integer amount = projects.size(); 
		
		model.addAttribute("amount", amount);
		
		return "projects";
	}
	
	@GetMapping("/project-register")
	public String projectRegister(Model model) {
		
		List<Teacher> teachers = teacherDAO.findAll();
		model.addAttribute("teachers", teachers);
		
		List<Student> students = studentDAO.findAll();
		model.addAttribute("students", students);
		
		return "projectRegister";
	}
	
	@PostMapping("/project-register/save")
	public String projectRegisterSave(@RequestParam Integer teacherId, @RequestParam List<Integer> studentsId, SearchProject searchProject, Model model) {
		
		Teacher teacher = teacherDAO.findById(teacherId).orElse(new Teacher());
		searchProject.setResponsavel(teacher);
		
		List<Student> students = new ArrayList<Student>();
		
		for (int i = 0; i < studentsId.size(); i++) {
			Student student = studentDAO.findById(studentsId.get(i)).orElse(new Student());
			if(!student.equals(new Student())) {
				students.add(student);
			}
		}
		
		searchProject.setColaboradores(students);
		
		this.searchProjectDAO.save(searchProject);
		model.addAttribute("searchProject", searchProject);
		
		return "home";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
}
