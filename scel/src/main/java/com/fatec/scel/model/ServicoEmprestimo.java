package com.fatec.scel.model;


import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ServicoEmprestimo {
	

	public Emprestimo empresta(String isbn, String ra) {
		if (isbn == null | ra == null) {
			throw new RuntimeException("Dados inválidos.");
		} else {
			Emprestimo emprestimo = new Emprestimo();
			emprestimo.setIsbn(isbn);
			emprestimo.setRa(ra);
			// data do emprestimo - data atual do sistema
			DateTime dataAtual = new DateTime();
			DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
			emprestimo.setDataEmprestimo(dataAtual.toString(fmt));
			
			// prazo de devolucao 8 dias
			DateTime dataDevolucao = fmt.parseDateTime(emprestimo.getDataEmprestimo());
			emprestimo.setDataDevolucao(dataDevolucao.plusDays(8).toString(fmt));
			
			return emprestimo;
		}
	}

	/**
	 * Objetivo - verificar se a devolução esta atrasada
	 *
	 * @param umEmprestimo
	 * @return int < 0 se estiver atrasado e > 0 se estiver no prazo
	 *         retorna nulo se o objeto emprestimo é nulo.
	 */
	public Integer devolucao(Emprestimo umEmprestimo) {
		if (umEmprestimo != null) {
			DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
			DateTime dataAtual = fmt.parseDateTime(new DateTime().toString(fmt));
			DateTime dataDevolucao = fmt.parseDateTime(umEmprestimo.getDataDevolucao());
			int dias = Days.daysBetween(dataAtual, dataDevolucao).getDays();
			return dias;
		} else {
			return null;
		}
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
}
