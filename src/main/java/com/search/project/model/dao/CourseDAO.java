package com.search.project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.search.project.model.Course;

public interface CourseDAO extends JpaRepository<Course, Integer>{

}
