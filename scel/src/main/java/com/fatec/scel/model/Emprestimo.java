package com.fatec.scel.model;

import javax.persistence.*;

@Entity
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="isbn", nullable = false, length=4)
	private String isbn;
	@Column(name="usuario", nullable = false, length=40)
	private String usuario;
	@Column(name="dataEmprestimo", nullable = false)
	private String dataEmprestimo;
	@Column(name="dataDevolucao", nullable = false)
	private String dataDevolucao;
	@Column(name="dataDevolucaoPrevista", nullable = false)
	private String dataDevolucaoPrevista;
	
	public Emprestimo() {
		
	}
	public Emprestimo(String isbn, String usuario, String dataEmprestimo, String dataDevolucao,
			String dataDevolucaoPrevista) {
		super();
		this.isbn = isbn;
		this.usuario = usuario;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
