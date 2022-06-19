package com.search.project.model;

public enum KnowledgeArea {

	LINGUAGENS("Linguagens"), 
	MATEMATICA("Matemática"),
	CIENCIAS_DA_NATUREZA("Ciências da Natureza"), 
	CIENCIAS_HUMANAS("Ciências Humanas");
	
	private final String nomeExibicao;
	
	private KnowledgeArea(String nomeExibicao){
		this.nomeExibicao = nomeExibicao;
	}
	
	public String getNomeExibicao() {
        return nomeExibicao;
    }
}
