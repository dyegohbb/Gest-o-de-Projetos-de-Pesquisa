package com.search.project.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.search.project.model.Teacher;

public interface TeacherDAO extends JpaRepository<Teacher, Integer>{
	
	@Query(value = "SELECT * FROM TEACHER JOIN PEOPLE ON PEOPLE.CODIGO = TEACHER.CODIGO WHERE TEACHER.AREA_CONHECIMENTO LIKE CONCAT('%',:knowledgArea,'%') ORDER BY PEOPLE.NOME ASC", nativeQuery = true)
	List<Teacher> findByKnowledgeArea(String knowledgArea);
	
	@Query(value = "SELECT * FROM TEACHER JOIN PEOPLE ON PEOPLE.CODIGO = TEACHER.CODIGO WHERE PEOPLE.NOME LIKE CONCAT('%',:nome,'%') ORDER BY PEOPLE.NOME ASC", nativeQuery = true)
	List<Teacher> findByName(String nome);
	
	@Query(value = "SELECT * FROM TEACHER JOIN PEOPLE ON PEOPLE.CODIGO = TEACHER.CODIGO WHERE PEOPLE.NOME LIKE CONCAT('%',:nome,'%') AND TEACHER.AREA_CONHECIMENTO LIKE CONCAT('%',:knowledgArea,'%') ORDER BY PEOPLE.NOME ASC", nativeQuery = true)
	List<Teacher> findByNameAndKnowledgeArea(String nome, String knowledgArea);
	
}
