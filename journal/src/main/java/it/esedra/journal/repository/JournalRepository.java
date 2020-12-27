package it.esedra.journal.repository;

import org.springframework.data.repository.CrudRepository;

import it.esedra.journal.entity.Journal;

public interface JournalRepository extends CrudRepository<Journal, Long> {

}
