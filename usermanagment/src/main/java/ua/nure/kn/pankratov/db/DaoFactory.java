package main.java.ua.nure.kn.pankratov.db;

import java.util.Properties;

public class DaoFactory {

    private final Properties properties;

    public DaoFactory() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("settings.properties"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
