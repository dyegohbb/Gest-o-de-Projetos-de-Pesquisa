package com.search.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher extends People {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	private LocalDate dataAdmissao;
	
	@Enumerated(EnumType.STRING)
	private KnowledgeArea areaConhecimento;
	
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public KnowledgeArea getAreaConhecimento() {
		return areaConhecimento;
	}
	public void setAreaConhecimento(KnowledgeArea areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	
	
}
