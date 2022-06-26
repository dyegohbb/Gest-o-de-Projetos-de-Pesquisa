package com.search.project.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class SearchProject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	private String titulo;
	
	private String resumo;
	
	private String detalhes;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Teacher responsavel;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Student> colaboradores;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInicio;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public Teacher getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Teacher responsavel) {
		this.responsavel = responsavel;
	}
	public List<Student> getColaboradores() {
		return colaboradores;
	}
	public void setColaboradores(List<Student> colaboradores) {
		this.colaboradores = colaboradores;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
}
