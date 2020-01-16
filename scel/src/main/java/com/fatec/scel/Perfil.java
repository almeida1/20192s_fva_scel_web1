package com.fatec.scel;

public enum Perfil {
	ADMIN (1, "ROLE_ADMIN"), ALUNO (2, "ROLE_ALUNO");
	private int cod;
	private String descricao;
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
