package com.search.project.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.search.project.model.Student;

public interface StudentDAO extends JpaRepository<Student, Integer>{
	
	@Query(value = "SELECT * FROM STUDENT JOIN PEOPLE ON PEOPLE.CODIGO = STUDENT.CODIGO WHERE PEOPLE.NOME LIKE CONCAT('%',:search,'%') ORDER BY PEOPLE.NOME ASC", nativeQuery = true)
	List<Student> findByName(String search);

}
