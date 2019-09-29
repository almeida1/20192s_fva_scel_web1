package com.fatec.scel.model;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmprestimoRepository extends CrudRepository<Emprestimo, Long> {
	//List<Emprestimo> findAllByNomeIgnoreCaseContaining(String nome);

//	@Query(value = "SELECT e FROM Emprestimo e")
//	List<Emprestimo> buscaTodosEmprestimosComOrdenacao(Sort sort);

	@Query(value = "SELECT id FROM Emprestimo ORDER BY dataEmprestimo")
	Stream<Emprestimo> buscaTodosEmprestimos();
}
