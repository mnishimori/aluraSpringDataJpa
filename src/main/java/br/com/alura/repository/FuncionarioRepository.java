package br.com.alura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.orm.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

}
