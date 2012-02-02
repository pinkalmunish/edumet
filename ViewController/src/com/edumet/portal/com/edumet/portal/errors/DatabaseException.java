package com.edumet.portal.com.edumet.portal.errors;

public class DatabaseException extends Exception {
    public DatabaseException(Throwable throwable) {
        super(throwable);
    }

    public DatabaseException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public DatabaseException(String string) {
        super(string);
    }

    public DatabaseException() {
        super();
    }
}
