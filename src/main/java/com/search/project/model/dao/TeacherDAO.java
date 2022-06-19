package com.search.project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.search.project.model.Teacher;

public interface TeacherDAO extends JpaRepository<Teacher, Integer>{
	
}
