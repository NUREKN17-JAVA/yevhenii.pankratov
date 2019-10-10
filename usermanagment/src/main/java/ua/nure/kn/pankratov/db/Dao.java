package main.java.ua.nure.kn.pankratov.db;

import org.dbunit.DatabaseUnitException;

import java.util.Collection;

public interface Dao<T> {
    T create(T entity) throws DatabaseUnitException, DatabaseException;

    void update(T entity) throws DatabaseUnitException, DatabaseException;

    void delete(T entity) throws DatabaseUnitException, DatabaseException;

    T find(T entity) throws DatabaseUnitException;

    Collection<T> findAll(T entity) throws DatabaseUnitException;

}
