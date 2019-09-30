package com.fatec.scel.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
@Entity
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="isbn", nullable = false, length=4)
	@NotEmpty(message="O ISBN deve ser preenchido")
	private String isbn;
	@Column(name="ra", nullable = false, length=4)
	@NotEmpty(message="O RA deve ser preenchido")
	private String ra;
	private String dataEmprestimo;
	private String dataDevolucao;
	private String dataDevolucaoPrevista;
	
	public Emprestimo() {
		
	}
	public Emprestimo(String isbn, String ra) {
		this.isbn = isbn;
		this.ra = ra;
		setDataEmprestimo();
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
	// data do emprestimo - data atual do sistema
	public void setDataEmprestimo() {
		DateTime dataAtual = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		this.dataEmprestimo = dataAtual.toString(fmt);
		setDataDevolucaoPrevista();
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
	private void setDataDevolucaoPrevista() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		DateTime data = fmt.parseDateTime(getDataEmprestimo());
		this.dataDevolucaoPrevista = data.plusDays(8).toString(fmt);
	}
	/**
	 * valida o formato da data
	 * 
	 * @param data
	 *            no formato yyyy/MM/dd
	 * @return true se a data estiver no formato valido e false para formato
	 *         invalido
	 */
	public boolean validaData(String data) {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		df.setLenient(false); //
		try {
			df.parse(data); // data válida
			return true;
		} catch (ParseException ex) {
			return false;
		}
	}

	public boolean ehDomingo(String data) {
		boolean isValida = false;
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy/MM/dd");
		if (validaData(data) == true) {
			DateTime umaData = fmt.parseDateTime(data);
			if (umaData.dayOfWeek().getAsText().equals("Domingo")) {
				isValida = true;
			}
		}
		return isValida;
	}
	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", isbn=" + isbn + ", ra=" + ra + ", dataEmprestimo=" + dataEmprestimo
				+ ", dataDevolucao=" + dataDevolucao + ", dataDevolucaoPrevista=" + dataDevolucaoPrevista + "]";
	}
	
}
