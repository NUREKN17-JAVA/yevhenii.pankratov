package test.java.ua.nure.kn.pankratov.db;

import main.java.ua.nure.kn.pankratov.db.ConnectionFactory;
import main.java.ua.nure.kn.pankratov.db.Dao;
import main.java.ua.nure.kn.pankratov.db.DatabaseException;
import main.java.ua.nure.kn.pankratov.domain.User;
import org.dbunit.DatabaseUnitException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

 class MockUserDao implements Dao {
    private Long id = (long) 0;
    private Map users = new HashMap();


    public User create(User user) throws DatabaseException {
        Long currentId = new Long(++id);
        user.setId(currentId);
        users.put(currentId, user);
        return user;
    }


    public void update(User user) throws DatabaseException {
        Long currentId = user.getId();
        users.remove(currentId);
        users.put(currentId, user);
    }


    public void delete(User user) throws DatabaseException {
        Long currentId = user.getId();
        users.remove(currentId);
    }

     @Override
     public Object create(Object entity) throws DatabaseUnitException, DatabaseException {
         return null;
     }

     @Override
     public void update(Object entity) throws DatabaseUnitException, DatabaseException {

     }

     @Override
     public void delete(Object entity) throws DatabaseUnitException, DatabaseException {

     }

     @Override
    public User find(Long id) throws DatabaseException {
        return (User) users.get(id);
    }

    @Override
    public Collection findAll() throws DatabaseException {
        return users.values();
    }

    @Override
    public void setConnectionFactory(ConnectionFactory connectionFactory) {

    }

}
