package it.esedra.journal.repository;

import org.springframework.data.repository.CrudRepository;

import it.esedra.journal.entity.Paragraph;

public interface ParagraphRepository extends CrudRepository<Paragraph,Long> {

}
