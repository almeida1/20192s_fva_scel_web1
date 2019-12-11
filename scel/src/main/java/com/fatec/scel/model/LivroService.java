package com.fatec.scel.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LivroService {
	@Autowired
	private LivroRepository livroRepository;

	public Livro save(Livro livro) {
		if (consultaLivro(livro.getIsbn()) == null) {
			return livroRepository.save(livro);
		} else
			return null;

	}

	public Livro consultaLivro(String isbn) {
		return livroRepository.findByIsbn(isbn);
	}
}
