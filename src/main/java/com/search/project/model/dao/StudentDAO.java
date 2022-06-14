package com.search.project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.search.project.model.Student;

public interface StudentDAO extends JpaRepository<Student, Integer>{

}
