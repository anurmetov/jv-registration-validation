package core.basesyntax.exception;

public class InvalidUserRegistration extends RuntimeException {
    public InvalidUserRegistration(String message) {
        super(message);
    }
}
