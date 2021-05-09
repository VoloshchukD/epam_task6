package by.epamtc.exception;

public class NoSuchValueException extends Exception {

    public NoSuchValueException() {
    }

    public NoSuchValueException(String message) {
        super(message);
    }

    public NoSuchValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchValueException(Throwable cause) {
        super(cause);
    }

}
