package com.search.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class SearchProject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	private String titulo;
	
	private String resumo;
	
	private byte[] arquivoPDF;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Teacher responsavel;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Student> colaboradores;
	
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
	public byte[] getArquivoPDF() {
		return arquivoPDF;
	}
	public void setArquivoPDF(byte[] arquivoPDF) {
		this.arquivoPDF = arquivoPDF;
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
	
	
}
