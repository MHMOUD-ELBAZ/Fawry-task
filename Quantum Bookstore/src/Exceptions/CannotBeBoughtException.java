package Exceptions;

public class CannotBeBoughtException extends RuntimeException {
    public CannotBeBoughtException(String message) {
        super(message);
    }
}
