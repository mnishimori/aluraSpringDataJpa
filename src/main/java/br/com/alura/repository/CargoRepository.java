package br.com.alura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.orm.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer>{

}
