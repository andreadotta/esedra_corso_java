package it.esedra.journal.repository;

import org.springframework.data.repository.CrudRepository;

import it.esedra.journal.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
