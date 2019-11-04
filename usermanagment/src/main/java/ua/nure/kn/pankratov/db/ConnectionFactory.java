package main.java.ua.nure.kn.pankratov.db;

import java.sql.Connection;

public interface ConnectionFactory {


    Connection getConnection() throws DatabaseException;

}
