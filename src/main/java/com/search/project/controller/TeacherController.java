package com.search.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.search.project.model.Teacher;
import com.search.project.model.dao.TeacherDAO;

@Controller
public class TeacherController {

	@Autowired
	private TeacherDAO teacherDAO;

	@GetMapping("/teacher/signup")
	public String register() {
		return "teacherRegister";
	}

	@GetMapping("/teachers/list")
	public String list(Model model) {

		List<Teacher> teachers = teacherDAO.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		model.addAttribute("teachers", teachers);

		return "teachersList";
	}

	@PostMapping("/teachers/search")
	public String search(@RequestParam String search, @RequestParam() Optional<String> knowledgeArea, Model model) {
		List<Teacher> teachers = new ArrayList<Teacher>();
		
		if (search.isEmpty() && knowledgeArea.isEmpty()) {
			return "redirect:/teachers/list";
		} else if (search.isEmpty() && !knowledgeArea.isEmpty()) {
			teachers = teacherDAO.findByKnowledgeArea(knowledgeArea.get());
		} else if (!search.isEmpty() && knowledgeArea.isEmpty()) {
			teachers = teacherDAO.findByName(search);
		} else {
			teachers = teacherDAO.findByNameAndKnowledgeArea(search, knowledgeArea.get());
		}

		model.addAttribute("amount", teachers.size());
		model.addAttribute("teachers", teachers);
		return "teachersList";
	}

	@PostMapping("/teacher/save")
	public String teacherRegisterSave(Teacher teacher, Model model) {

		this.teacherDAO.save(teacher);
		model.addAttribute("name", teacher.getNome());
		model.addAttribute("type", "professor");
		return "sucess";
	}
}
