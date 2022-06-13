package com.search.model;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

public class Course {

	private Integer codigo;
	
	private String nome;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Teacher coordenador;
	
	private boolean ativo;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Teacher getCoordenador() {
		return coordenador;
	}
	public void setCoordenador(Teacher coordenador) {
		this.coordenador = coordenador;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
