package com.fatec.scel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.NaturalId;
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NaturalId
	@Column(nullable = false, length = 4)
	@NotEmpty(message="O ra deve ser preenchido")
	String ra;
	@Column(nullable = false, length = 100)
	@NotEmpty(message="O nome deve ser preenchido")
	String nome;
	@Column(nullable = false, length = 100)
	@NotEmpty(message="O e-mail deve ser preenchido")
	String email;
	
    public Usuario() {
    }
	public Usuario(String ra, String nome, String email) {
		super();
		this.ra = ra;
		this.nome = nome;
		this.email = email;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [ra=" + ra + ", nome=" + nome + ", email=" + email + "]";
	}

}
