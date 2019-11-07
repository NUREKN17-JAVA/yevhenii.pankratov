package main.java.ua.nure.kn.pankratov.db;

import main.java.ua.nure.kn.pankratov.domain.User;
import org.dbunit.DatabaseUnitException;

import java.util.Collection;

public interface Dao<T> {
    T create(T entity) throws DatabaseUnitException, DatabaseException;

    void update(T entity) throws DatabaseUnitException, DatabaseException;

    void delete(T entity) throws DatabaseUnitException, DatabaseException;

    T find(Long id) throws DatabaseException;

    Collection<User> findAll() throws DatabaseException;

    void setConnectionFactory(ConnectionFactory connectionFactory);
}
