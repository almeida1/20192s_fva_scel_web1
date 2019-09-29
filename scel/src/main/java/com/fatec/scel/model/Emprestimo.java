package com.fatec.scel.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="isbn", nullable = false, length=4)
	@NotEmpty(message="O isbn deve ser preenchido")
	private String isbn;
	@Column(name="ra", nullable = false, length=4)
	private String ra;
	
	private String dataEmprestimo;
	
	private String dataDevolucao;

	private String dataDevolucaoPrevista;
	
	public Emprestimo() {
		
	}
	public Emprestimo(String isbn, String ra) {
		super();
		this.isbn = isbn;
		this.ra = ra;
		
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public String getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}
	public void setDataDevolucaoPrevista(String dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}
	
	
}
