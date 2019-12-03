package main.java.ua.nure.kn.pankratov.db;

import org.hsqldb.User;

import java.io.IOException;
import java.util.Properties;

public abstract class DaoFactory {

    protected static final String USER_DAO = "dao.HsqlUserDao";
    protected static final String HSQLDB_USER_DAO = "dao.UserDao";
    protected static Properties properties;


    private static final String CONNECTION_DRIVER = "connection.driver";
    private static final String CONNECTION_URL = "connection.url";
    private static final String CONNECTION_USER = "connection.user";
    private static final String CONNECTION_PASSWORD = "connection.password";
    private static final String PROPERTIES_FILE = "settings.properties";

    private static DaoFactory instance;


    static {
        properties = new Properties();
        try {
            properties.load(DaoFactory.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static DaoFactory getInstance() {
        return instance;
    }


    public abstract Dao<User> getUserDao();

    public static void init(Properties prop) {
        properties = prop;
        instance = null;
    }

    protected ConnectionFactory getConnectionFactory() {
        String driver = properties.getProperty(CONNECTION_DRIVER);
        String url = properties.getProperty(CONNECTION_URL);
        String user = properties.getProperty(CONNECTION_USER);
        String password = properties.getProperty(CONNECTION_PASSWORD);
        return new ConnectionFactoryImpl(driver, url, user, password);
    }




}