package main.java.ua.nure.kn.pankratov.db;

public class DatabaseException extends Exception {
    public DatabaseException(Exception e) {
        super(e);
    }

    public DatabaseException(String string) {
        super(string);
    }
}
