package main.java.ua.nure.kn.pankratov.db;

import java.sql.SQLException;

public class DatabaseException extends Exception {

    private static final long serialVersionUID = 2591478376663515645L;

    public DatabaseException(SQLException e) {
        super(e);
    }

    public DatabaseException(String string) {
        super(string);
    }
}
