package com.search.project.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.multipart.MultipartFile;

import com.search.project.model.SearchProject;

public interface DocumentService {

	/**
	 * Add an array of files
	 * 
	 * @param multipartFiles
	 * @return 
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException 
	 */
	public void addDocuments(MultipartFile[] multipartFiles, SearchProject searchProject) throws NoSuchAlgorithmException, IOException;

}
