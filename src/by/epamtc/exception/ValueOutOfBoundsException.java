package by.epamtc.exception;

public class ValueOutOfBoundsException extends Exception {

    public ValueOutOfBoundsException() {
    }

    public ValueOutOfBoundsException(String message) {
        super(message);
    }

    public ValueOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValueOutOfBoundsException(Throwable cause) {
        super(cause);
    }

}
