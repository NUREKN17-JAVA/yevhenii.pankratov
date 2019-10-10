package main.java.ua.nure.kn.pankratov.db;

import main.java.ua.nure.kn.pankratov.domain.User;
import org.dbunit.DatabaseUnitException;

import java.util.Collection;

public class HsqldbUserDao implements Dao<User> {

    @Override
    public User create(User entity) throws DatabaseException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(User entity) throws DatabaseException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(User entity) throws DatabaseException {
        // TODO Auto-generated method stub

    }

    @Override
    public User find(User entity) throws DatabaseUnitException {
        return null;
    }

    @Override
    public Collection<User> findAll(User entity) throws DatabaseUnitException {
        return null;
    }

}

