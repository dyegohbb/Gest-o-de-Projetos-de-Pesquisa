package com.search.project.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.search.project.model.SearchProject;

public interface SearchProjectDAO extends JpaRepository<SearchProject, Integer> {

	@Query(value = "SELECT * FROM SEARCH_PROJECT ORDER BY DATA_INICIO DESC LIMIT 2", nativeQuery = true)
	List<SearchProject> findLastProjects();

	@Query(value = "SELECT * FROM SEARCH_PROJECT WHERE TITULO LIKE CONCAT('%',:search,'%') ORDER BY TITULO ASC", nativeQuery = true)
	List<SearchProject> findProjectByTitulo(String search);

	@Query(value = "SELECT * FROM SEARCH_PROJECT JOIN TEACHER ON TEACHER.CODIGO = SEARCH_PROJECT.RESPONSAVEL_CODIGO "
			+ "JOIN PEOPLE ON TEACHER.CODIGO = PEOPLE.CODIGO WHERE PEOPLE.NOME LIKE CONCAT('%',:search,'%') "
			+ "ORDER BY TITULO ASC", nativeQuery = true)
	List<SearchProject> findProjectByTeacher(String search);

	@Query(value = "SELECT * FROM SEARCH_PROJECT JOIN SEARCH_PROJECT_COLABORADORES ON SEARCH_PROJECT.CODIGO =  SEARCH_PROJECT_COLABORADORES.SEARCH_PROJECT_CODIGO "
			+ "JOIN STUDENT ON SEARCH_PROJECT_COLABORADORES.COLABORADORES_CODIGO = STUDENT.CODIGO "
			+ "JOIN PEOPLE ON PEOPLE.CODIGO = STUDENT.CODIGO WHERE PEOPLE.NOME LIKE CONCAT('%',:search,'%') ORDER BY SEARCH_PROJECT.TITULO ASC", nativeQuery = true)
	List<SearchProject> findProjectByStudent(String search);

	@Query(value = "SELECT * FROM SEARCH_PROJECT JOIN TEACHER ON TEACHER.CODIGO = SEARCH_PROJECT.RESPONSAVEL_CODIGO "
			+ "JOIN PEOPLE ON TEACHER.CODIGO = PEOPLE.CODIGO WHERE PEOPLE.NOME LIKE CONCAT('%',:search,'%') OR SEARCH_PROJECT.TITULO LIKE CONCAT('%',:search,'%') "
			+ "ORDER BY TITULO ASC", nativeQuery = true)
	List<SearchProject> findProjectByTituloAndTeacher(String search);

	@Query(value = "SELECT * FROM SEARCH_PROJECT JOIN SEARCH_PROJECT_COLABORADORES ON SEARCH_PROJECT.CODIGO =  SEARCH_PROJECT_COLABORADORES.SEARCH_PROJECT_CODIGO "
			+ "JOIN STUDENT ON SEARCH_PROJECT_COLABORADORES.COLABORADORES_CODIGO = STUDENT.CODIGO "
			+ "JOIN PEOPLE ON PEOPLE.CODIGO = STUDENT.CODIGO WHERE PEOPLE.NOME LIKE CONCAT('%',:search,'%') OR SEARCH_PROJECT.TITULO LIKE CONCAT('%',:search,'%') ORDER BY SEARCH_PROJECT.TITULO ASC", nativeQuery = true)
	List<SearchProject> findProjectByTituloAndStudent(String search);

	@Query(value = "SELECT * FROM SEARCH_PROJECT JOIN TEACHER ON TEACHER.CODIGO = SEARCH_PROJECT.RESPONSAVEL_CODIGO "
			+ "JOIN SEARCH_PROJECT_COLABORADORES ON SEARCH_PROJECT.CODIGO =  SEARCH_PROJECT_COLABORADORES.SEARCH_PROJECT_CODIGO " 
			+ "JOIN STUDENT ON SEARCH_PROJECT_COLABORADORES.COLABORADORES_CODIGO = STUDENT.CODIGO " 
			+ "JOIN PEOPLE ON TEACHER.CODIGO = PEOPLE.CODIGO OR STUDENT.CODIGO = PEOPLE.CODIGO WHERE PEOPLE.NOME LIKE CONCAT('%',:search,'%') "
			+ "ORDER BY SEARCH_PROJECT.TITULO ASC", nativeQuery = true)
	List<SearchProject> findProjectByTeacherAndStudent(String search);
	
	@Query(value = "SELECT * FROM SEARCH_PROJECT JOIN TEACHER ON TEACHER.CODIGO = SEARCH_PROJECT.RESPONSAVEL_CODIGO "
			+ "JOIN SEARCH_PROJECT_COLABORADORES ON SEARCH_PROJECT.CODIGO =  SEARCH_PROJECT_COLABORADORES.SEARCH_PROJECT_CODIGO " 
			+ "JOIN STUDENT ON SEARCH_PROJECT_COLABORADORES.COLABORADORES_CODIGO = STUDENT.CODIGO " 
			+ "JOIN PEOPLE ON TEACHER.CODIGO = PEOPLE.CODIGO OR STUDENT.CODIGO = PEOPLE.CODIGO WHERE SEARCH_PROJECT.TITULO LIKE CONCAT('%',:search,'%') OR PEOPLE.NOME LIKE CONCAT('%',:search,'%') "
			+ "ORDER BY SEARCH_PROJECT.TITULO ASC", nativeQuery = true)
	List<SearchProject> findProjectByTituloAndTeacherAndStudent(String search);
}
