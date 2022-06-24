package com.search.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student extends People {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	private String matricula;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Course curso;
	
	private Integer anoIngresso;
	
	private double coeficienteRendimento;
	
	@Enumerated(EnumType.STRING)
	private MatriculationSituation situacaoMatricula;
	
	public Course getCurso() {
		return curso;
	}
	public void setCurso(Course curso) {
		this.curso = curso;
	}
	public Integer getAnoIngresso() {
		return anoIngresso;
	}
	public void setAnoIngresso(Integer anoIngresso) {
		this.anoIngresso = anoIngresso;
	}
	public double getCoeficienteRendimento() {
		return coeficienteRendimento;
	}
	public void setCoeficienteRendimento(double coeficienteRendimento) {
		this.coeficienteRendimento = coeficienteRendimento;
	}
	public MatriculationSituation getSituacaoMatricula() {
		return situacaoMatricula;
	}
	public void setSituacaoMatricula(MatriculationSituation situacaoMatricula) {
		this.situacaoMatricula = situacaoMatricula;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}
