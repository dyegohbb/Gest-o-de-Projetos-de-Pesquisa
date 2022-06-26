package com.search.project.model;

public enum MatriculationSituation {

	MATRICULADO("Matriculado"),
	CANCELADO("Cancelado"),
	TRANCADO("Trancado"),
	EVADIDO("Evadido"),
	EGRESSO("Egresso");
	
	private final String nomeExibicao;
	
	private MatriculationSituation(String nomeExibicao) {
		this.nomeExibicao = nomeExibicao;
	}

	public String getNomeExibicao() {
		return nomeExibicao;
	}
}
