package main.java.ua.nure.kn.pankratov.db;

import org.hsqldb.User;

public class DaoFactoryImpl extends DaoFactory{

    @Override
    public Dao<User> getUserDao() {

        try {
            Class daoClass = Class.forName(properties.getProperty(USER_DAO));
            Dao userDao = (Dao) daoClass.newInstance();
            userDao.setConnectionFactory(getConnectionFactory());
            return userDao;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}