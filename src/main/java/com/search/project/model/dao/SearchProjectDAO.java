package com.search.project.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.search.project.model.SearchProject;

public interface SearchProjectDAO extends JpaRepository<SearchProject, Integer>{

	@Query(value = "SELECT * FROM SEARCH_PROJECT ORDER BY DATA_INICIO DESC LIMIT 2", nativeQuery = true)
	List<SearchProject> findLastProjects();
	
}
