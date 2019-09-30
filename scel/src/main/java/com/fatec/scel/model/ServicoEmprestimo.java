package com.fatec.scel.model;


import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoEmprestimo {
	
    @Autowired
    LivroRepository livroRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    public Livro consultaLivro( String isbn) {
    	return livroRepository.findByIsbn(isbn);
    }
    public Usuario consultaUsuario( String ra) {
    	return usuarioRepository.findByRa(ra);
    }
	public Emprestimo empresta(String isbn, String ra) {
		Livro livro = consultaLivro(isbn);
		Usuario usuario = consultaUsuario(ra);
		if (livro == null | usuario == null) {
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
			DateTime dataDevolucaoPrevista = fmt.parseDateTime(emprestimo.getDataEmprestimo());
			emprestimo.setDataDevolucaoPrevista(dataDevolucaoPrevista.plusDays(8).toString(fmt));
			
			return emprestimo;
		}
	}

	/**
	 * Objetivo - verificar se houve atraso na devolucao
	 *
	 * @param umEmprestimo
	 * @return int < 0 se estiver atrasado e > 0 se estiver no prazo
	 *         retorna nulo se o objeto emprestimo é nulo.
	 */
	public Integer verificaAtraso(Emprestimo umEmprestimo) {
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
	
}
