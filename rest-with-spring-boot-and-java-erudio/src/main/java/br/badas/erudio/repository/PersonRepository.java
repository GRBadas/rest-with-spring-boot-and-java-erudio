package br.badas.erudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.badas.erudio.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
