package edu.epam.quadrangle.exception;

public class RepositoryDataException extends Exception {
    public RepositoryDataException() {
        super();
    }

    public RepositoryDataException(String message) {
        super(message);
    }

    public RepositoryDataException(String message, Throwable cause) {
        super(message, cause);
    }
}