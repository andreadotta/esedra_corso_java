package it.esedra.corso.journal.dao;

import java.util.List;

public interface DaoInterface<T> {
	void update();
	void delete();
    List<T> getAll();
}
