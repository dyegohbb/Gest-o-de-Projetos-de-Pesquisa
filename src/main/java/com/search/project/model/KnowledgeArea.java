package com.search.project.model;

public enum KnowledgeArea {

	LINGUAGENS("Linguagens"), 
	MATEMATICA("Matemática"),
	CIENCIAS_DA_NATUREZA("Ciências da Natureza"), 
	CIENCIAS_HUMANAS("Ciências Humanas");
	
	@SuppressWarnings("unused")
	private final String nomeExibicao;
	
	KnowledgeArea(String valor){
		this.nomeExibicao = valor;
	}
}
