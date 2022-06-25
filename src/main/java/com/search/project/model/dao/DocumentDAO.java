package com.search.project.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.search.project.model.Document;

public interface DocumentDAO extends JpaRepository<Document, Integer>{
	
}
