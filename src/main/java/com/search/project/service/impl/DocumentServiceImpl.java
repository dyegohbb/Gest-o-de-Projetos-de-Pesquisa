package com.search.project.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.search.project.model.Document;
import com.search.project.model.SearchProject;
import com.search.project.model.dao.DocumentDAO;
import com.search.project.property.DocumentStorageProperty;
import com.search.project.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService{
	
	@Autowired
	private DocumentDAO documentDAO;
	
	private final Path docStorageLocation;
	
	public DocumentServiceImpl(DocumentStorageProperty documentStorageProperty) throws IOException {
		this.docStorageLocation = Paths.get(documentStorageProperty.getUploadDirectory()).toAbsolutePath().normalize();
		Files.createDirectories(this.docStorageLocation);
	}
	
	@Override
	@Transactional
	public void addDocuments(MultipartFile[] multipartFiles, SearchProject searchProject) throws NoSuchAlgorithmException, IOException {
		for (MultipartFile multipartFile : multipartFiles) {
			create(multipartFile, searchProject);
		}
	}
	
	private void create(MultipartFile multipartFile, SearchProject searchProject) throws NoSuchAlgorithmException, IOException {
		Document document = new Document();
		document.setName(multipartFile.getOriginalFilename());
		document.setMimeType(multipartFile.getContentType());
		document.setSize(multipartFile.getSize());
		document.setHash();
		document.setSearchProject(searchProject);
		storeDocument(multipartFile, document.getHash());
		documentDAO.save(document);
	}
	
	private void storeDocument(MultipartFile multipartFile, String hash) throws IOException {
		Path targetLocation = this.docStorageLocation.resolve(hash);
		Files.copy(multipartFile.getInputStream(), targetLocation);
	}
	
}
